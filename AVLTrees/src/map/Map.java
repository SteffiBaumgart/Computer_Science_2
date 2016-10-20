package map;


/**
 * A Map is an object that maps keys to values.
 * 
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
public interface Map<K, V> {
    
    /**
     * Determine whether this map contains an entry for the given key.
     */
    boolean contains(K key);
    
    /**
     * Obtain the value associated with this key. Requires this.contains(key);
     */
    V get(K key);
    
    /**
     * Insert the given key-value pair, returning the previous value associated with that key, or <code>null</code>.
     */
    V put(K key, V value);
    
    /**
     * Remove the entry with the given key, returning the value associated with that key, or <code>null</code> if no such entry exists.
     * 
     */
    V delete(K key);
}
