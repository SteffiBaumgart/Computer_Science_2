 import  java.lang.Math;
 import  java.util.*;
 import  java.io.PrintStream;
 import  java.text.DecimalFormat;

 public class SimpleTreeWriterImpl implements SimpleTreeWriter{
 PrintStream stream;


//Constructor
 public SimpleTreeWriterImpl(PrintStream stream){
     setDestination(stream);
 }
 
 public void setDestination(PrintStream stream) {
     this.stream = stream; 
} 

 
 public void write(BinaryTreeNode tree)
    { 
       List <BinaryTreeNode> l = TreeUtils.levelZero(tree);   
       
	int height = tree.getHeight();
	String largest = tree.getLargest() + "";
	int holder = largest.length();
	String padding = "";
	String nullItem = "";
        DecimalFormat df = new DecimalFormat(padding);


        for (int i = 0; i < holder; i++)
        {
            padding += "0";
            nullItem += " ";
        }
    

        
        for (int L = 0; L < height; L++) {   

            //Needs to re-initialize every time
            String Lblank = "";
            String INBblank = "";
            String INBdash = "";

            int Lformula = (int)Math.floor(((Math.pow(2,height - L) - 2) / 2) * holder);
            int Bformula = (int)Math.floor((Math.pow(2,height - L) - 1) * holder);


            for (int k = 0; k < Bformula ; k++)
	   {
		INBdash += "-";
		INBblank += " ";
	   }

            for (int i = 0; i < Lformula ; i++)
            {
                Lblank += " ";
            }


            //if First Level, only one node
            if (L == 0) {
                stream.print(Lblank);
                stream.print(df.format(l.get(L).getItem()));
            }


            else {
                stream.print(Lblank);
               
                for (int i = 0; i < l.size(); i++) {

                
		           if (l.get(i).getItem() == null)
		            {
		                 stream.print(nullItem);
		            }

		           else
		            {  
                                 stream.print(df.format(l.get(i).getItem()));
		               
		            }


		           if (i != l.size() - 1)
		           {

                                //Even -> dashes
		                if (i%2 == 0)
		                {
		                    stream.print(INBdash);
		                }

                                //Odd -> spaces
		                else
		                {
		                    stream.print(INBblank);
		                }
                    }
                }

                stream.print(Lblank);

            }
            
            //Move one level down 
            l = TreeUtils.nextLevel(l);
            stream.println("");
             
        }

    } 
} 

