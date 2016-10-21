

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


public class PersonMover extends Thread {
	public static int IDcounter=0;
	private Person thisPerson;
	public static RoomGrid grid; //shared grid
	private Random rand;
	private PeopleCounter counter;
	public CyclicBarrier bar;
	private BlockingQueue bq;

    //ADDED
	//PartyApp ap = new PartyApp();
	//boolean paused = PartyApp.paused;

	public volatile static boolean done=false; //add stop button
	//static boolean paused =  PartyApp.paused; ;
	
	private int ID; //thread ID for debugging
	
	PersonMover( Person janeDoe) {
		thisPerson = janeDoe;
		rand = new Random();	

		synchronized (PersonMover.class) {
			ID=IDcounter;
			PersonMover.IDcounter++;
			}
	}

	PersonMover( Person creature, PeopleCounter score, CyclicBarrier bar, BlockingQueue bq) {
		this(creature);
		this.counter=score;
        this.bar = bar;
		this.bq = bq;
	}
	

	
	private void headForRefreshments() {  //next move towards bar
		//no need to change this function
		int x_mv=-1;
		int y_mv=-1;
		GridBlock nextBlock =null;
		while (nextBlock==null) { // repeat until hit on empty cell
			
			x_mv= rand.nextInt(3)-1+thisPerson.getX();
			if (x_mv<0) x_mv=0;
			
			y_mv=thisPerson.getY()+1;
			if (y_mv<0) y_mv=0;		
			else if (y_mv>=grid.getMaxY()) y_mv=grid.getMaxY()-1;	
			
			if (!((x_mv==thisPerson.getX())&&(y_mv==thisPerson.getY()))) {
				nextBlock=grid.getBlock(x_mv,y_mv);
			} 
		}	
		thisPerson.moveToBlock(nextBlock);
	}
	
	private void mingle() { //random next move
		//no need to change this function
		int x_mv=-1;
		int y_mv=-1;
		GridBlock nextBlock =null;
		while (nextBlock==null) { // repeat until hit on empty cell
			x_mv= rand.nextInt(3)-1+thisPerson.getX();
			if (x_mv<0) x_mv=0;
			y_mv=rand.nextInt(3)-1+thisPerson.getY();
			if (y_mv<0) y_mv=0;		
			if (!((x_mv==thisPerson.getX())&&(y_mv==thisPerson.getY()))) {
					//System.out.println("moving from x="+x+" y="+y); //debug
					//System.out.println("moving to x="+x_mv+" y="+y_mv); //debug
				nextBlock=grid.getBlock(x_mv,y_mv);

				//People must NOT go to the entrance block
				while(nextBlock== grid.getEntranceBlock()){
					nextBlock = grid.getBlock(rand.nextInt(3)-1+thisPerson.getX(),rand.nextInt(3)-1+thisPerson.getY());

				}
			} 
		}	
		thisPerson.moveToBlock(nextBlock);
		
	}
	
	public void run() {
		//TODO - add code so threads wait until other threads are ready before starting
		//TODO add code to allow for pausing



		try {
			bar.await();

			while(true){
				sleep(rand.nextInt(10000)); //time till arriving at party
				if(!PartyApp.paused){
					break;
				}
			}

            counter.personArrived(); //add to counter

			bq.put(thisPerson);




			GridBlock firstBlock = grid.getEntranceBlock(); //enter through entrance
            assert (firstBlock != null);


            synchronized (firstBlock) {
                //below does not work - FIX
                firstBlock.waitBlock(); //threads should wait until first block is free
                bq.take();

                thisPerson.initBlock(firstBlock);
                counter.personEntered(); //add to counter

				while(true){
					sleep(thisPerson.getSpeed());
					if(!PartyApp.paused){
						break;
					}
				}

            }

		}

        //changed to Exception e to accept any exception
		catch (Exception e) {
			done=true;
		}

		while ((!done)&&(thisPerson.inRoom())) {

			try {

				while(!PartyApp.paused) {


					if (thisPerson.thirsty()) {
						if (thisPerson.atRefreshmentStation()) {


							//while (true) {
								sleep(thisPerson.getSpeed() * 4);//drinking for a while
								//if (!PartyApp.paused) {
								//	break;
								//}
							//}


							thisPerson.drink();
						} else headForRefreshments();
					} else if (thisPerson.atExit()) {
						thisPerson.leave();
					} else {
						mingle();
					}

					//while (true) {
						sleep(thisPerson.getSpeed());
						//if (!PartyApp.paused) {
						//	break;
						//}
					}
				}
			
			catch (Exception e) {
				System.out.println("Thread "+this.ID + "interrrupted."); 
				done=true;
			} 
		}
		counter.personLeft(); //add to counter
	
	}
	
}
