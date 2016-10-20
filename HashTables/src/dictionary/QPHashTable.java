package dictionary;

public class QPHashTable extends AbstractHashTable {
    
    
    public QPHashTable() { super(); resetProbeCount(); }
    
    public QPHashTable(int size) { 
        super(size);
        resetProbeCount();}


    @Override
    public boolean containsWord(String word) {
 
       for (int i = 0; i < table.length; i++) {            
           
           if(table[i]!=null){
               if(table[i].getWord().equals(word)){
                   return true;
               }   
           }
       }
       return false;
   }
    
    
protected int findIndex(String word) {
        
        int key = hashFunction(word);
        int index = key; 
        
        for (int i = 0; i < table.length + 1 ; i++) {
           
            incProbeCount();
            
            index = (key + i*i) % table.length;
            
            if(index >= table.length) {
               index = 0;}
            
            if (table[index] == null) {
                return index; }
            
            else if(table[index].getWord().equals(word)){
               return index; }
        
        }
        
        return -1;
    }
}

	
  


		
		
		