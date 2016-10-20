package map;
import binarytree.Position;
import avltree.AVLTree;
import java.util.Comparator;

/**
 * An implementation of Map that uses an AVLTree.
 * 
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
public class TreeMap<K, V> implements Map<K, V> {

    // The tree that stores the key-value pairs in this map.
    private AVLTree<Entry<K, V>> tree;
    
    // A Comparator that is used to compare map entries based on their key values.
	// EntryComparator is a wapper for a keyComparator.
    private class EntryComparator<E extends Entry<K, V>> implements Comparator<E> {
		// Your code here.
        
		public int compare(E e1, E e2) { 
			// Your code here.
			return -1;
		}
    }

    /**
     *  Create a TreeMap that uses the given Comparator to manage entries by key value.
     */  
    public TreeMap(Comparator<K> keyComparator) {
		// Your code here
    }
    
    /**
     * Return the Entry object in the AVLTree that possesses the given key value.</br>
     * Returns <code>null</code> if not found.
     */
    private Entry<K, V> find(K key) {
		// Your  code here.
		return null;
    }
    
    /**
     * Determine whether this map contains an entry for the given key.
     */
    public boolean contains(K key) { return find(key)!=null; }
    
    /**
     * Remove the entry with the given key, returning the value associated with that key, or <code>null</code> if no such entry exists.
     * 
     */    
    public V delete(K key) {
		// Your code here.
        return null;
    }

    /**
     * Insert the given key-value pair, returning the previous value associated with that key, or <code>null</code>.
     */

    public V put(K key, V value) {
		// Your code here.
		return null;
    }
    
    /**
     * Obtain the value associated with this key.</br>
     * Returns null if there is no entry for this key or the value associated with this key is in fact null.
     */
    public V get(K key) {
		// Your code here.
		return null;
    }
   
}
