package binarytree;
import binarytree.Position;
//
import java.util.Comparator;

/**
 * A linked node implementation of BinaryTree.
 * 
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
public abstract class LinkedBinaryTree<E> implements BinaryTree<E> {

    /**
     * Method for creating a new linked node object (must be overridden by sub classes).
     */
    protected Node<E> makeNode(E element) {
        return new Node<E>(this, element);
    }
    
    @SuppressWarnings("unchecked")
    /**
     * Convenience method for obtaining a Position for a Node (must be overridden by sub classes).
     */
    protected Node<E> getNode(Position<E> p) { return (Node<E>)p; }
    
    private Node<E> root;
    
    /**
     * Create an empty binary tree.
     */
    public LinkedBinaryTree() { 
        this.root=null;
    }

    /**
     * Determine whether the tree is empty.
     */
    public boolean isEmpty() { return this.root==null; }
    
    /**
     * Determine whether the node at the given position is at the root of the tree
     */
    public boolean isRoot(Position<E> p) { return this.root==p; }
    
    /**
     * Obtain the position of the root node.
     */
    public Position<E> root() { return this.root; }

    /**
     * Obtain the position of the parent of the node at the given position.
     */    
    public Position<E> getParent(Position<E> p) { return getNode(p).getParent(); }
    
    /**
     * Determine whether the node at the given position has a left child.
     */
    public boolean hasLeft(Position<E> p) { return getNode(p).hasLeft(); }

    /**
     * Obtain the position of the left child of the node at the given position.
     */
    public Position<E> getLeft(Position<E> p) { return getNode(p).getLeft(); }
    
    /**
     * Determine whether the node at the given position has a right child.
     */    
    public boolean hasRight(Position<E> p) { return getNode(p).hasRight(); }

    /**
     * Obtain the position of the right child of the node at the given position.
     */
    public Position<E> getRight(Position<E> p) { return getNode(p).getRight(); }
    
    /**
     * Determine whether the node at the given position is a leaf.
     */
    public boolean isLeaf(Position<E> p) { return getNode(p).isLeaf(); }

    /**
     * Determine whether the given position relates to this tree.
     */
    public boolean isValid(Position<E> p) { return p.getOwner()==this; }
    
    /**
     * Obtain the content of the node at the given position.
     */
    public E getContent(Position<E> p) { return p.getContent(); }

    /**
     * Determine whether the tree contains the given element.
     */
    public boolean contains(E element) {
        Position<E> p = find(element);
        return (p.getContent().equals(element));
    }
    
    /**
     * Obtain the position of the node containing the given element.</br>
     * If the element is not within the tree then the position of the leaf at which the search ended is returned.</br>
     * If the tree is empty then null is returned.</br>
     * A sub class must implement this method.
     */
    abstract public Position<E> find(E element);
    
    /**
     * Obtain the number of nodes in the tree.
     */
    public int size(Position<E> p) {
        if (p==null) {
            return 0;
        }
        else {
            return size(getLeft(p))+size(getRight(p))+1;
        }
    }
        
    /**
     * Insert the given value into the root of the tree and returns the position of the new node.</br>
     * (Requires that the tree is empty.)
     */
    protected Position<E> insertRoot(final E value) {
        assert(this.isEmpty());
        final Node<E> root = makeNode(value);
        return root;
    }

    /**
     * Set the node at the given position to be the new root of the tree.
     */
    protected void setRoot(final Position<E> p) {
        root=getNode(p);
    }
    
    /**
     * Delete the node at the given position and return the position of its parent (or null if root).</br>
     * Requires that the node has less than 2 children.
     */ 

    /**
     * Locate and remove the given element from the tree, returning the position of its parent or <code>null</code> if root.
     * If the element is not found, then the delete method should return null. (The two cases can be disambiguated if the
     * user calls 'contains' first.)  
      */  

    protected Position<E> delete(final Position<E> p) {

    
    Node<E> curr = (Node<E>)p;
    Node<E> par = curr.getParent();

        
        //invalid position
        try {

        //Empty tree 
        if (this.isEmpty() || !this.isValid(p)){
            return null; }


        //Root cases
        else if (this.isRoot(curr)) {

            //No children
            if (!curr.hasLeft() && !curr.hasRight()) {
                this.setRoot(null); }
            
            //Left child only 
            else if (curr.hasLeft() && !curr.hasRight()){
                this.setRoot(curr.getLeft()); }
            
            //Right child only 
            else if (curr.hasRight() && !curr.hasLeft()) {   
                this.setRoot(curr.getRight()); }
            
            //2 children 
            else {
                if (curr.hasLeft() && curr.hasRight()) {

                this.setRoot(curr.getRight());
                curr.getLeft().setParent(curr.getRight());
                curr.getRight().setLeft(curr.getLeft()); }

            }
        }
        
        //Internal Nodes 
        else {
                if (!curr.hasLeft() && !curr.hasRight())
                {
                        if (curr == par.getLeft())
                        {
                            par.setLeft(null);
                        }
                        else
                        {
                            if (curr == par.getRight())
                            {
                                par.setRight(null);
                            }
                        }
                    }
                
                
                else if (curr.hasLeft() && curr.hasRight())
                {
                    
                    
                    if (curr == par.getLeft())
                    {
                        par.setLeft(curr.getRight());
                        curr.getRight().setParent(par);
                        curr.getRight().setLeft(curr.getLeft());
                        curr.getLeft().setParent(curr.getRight());
                    }

                    else { 
                         if (curr == par.getRight()) {

                        par.setRight(curr.getLeft());
                        curr.getLeft().setParent(par);
                        curr.getLeft().setRight(curr.getRight());
                        curr.getRight().setParent(curr.getLeft());

                         }   
                    }
                }

                else if (curr.hasLeft())
                { 

                    if (curr == par.getLeft())
                    {
                        par.setLeft(curr.getLeft());
                        curr.getLeft().setParent(par);
                    }

                    else {

                        if (curr == par.getRight()) {
                        par.setRight(curr.getLeft());
                        curr.getLeft().setParent(par);
                       }

                   }

                }

                else {
                    
                    if (curr.hasRight()) {   
                    
                        if (curr == par.getLeft())
                        {
                            par.setLeft(curr.getRight());
                           curr.getRight().setParent(par);
                        }

                        else {

                            if (curr == par.getRight())
                            {
                                par.setRight(curr.getRight());
                                curr.getRight().setParent(par);
                            }
                        }
                    }

                }     
    
            }
        return (Position<E>) curr;

        } 

        catch (NullPointerException e) {return null;}
    }
    










