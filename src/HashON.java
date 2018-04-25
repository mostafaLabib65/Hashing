import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HashON {
    File file;
    DictionaryON dictionary;
    IHashFunction hashFunction;
    ArrayList<Integer> elements;

    public HashON(File file){
        this.file = file;
        elements = getElements(file);
        hashFunction = new MatrixMethod(elements.size());
        dictionary = new DictionaryON(hashFunction,elements.size());
    }

    public int hashFile(){
        int numberOfIterations = 1;
        while (true){
        	boolean flag = false;
            for (int i = 0; i < elements.size(); i++){

                    boolean collision = dictionary.insert(elements.get(i));
            }
                
                int sumOFnSQR = 0;
                for(int i=0;i<dictionary.hashTable.size();i++){
                	sumOFnSQR += dictionary.hashTable.get(i).size()*dictionary.hashTable.get(i).size();
                }
                if (sumOFnSQR > 4*elements.size()){
                    dictionary.clear();
                    dictionary.newHashFunc();
                    flag = true;
                }else{
                	break;
                }
        }
        dictionary.HashTableTwo(elements.size());
        return  numberOfIterations;
    }

   
    
    private ArrayList getElements(File file){
        ArrayList<Integer> elemnts = new ArrayList<>();
        Set<Integer> elements = new HashSet<>();
        String line = null;
        boolean flag = false;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] splited = line.split(",");
                for (int i = 0; i < splited.length; i++){
                    int number = Integer.parseInt(splited[i]);
                        elements.add(number);
                    }
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Error reading file '" + file + "'");
        }
        catch(IOException ex) {
            System.out.println(" Error reading file '" + file + "'");
        }
        for (Integer key : elements)  {
            elemnts.add(key);
        }
        return elemnts;
    }


    
}
