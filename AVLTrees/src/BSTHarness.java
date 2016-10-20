import java.util.Scanner;
import binarytree.BinaryTreeWriter;
import binarytree.SimpleTreeWriter;
//
import binarysearchtree.BinarySearchTree;
import binarysearchtree.LinkedBST;
//
import java.util.Comparator;
/**
 * Asks the user to input a sequence of integers, constructs a SimpleBST from them, and prints
 * it out.
 * 
 * @author Stephan Jamieson 
 * @version 25/2/2015
 */
public class BSTHarness {

    private BSTHarness() {}
    
    private class IntComparator implements Comparator<Integer> {
        
        public int compare(Integer i1, Integer i2) {
            return i1.compareTo(i2);
        }
    }

    private void run() {
        System.out.print("Enter a comma separated sequence of node values: ");
        Scanner scanner = new Scanner(System.in);
        scanner = new Scanner(scanner.nextLine()).useDelimiter("\\s*,\\s*");
        final IntComparator comparator = new IntComparator();

        LinkedBST<Integer> tree = new  LinkedBST<Integer>(comparator);
        
        while (scanner.hasNextInt() ){
            tree.insert(scanner.nextInt());
        }
        BinaryTreeWriter<Integer> writer = new SimpleTreeWriter<Integer>(System.out);
        writer.print(tree);
        //14, 10, 12, 6, 22, 16
        
        tree.restructure(tree.find(22));
        writer.print(tree);
        
        scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            tree.insert(tree.getContent(tree.find(scanner.nextInt())));
            writer.print(tree);
           
        }
        
    }
    
    public static void main(String args[]) {
        (new BSTHarness()).run();
        
    }
}