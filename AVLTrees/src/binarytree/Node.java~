package binarytree;
/**
 * A Node object implements a linked binary tree node.
 * 
 * @author Stephan Jamieson 
 * @version 2/3/2016
 */
public class Node<E> implements Position<E> {

    private final BinaryTree<E> owner;
    
    /**
     * Obtain the tree to which this position relates.
     */
    public BinaryTree<E> getOwner(){ return this.owner; }

    private Node<E> parent;
    private Node<E> left;
    private Node<E> right;
    private E content;
    
    /**
     * Create a node for the given tree and containing the given data.
     */
    protected Node(BinaryTree<E> owner, E content) {
        this.owner=owner;
        this.parent=parent;
        this.left=left;
        this.right=right;
        this.content=content;
    }
    
    /**
     * Obtain the position of this node.
     */
    public Position<E> getPosition() { return this; }
    
    /**
     * Determine whether this node has a parent.
     */
    public  boolean hasParent() { return this.parent!=null; }

    /**
     * Determine whether this node has a left child.
     */
    public boolean hasLeft() { return this.left!=null; }
    /**
     * Determine whether this node has a right child.
     */
    public boolean hasRight() { return this.right!=null; }
    /**
     * Determine whether this node is a leaf (i.e. has no children).
     */
    public boolean isLeaf() { return this.left==null && this.right==null; }

    /**
     * Obtain the content of this node.
     */
    public E getContent() { return this.content; }
    
    /**
     * Obtain this node's parent.
     */
    protected Node<E> getParent() { return this.parent; }
    /** 
     * Obtain this node's left child.
     */
    protected Node<E> getLeft() { return this.left; }
    /**
     * Obtain this node's right child.
     */
    protected Node<E> getRight() { return this.right; }
        
    /**
     * Set the content of this node and return the old value.
     */
    protected E setContent(E content) {
        final E old = this.content;
        this.content=content;
        return old;
    }          

    /**
     * Set this node's parent and return the old value.
     */
    protected Node<E> setParent(Node<E> node) {
        final Node<E> oldParent = this.parent;
        this.parent=node;
        return oldParent;
    }
    /**
     * Set this node's right child and return the old value.
     */
    protected Node<E> setLeft(Node<E> node) {
        final Node<E> oldLeft = this.left;
        this.left=node;
        return oldLeft;
    }
    
    /**
     * Set this node's left child and return the old value.
     */
    protected Node<E> setRight(Node<E> node) {
        final Node<E> oldRight = this.right;
        this.right=node;
        return oldRight;
    }

}
