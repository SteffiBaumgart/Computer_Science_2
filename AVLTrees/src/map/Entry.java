package map;


/**
 * An Entry object is used to store a key-value pair in a binary search tree.
 * 
 * @author Stephan Jamieson
 * @version 2/3/2016
 */
class Entry<K, V> {

    private K key;
    private V value;
    
    /**
     * Create an Entry that stores the given key and value.
     */
    public Entry(K key, V value) {
        this.key=key;
        this.value=value;
    }
    
    /**
     * obtain this Entry's key.
     */
    public K getKey() { return key; }
    
    /**
     * Obtain this Entry's value;
     */
    public V getValue() { return value; }
    
    /**
     * Set this Entry's key to the given value, returning the old one.
     */
    protected K setKey(K key) { 
        final K old = this.key;
        this.key=key;
        return old;
    }
    
    /**
     * Set this Entry's value to that given, returning the old one.
     */
    protected V setValue(V value) {
        final V old = this.value;
        this.value=value;
        return old;
    }
}
