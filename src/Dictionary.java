import java.awt.*;

public class Dictionary implements IDictionary{

    private IHashFunction hashFunction;
    private Integer[] hashedTable;
    private int size;
    public Dictionary(IHashFunction hashFunction, int size){
        this.hashFunction = hashFunction;
        hashFunction.generateHashMatrix();
        this.size = size;
        this.hashedTable = new Integer[size*size];
    }
    @Override
    public boolean insert(int key) {
        int index = hashFunction.hash(key)%(size*size);
        if(hashedTable[index] != null && hashedTable[index] != key){
            return true;
        }
        hashedTable[index] = key;
        return false;
    }

    @Override
    public boolean find(int key) {
        int index = hashFunction.hash(key);
        if(hashedTable[index] == key){
            return  true;
        }
        return false;
    }

    @Override
    public void newHashFunc() {
        this.hashFunction.generateHashMatrix();
    }

    @Override
    public void clear() {
        hashedTable = new Integer[size*size];
    }

    public IHashFunction getHashFunction(){
    	return this.hashFunction;
    }
}
