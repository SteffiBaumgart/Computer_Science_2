package binarysearchtree;
//
import binarytree.BinaryTree;
import binarytree.Position;
// 
import java.util.Comparator;
//
/**
 * A BinarySearchTree is an ordered binary tree. Elements are ordered according to a java.util.Comparator (provided by implementing classes).
 * 
 * 
 * @author Stephan Jamieson 
 * @version 2/3/2016
 */
public interface BinarySearchTree<E> extends BinaryTree<E> {

    /**
     * Obtain the java.util.Comparator used to order the elements in this tree.
     */
    Comparator<E> getComparator();
    
    /**
     * Inserts the given element in the tree and returns the position of the new node.
     */
    Position<E> insert(E element);
    
    /**
     * Locate and remove the given element from the tree, returning the position of its parent or <code>null</code> if root.
     */
    Position<E> delete(E element);
    
    /**
     * Perform a single rotation of the node at position p (i.e. rotate the node at position p above its parent.)and return the new position of the parent </br>
     * Requires that position p does not refer to the root.
     */
    Position<E> rotate(Position<E> p);
    
    /**
     * Apply the tri-node restructuring algorithm at position p, returning the position of the new (sub) tree root.</br>
     * Requires that position p has a grandparent.
     */
    Position<E> restructure(Position<E> p);

}
