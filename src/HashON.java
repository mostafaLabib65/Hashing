import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HashON {
    File file;
    DictionaryON dictionary;
    IHashFunction hashFunction;
    public HashON(File file){
        this.file = file;
        hashFunction = new MatrixMethod();
        dictionary = new DictionaryON(hashFunction,getSize());
    }

    public int hashFile(){
        int numberOfIterations = 0;
        while (true){
            String line = null;
            boolean flag = false;
            try {
                FileReader fileReader = new FileReader(file);

                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    boolean collision = dictionary.insert(Integer.parseInt(line));
                   
                }
                int sumOFnSQR = 0;
                for(int i=0;i<dictionary.hashTable.size();i++){
                	sumOFnSQR += dictionary.hashTable.get(i).size()*dictionary.hashTable.get(i).size();
                	
                }
          
                if (sumOFnSQR > 4*getSize()){
                    dictionary.clear();
                    dictionary.newHashFunc();
                    flag = true;
                }
                else{
                    break;
                }
                bufferedReader.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println("Error reading file '" + file + "'");
            }
            catch(IOException ex) {
                System.out.println(" Error reading file '" + file + "'");
            }
        }
        dictionary.HashTableTwo();
        return  numberOfIterations;
    }

    private int getSize(){
        String line = null;
        int size = 0;
        try {
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                size++;
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Error reading file '" + file + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + file + "'");
        }
        return size;
    }
    
}
