import jdk.internal.util.xml.impl.Pair;

import java.awt.*;
import java.util.ArrayList;

public class Dictionary implements IDictionary{

    private IHashFunction hashFunction;
    private Point[] hashedTable;
    public Dictionary(IHashFunction hashFunction,int size){
        this.hashFunction = hashFunction;
        this.hashedTable = new Point[size*size];
    }
    @Override
    public boolean insert(int key) {
        hashFunction.generateHashMatrix();
        int index = hashFunction.hash(key);
        if(hashedTable[index].y == 1){
            return false;
        }
        hashedTable[index].x = key;
        hashedTable[index].y = 1;
        return true;
    }

    @Override
    public boolean find(int key) {
        int index = hashFunction.hash(key);
        if(hashedTable[index].x == key){
            return  true;
        }
        return false;
    }
}
