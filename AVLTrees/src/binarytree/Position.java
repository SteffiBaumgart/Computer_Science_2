package binarytree;

/**
 * A Position represents a node position within a binary tree.
 * 
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
public interface Position<E> {

    /**
     * Obtain the content of the node at this position.
     */
    E getContent();
    
    /**
     * Obtain the tree to which this position relates.
     */
    BinaryTree<E> getOwner();
}
