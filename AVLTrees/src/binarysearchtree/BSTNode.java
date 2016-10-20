package binarysearchtree;
import binarytree.BinaryTree;
import binarytree.Position;
import binarytree.Node;
/**
 * A BSTNode represents a node in a linked representation of a binary search tree.</br>
 * Most of the methods are documented in the binarytree.Node superclass.
 * 
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
public class BSTNode<E> extends Node<E> {

    protected BSTNode(BinaryTree<E> owner, E content) {
        super(owner, content);
    }
    
    @SuppressWarnings("unchecked")
    protected BSTNode<E> getParent() { return (BSTNode<E>)super.getParent(); }
    @SuppressWarnings("unchecked")
    protected BSTNode<E> getLeft() { return (BSTNode<E>)super.getLeft(); }
    @SuppressWarnings("unchecked")
    protected BSTNode<E> getRight() { return (BSTNode<E>)super.getRight(); }
      
    protected E setContent(E content) { return super.setContent(content); }
    protected BSTNode<E> setParent(BSTNode<E> node) { return (BSTNode<E>)super.setParent(node); }
    protected BSTNode<E> setLeft(BSTNode<E> node) { return (BSTNode<E>)super.setLeft(node); }
    protected BSTNode<E> setRight(BSTNode<E> node) { return (BSTNode<E>)super.setRight(node); }

}
