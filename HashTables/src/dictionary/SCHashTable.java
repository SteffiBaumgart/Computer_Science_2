package dictionary;

import java.util.List;

public class SCHashTable extends AbstractHashTable
{

    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */
    public SCHashTable() {

        super(); }

    /**
     * Create an LPHashTable with the given default size table.
     */
    
    protected ChainedEntry [] table;

    public SCHashTable(int size)
    {
        super(size);
        this.table = new ChainedEntry[size];
        
    }

    protected int findIndex(String word)
    {
        return super.hashFunction(word);
    }

    @Override
    public List<Definition> getDefinitions(String word)
    {
        int hash = hashFunction(word);
        
        if (table[hash] == null) {
            return null; }
        
        else if (table[hash] != null) {
           
        ChainedEntry ent = table[hash]; 
         
        while(ent!=null){
           
             if (ent.getWord().equals(word)) {
                return ent.getDefinitions(); }
             
             ent = ent.getNext(); }
         
        }
       return null; 
    }

    @Override
    public boolean containsWord(String word)
    {
        int hash = hashFunction(word);
         
         if (table[hash] == null) {
             return false; }
         
         else if (table[hash] != null) {
            
         ChainedEntry ent = table[hash]; 
          
         while(ent!=null){
            
              if (ent.getWord().equals(word)) {
                 return true; }
              
              ent = ent.getNext(); }
          
         }
         
        return false; 
     }

    @Override
    public void insert(String word, Definition definition)
    {
       int hash = this.hashFunction(word);
       
        if (!this.containsWord(word)) {
        	create(word, definition); 
        	return; }
        
        else {
             
		    ChainedEntry ent = table[hash];
		    
		    if (ent == null){
		        create(word, definition); 
		        return;}
		    
		        //ChainedEntry next = table[hash];
		        
		        while (ent != null) {
		        	
		            if (ent.getWord().equals(word)){
		            	ent.addDefinition(definition);
		                incProbeCount();
		                return; }
		            
		            else if (ent.getNext() == null){
		            	create(word, definition); 
		                return; }
		            
		            
		            ent = ent.getNext();
		        }
            

        }

    } 

    
    
        public void create(String word, Definition definition){
    	
    	int hash = this.hashFunction(word);
    	
    	ChainedEntry ent = new ChainedEntry(word, table[hash]);
        table[hash] = ent;
        ent.addDefinition(definition);
        incProbeCount();
        entries++; 
        
    } 
    
  
}