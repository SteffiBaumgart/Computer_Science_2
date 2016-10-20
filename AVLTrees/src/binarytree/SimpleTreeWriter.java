package binarytree;
import java.io.PrintStream;
/**
 * An implementation of BinaryTreeWriter. </br>
 * To illustrate the intended output format, assume we have a BinarySearchTree 
 * containing the values 14, 10, 12, 6, 22, 16:</br>
 * <pre>
 * |  
 * |__14
 *    |  
 *    |__22
 *    |  |__
 *    |  |  
 *    |  |__16
 *    |     |__
 *    |     |__
 *    |  
 *    |__10
 *       |  
 *       |__12
 *       |  |__
 *       |  |__
 *       |  
 *       |__6
 *          |__
 *          |__
 * </pre>
 * This tree has a root value of 14, root's right hand child has the value 22, it's left hand child has the
 * value 10...</br>
 * Children are printed below the parent.</br>
 * The right child is printed before the left.</br>
 *
 * @author Stephan Jamieson 
 * @version 2/3/2016
 */

public class SimpleTreeWriter<E> implements BinaryTreeWriter<E> {
PrintStream stream; 
    /**
     * Create a SimpleTreeWriter that outputs to the given PrintStream.
     */
    public SimpleTreeWriter(PrintStream p) { this.setDestination(p); }
    
    /**
     * Set the destination PrintStream.
     */
    public void setDestination(PrintStream p) { 
		this.stream = p; 
	}
    
    /**
     * Print the given tree.
     */
    
     public void print(BinaryTree<E> t){

       String prefix = ""; 
       myprint(t,prefix,t.root()); 
     }



    public void myprint(BinaryTree<E> t, String prefix, Position<E> pos) {
   
   String front = "";
    try
        {
 
    //for (int i = 0; i<prefix.length(); i++){
   // front += " "; }

    System.out.print(prefix + "|\n"); 
    System.out.println(prefix + "|__" + t.getContent(pos));
    
   
    
    
    if(t.root()== null)
    {System.out.println("|__");
    System.exit(0);}
  
    if( t.isRoot(pos) || t.getLeft(t.getParent(pos)) == pos) {
    	prefix = prefix + "   " ; }
    
    else { prefix = prefix + "|  " ; }



    if( t.hasRight(pos)) {
    	myprint(t, prefix, t.getRight(pos)); }

    else { System.out.println(prefix + "|__");}



    if( t.hasLeft(pos)) {
    	myprint(t, prefix, t.getLeft(pos)); }

    else { System.out.println(prefix +"|__");}
 
        } 
    
    
    
    catch (NullPointerException e) {System.out.println("|__");}
 }
}



