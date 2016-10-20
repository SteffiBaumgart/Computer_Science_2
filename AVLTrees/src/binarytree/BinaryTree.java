package binarytree;


/**
 * Abstract data type for a binary tree.
 * 
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
public interface BinaryTree<E> {
    
    /**
     * Determine whether the tree is empty.
     */
    boolean isEmpty();
    
    /**
     * Obtain the position of the root node.
     */
    Position<E> root();

    /**
     * Determine whether the given position relates to this tree.
     */
    boolean isValid(Position<E> p);
    
    /**
     * Determine whether the node at the given position is at the root of the tree
     */
    boolean isRoot(Position<E> p);
    
    /**
     * Determine whether the node at the given position is a leaf.
     */
    boolean isLeaf(Position<E> p); 

    /**
     * Determine whether the node at the given position has a left child.
     */
    boolean hasLeft(Position<E> p);
    /**
     * Determine whether the node at the given position has a right child.
     */
    boolean hasRight(Position<E> p);

    /**
     * Obtain the position of the parent of the node at the given position.
     */
    Position<E> getParent(Position<E> p);    
    
    /**
     * Obtain the position of the left child of the node at the given position.
     */
    Position<E> getLeft(Position<E> p);
    
    /**
     * Obtain the position of the right child of the node at the given position.
     */
    Position<E> getRight(Position<E> p);
    
    /**
     * Obtain the content of the node at the given position.
     */
    E getContent(Position<E> p);
    
    /**
     * Obtain the number of nodes in the tree.
     */
    int size(Position<E> p);

    /**
     * Determine whether the tree contains the given element.
     */
    boolean contains(E element);
    
    /**
     * Obtain the position of the node containing the given element.</br>
     * If the element is not within the tree then the position of the leaf at which the search ended is returned.</br>
     * If the tree is empty then null is returned.
     */
    Position<E> find(E element);
}
