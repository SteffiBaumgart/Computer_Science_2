import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Utility procedures for binary tree structures.
 * 
 * @version 25/2/2015
 */
public class TreeUtils {
        
    /**
     * Determine whether one tree node structure is similar (has the same structure) as another.
     */
    public static boolean similar(BinaryTreeNode t1, BinaryTreeNode t2) {
		
                 
		if (isPlaceHolder(t1) && isPlaceHolder(t2))
		return true;

		else if (isPlaceHolder(t1) || isPlaceHolder(t2))
		return false;

		return similar(t1.getLeft(),t2.getLeft()) && similar(t1.getRight(),t2.getRight()); 


    }
    
    /**
     * Obtain a list containing the root node of the given structure i.e. tNode itself.
     */
    public static List<BinaryTreeNode> levelZero(BinaryTreeNode tNode) {
        

		List<BinaryTreeNode> zeroLevel = new ArrayList<BinaryTreeNode>(); 
 		zeroLevel.add(tNode); 
		return zeroLevel; 
		
    }
    
    
    /**
     * Given a list of nodes, obtain the next level. 
     * 
     * <p>
     * If the tree structure is incomplete, <code>BinaryTreeNode.EMPTY_NODE</code> is inserted as a place holder for each
     * missing node.
     * </p>
     */
    public static List<BinaryTreeNode> nextLevel(List<BinaryTreeNode> level) {
                

		
		List<BinaryTreeNode> newLevel = new ArrayList<BinaryTreeNode>();
		
		for (int i = 0; i < level.size() ; i++){
   		BinaryTreeNode node = level.get(i);

			if (node == BinaryTreeNode.EMPTY_NODE){

	                newLevel.add(BinaryTreeNode.EMPTY_NODE);
			newLevel.add(BinaryTreeNode.EMPTY_NODE);}
			
			else {

				if (node.hasLeft())
				newLevel.add(node.getLeft());

				else { newLevel.add                      (BinaryTreeNode.EMPTY_NODE); }

				if (node.hasRight())
				  newLevel.add(node.getRight());

				else { newLevel.add(BinaryTreeNode.EMPTY_NODE); }}}
				

		
		return newLevel; 
    }
    
    /**
     * Determine whether node is a place holder i.e. <code>node==BinaryTreeNode.EMPTY_NODE</code>
     */ 



    public static boolean isPlaceHolder(BinaryTreeNode node) {

		if (node == null){
		  return true;}

		else {
		  return false;
		}



}
           	 
}

