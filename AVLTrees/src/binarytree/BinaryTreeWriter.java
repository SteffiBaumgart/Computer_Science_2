package binarytree;
import java.io.PrintStream;

/**
 * An abstraction of a type of object that can print a BinaryTree.
 * 
 * @author Stephan Jamieson 
 * @version 2/3/2016
 */
public interface BinaryTreeWriter<E> {

    /**
     * Set the destination for the tree printing.
     */
    void setDestination(PrintStream printStream);
    
    /**
     * Print the given tree.
     */
    public void print(BinaryTree<E> tree);
    
}
