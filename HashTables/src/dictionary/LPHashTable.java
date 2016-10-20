package dictionary;
import java.util.List;
/**
 * Simple hash table implementation of Dictionary using linear probing.
 * 
 * @author Stephan Jamieson 
 * @version 24/4/2015
 */
public class LPHashTable extends AbstractHashTable {

    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */ 
    public LPHashTable() { super(); }
    
    /**
     * Create an LPHashTable with the given default size table.
     */
    public LPHashTable(int size) { super(size); }   
    
    
    /** THINK ABOUT
     * Find the table index for the given word.
     * If the word is in the table, then the method returns its index.
     * if it is not in the table then the method returns the index of
     * the first free slot.
     *
     * Returns -1 if a slot is not found (such as when the table
     * is full under LP). */
    
   /* @Override
    protected int findIndex(String word)
    {
        int key = super.hashFunction(word);
        int index = 0; 
        
        for (int i = 0; i < table.length; i++) {
            
            index = key + i;

            if ( index >= table.length) {
            	 index -= table.length; }
            
            if (table[index] == null) {
                return index; }
            
            else if (table[index].getWord().equals(word)) {
                return index; }
        }
        
        return -1;
    } */
    
    
    /*@Override 
	protected int findIndex(String word) {
		
		 int key = super.hashFunction(word);
		 int index = 0; 
		 
		 if (table[index] == null){
				return -1; }
		 
		 if (this.containsWord(word)){
			 index = key + 1; }
		 
		 if (index >= table.length) {
			 index -= table.length; }

         while (super.table[index] != null) {
            
        	if (index >= table.length) {
        		index -= table.length; }

            if (table[index].getWord().equals(word)){
                return index;}
            
            index++;

	        }
	        
	        return -1; 
    } */
    
    
    protected int findIndex(String word) {
    	
    	int hash = hashFunction(word); 
    	int index = 0; 

        if(this.containsWord(word)){
                  
                for (int i = hash; i < hash + table.length; i++) {
                	
                	index = i % table.length; 
                    //Entry entry = table[index];
                    
                    if(table[index]!=null){
                    	
                        if(table[index].getWord().equals(word)){
                            return i;}
                        
                        incProbeCount();
                    }
                }
            return -1;
        }

        else if (!this.containsWord(word)){ 
           
        	if(this.size()!=table.length){
               
               for (int i = hash; i < hash + table.length; i++) {
            	   
            	   index = i % table.length; 
            	   
                   if(table[index]==null){
                       return i; }
                   
                   incProbeCount();
               }
           }
        	
           else { return -1;}
       }
    return -1;
}
}
		
		
		