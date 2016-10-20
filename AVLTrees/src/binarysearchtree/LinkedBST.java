package binarysearchtree;

import binarytree.LinkedBinaryTree;
import binarytree.Node;
import binarytree.Position;
//
import java.util.Comparator;

/**
 * A linked implementation of BinarySearchTree.
 *
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
public class LinkedBST<E> extends LinkedBinaryTree<E> implements BinarySearchTree<E>
{

    /**
     * Create a new BSTNode containing the given element.</br>
     * Methods that create nodes MUST use this.</br> 
     * This method overrides that in LinkedBinaryTree.</br>
     * Subclasses of this class must override it.
     */
    @Override
    protected BSTNode<E> makeNode(E element) {
        return new BSTNode<E>(this, element);
    }
    
    @SuppressWarnings("unchecked")
    /**
     * Convenience method for obtaining the BSTNode associated with a given position.
     */
    protected BSTNode<E> getNode(Position<E> p) { 
        assert(p.getOwner()==this);
        return (BSTNode<E>)p; 
    }
  
    // Comparator used to order nodes.
    private Comparator<E> comparator;

    /**
     * Create a new LinkedBST that orders its elements using the given Comparator.
     */
    public LinkedBST(Comparator<E> comparator) { 
        super();
        this.comparator=comparator; 
    }
    
    /**
     * Obtain the Comparator used by this LinkedTree to order its elements.
     */
    public Comparator<E> getComparator() { return comparator; }
        
    @Override
    /**
     * Obtain the position of the node containing the given element.</br>
     * If the element is not within the tree then the position of the leaf at which the search ended is returned.</br>
     * If the tree is empty then null is returned.
     */
    public Position<E> find(E element) {
        if (this.isEmpty()) {
            return null;
        }
        else {
            BSTNode<E> node = getNode(root());
            while (true) {
                final int test = comparator.compare(element, node.getContent());
                if (test==0||test<0&&!node.hasLeft()||test>0&&!node.hasRight()) {
                    return node;
                }
                else {
                    node = test<0&&node.hasLeft() ? node.getLeft() : node.getRight();
                }
            }        
        }    
    }
    
    /**
     * Inserts the given element in the tree and returns the position of the new node.</br>
     * If an instance of element is already in the tree then this method overwrites it with the given value. (Useful when implementing a map.)
     */
    public Position<E> insert(E element){
        if (this.isEmpty()) {
            this.setRoot(makeNode(element));
            return root();
        }
        else {
            final Position<E> position = find(element);        
            final BSTNode<E> node = getNode(position);
            final int compResult = comparator.compare(element, position.getContent());

            if (compResult==0) {
                node.setContent(element);
                return position;
            }
            else {
                final BSTNode<E> leaf = makeNode(element);
                leaf.setParent(node);
                
                if (compResult<0) {
                    node.setLeft(leaf);
                }
                else {
                    node.setRight(leaf);
                }
                return leaf;
            }
        }   
    }
    
    /**
     * Locate and remove the given element from the tree, returning the position of its parent or <code>null</code> if root.
     */
   @Override
    public Position<E> delete(E element)
    {
        Position<E> p = this.find(element);
        BSTNode<E> curr = getNode(this.find(element));
        BSTNode<E> par = curr.getParent();
        
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
  
    
    /**
     * Perform a single rotation of the node at position p (i.e. rotate the node at position p above its parent.)and return the new position of the parent </br>
     * Requires that position p does not refer to the root.
     */
    public Position<E> rotate(Position<E> p){
        
        BSTNode<E> curr = this.getNode((BSTNode<E>)p);
        BSTNode<E> parent = null; 
        
        if (curr.hasParent()){
       	 parent = curr.getParent();}
         
        if(parent!= null && parent.getLeft() == curr){  
           this.rightRotate(curr);}
        
        else if (parent!= null && parent.getRight() == curr){
           this.leftRotate(curr);} 
         
		
          return curr.getPosition();      
    }

    /**
     * Apply the tri-node restructuring algorithm at position p, returning the position of the new (sub) tree root.</br>
     * Requires that position p has a grandparent.
     */   
    public Position<E> restructure(Position<E> p){
        
    
         Position<E> pos;

         
	     BSTNode<E> curr = this.getNode((BSTNode<E>)p);
         BSTNode<E> parent =null;
         BSTNode<E> grandparent=null; 
        
          
         
         if (curr.hasParent()){
        	 parent = curr.getParent();
        	 if (parent.hasParent()){
            	 grandparent = curr.getParent();
          }
         }
         
         
        //Single Rotation
        if (parent != null && grandparent != null  && grandparent.getRight() == parent && parent.getRight() == curr ) {
               return this.rotate(curr.getParent());}
        
        else if (parent != null && grandparent != null && grandparent.getLeft() == parent && parent.getLeft() == curr ) {
               return this.rotate(curr.getParent());}                
    
    
        //Double Rotation
        else if (parent != null && grandparent != null && grandparent.getRight() == parent && parent.getLeft() == curr){
                      this.rotate(curr);
                return this.rotate(curr.getParent());}
                
        
        else if (parent != null && grandparent != null &&  grandparent.getLeft() == parent && parent.getRight() == curr){
                      this.rotate(curr);
                return this.rotate(curr.getParent());}
                
         
         
        else { return null; }
    
    
    
}      
    
    
    
   
    public  Position<E>  leftRotate(BSTNode<E> x) {
        
      BSTNode<E> y =  (BSTNode<E>)x.getRight();
      
      if(y==null)
      {
          return null; 
      }
      
      //Turn y's left subtree into x's subtree
      x.setRight(y.getLeft());
     
      if (y.getLeft() != null) {
          y.getLeft().setParent(x);}
      
      
      y.setParent(x.getParent());
      if (x.getParent() == null) {
          this.setRoot(y);} 
      
      else if (x == x.getParent().getLeft()) {
          x.getParent().setLeft(y);} 
      
      else {
          x.getParent().setRight(y);
      }
      
      y.setLeft(x);
      x.setParent(y);
      
      //added
      return  (Position<E>)x;
    }
    
    

    public Position<E>  rightRotate(BSTNode<E> x) {
        BSTNode<E> y = x.getLeft();
        
        if(y==null)
        {
           return null; 
        }
        
        //Turn y's left subtree into x's subtree
        x.setLeft(y.getRight());
        if (y.getRight() != null) {
            y.getRight().setParent(x);

        }
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            setRoot(y);
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
        
        y.setRight(x);
        x.setParent(y);
        
        //added
        return (Position<E>)x;

    }
    
}

 

    /*Node successor(Node x) {
        if (x.right() != null) {
            x = x.right();
            while (x.left() != null) {
                x = x.left();
            }
            return x;
        } else {
            Node y = x.parent();
            while (y != null && x == y.right()) {
                x = y;
                y = y.parent();
            }
            return y;
        }
    }

    Node predecessor(Node x) {
        Node predc = null;
        if (x.left() != null) {
            predc = x.left();
            // System.out.println("Checking-"+predc.getKey());
            while (predc.right() != null) {

                predc = predc.right();

            }

            return predc;
        } else {
            predc = x.parent();
            while (predc != null && x == predc.left()) {
                x = predc;
                predc = predc.parent();
            }

        }
        return predc; */

   

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


