package avltree;
import binarytree.BinaryTree;
import binarytree.Position;
import binarysearchtree.LinkedBST;
//
import java.util.Comparator;
/**
 * An AVLTree is an implementation of binarysearchtree.BinaySearchTree that automatically 
 * performs AVL rebalancing after insertion and deletion of elements.
 * 
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
public class AVLTree<E> extends LinkedBST<E>  {

    /**
     * Create a new AVLNode containing the given element.</br>
     * Methods that create nodes MUST use this.</br> 
     * This method overrides that in LinkedBinaryTree.</br>
     */
    @Override
    protected AVLNode<E> makeNode(E element) {
        return new AVLNode<E>(this, element);
    }

    @Override
    @SuppressWarnings("unchecked")
    /**
     * Convenience method for obtaining the BSTNode associated with a given position.
     */
    protected AVLNode<E> getNode(Position<E> p) {
        assert(p.getOwner()==this);
        return (AVLNode<E>)p;
    }
    
    /**
     * Create an AVLTree that uses the given comparator to order its elements.
     */
    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }
    
    @Override
    /**
     * Insert the given element into the tree, rebalancing if necessary, and return the 
     * position of the new node.</br>
     * If an instance of element is already in the tree then this method overwrites it with the given value. (Useful when implementing a map.)
     */
    public Position<E> insert(E element) {
		// Your code here
		return null;
    }

    @Override
    /**
     * Locate and remove the given element from the tree, returning the position of its parent or <code>null</code> if root.
     */    
    public Position<E> delete(E element) {
     return null;
    }
}
