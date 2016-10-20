import java.io.FileReader;
//
import graph.Vertex;
import graph.Graph;
//
import utils.ClusterBuilder;
//
import java.io.FileNotFoundException;
//
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * Solver for Lewis Carrol's Doublets game.
 *
 */
 public class DoubletSolver{
 	public static void main(String[] args){


	String file =  args[0];
	List<String> ans;
	String w1 = "";
	String w2 = "";
	String [] data;

	try {

		Doublets d = new Doublets(file);
		Scanner scanf = new Scanner(System.in);
		System.out.print("Enter a doublet (two words separated by a comma), or 'quit': ");

		String inp = scanf.nextLine();

		while(!inp.equalsIgnoreCase("quit")){

			//replaces space with nothing
			inp = inp.replaceAll("\\s+","");
			data = inp.split(",");

			w1 = data[0];
			w2 = data[1];

			ans = null;
			if(d.solve(w1,w2)!=null){
			ans = d.solve(w1,w2);}


			String length1 = "" + w1.length();
			String length2 = "" + w2.length();

			/*if (!length1.equals(length2)) {
				System.out.print("Sorry, words must be " + length1 + " letters long.");
			} */


			if (ans == null) {
				//return empty list if insuff
				System.out.println("Sorry, insufficient data.");
			}

			else {
				for (String s : ans) {

					System.out.println(s.toUpperCase());

				}
			}


			System.out.println("Enter a doublet (two words separated by a comma), or 'quit': ");
            inp = scanf.nextLine();

		}
	}

	catch (FileNotFoundException e) {
		System.exit(0);
	}


 	}


 }