/*
    protected Position<E> delete(final Position<E> p) { 

		curr = getNode(p);


        //If tree is empty, only the root node exists, or the position doesn't exist
        if (t.isEmpty() || t.size()==1 || t.isValid(p)==false)
            { t.setRoot(null); 
             return null; }


        //if Root - 3 cases
        if(curr.isRoot()){

            if(curr.hasRight() && curr.hasLeft()){
              return null; }

            if(curr.hasLeft()  && !curr.hasRight()){
             curr.setLeft(null); }

            if(curr.hasRight()  && !curr.hasLeft()){
             curr.setRight(null); } }


         else { 

            if(curr.isLeaf() && curr.getParent().hasLeft()  && !curr.getParent().hasRight()) {
                curr.setParent(null);
                curr.getParent().setLeft(null);}


            if(curr.isLeaf() && curr.getParent().hasRight() && !curr.getParent().hasLeft())) {
                curr.setParent(null);
                curr.getParent().setLeft(null);}}


            if(curr.isLeaf() && curr.getParent().hasRight() && curr.getParent().hasLeft())) {
                curr.setParent(null);
                curr.getParent().setLeft(null);}}
                            
           


        


		return null;
    } */



    
    /**
     * Swap the contents of the given nodes.
     */
    protected void swap(Node<E> n1, Node<E> n2) {
        n2.setContent(n1.setContent(n2.getContent()));
    }
        
    /**
     * Swap the contents of the nodes at the given positions.
     */
    protected void swap(Position<E> p1, Position<E> p2) {
        this.swap(getNode(p1), getNode(p2));
    }
    


}
