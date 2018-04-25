import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class DictionaryON implements IDictionary{

    private IHashFunction hashFunction,hashFunction2;
    private Dictionary[]collisionsTable;
    public ArrayList<ArrayList<Integer>> hashTable=new ArrayList<>();
    private int size;
    public DictionaryON(IHashFunction hashFunction, int size){
        this.hashFunction = hashFunction;
        hashFunction.generateHashMatrix();
        this.size = size;
       this.fillArraylistWithN();
       this.collisionsTable=new Dictionary[size];
      //  this.hashedTable1 = new Integer[size];
    }
    
    private void fillArraylistWithN(){
    	
    	for(int i=0;i<size;i++){
    		ArrayList<Integer> temp = new ArrayList<>();
    		hashTable.add(temp);
    	}
    }
    
    @Override
    public boolean insert(int key) {
        int index = hashFunction.hash(key)%(size);
        hashTable.get(index).add(key);
        return false;
    }
    

    @Override
    public boolean find(int key) {
        int index = hashFunction.hash(key);
        boolean e = collisionsTable[index].find(key);
       return e;
    }

    @Override
    public void newHashFunc() {
        this.hashFunction.generateHashMatrix();
    }

    @Override
    public void clear() {
        //hashedTable1 = new Integer[size*size];
    	hashTable.clear();
    	this.fillArraylistWithN();
    }
    
    
    
    
public void HashTableTwo(){
	int numofiterations= 0;
	for(int i=0;i<hashTable.size();i++){
		hashFunction2 = new MatrixMethod(hashTable.get(i).size());
		collisionsTable[i]=new Dictionary(hashFunction2,hashTable.get(i).size());
		int j=0;
            while(j>hashTable.get(i).size()){
            	
            	boolean collision = collisionsTable[i].insert(hashTable.get(i).get(j));
                if (collision == true){
                	collisionsTable[i].clear();
                	collisionsTable[i].newHashFunc();
                    j=0;
                }else{
                	j++;
                }
            	
            	
                
            }
		
	}
	
	
}
}
