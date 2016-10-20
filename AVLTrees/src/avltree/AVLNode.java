package avltree;
import binarytree.BinaryTree;
import binarytree.Position;
import binarysearchtree.BSTNode;
/**
 * An AVLNode represents a node in a linked representation of a binary search tree.</br>
 * It provides a attribute field for storing balance information (such as height).
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
public class AVLNode<E> extends BSTNode<E> {

    private int attribute;
    
    protected AVLNode(BinaryTree<E> owner, E content) {
        super(owner, content);
    }
    
    /**
     * Obtain the value of this nodes attribute.
     */
    protected int getAttrib() { return attribute; }
    /**
     * Set the value of this node's attribute and return the old value.
     */
    protected int setAttrib(int attribute) {
        final int old=this.attribute;
        this.attribute=attribute;
        return old;
    }
    
}
