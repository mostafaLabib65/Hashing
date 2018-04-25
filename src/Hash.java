import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Hash {
    File file;
    IDictionary dictionary;
    IHashFunction hashFunction;
    ArrayList<Integer> elements;
    public Hash(File file){
        this.file = file;
        elements = getElements(file);
        hashFunction = new MatrixMethod(elements.size());
        dictionary = new Dictionary(hashFunction,elements.size());
    }

    public int hashFile(){
        int numberOfIterations = 1;
        int flag;
        while (true){
            flag = 0;
            for (int i = 0; i < elements.size(); i++){
                boolean collision =  dictionary.insert(elements.get(i));
                if(collision == true){
                    dictionary.clear();
                    dictionary.newHashFunc();
                    numberOfIterations++;
                    flag ++;
                    break;
                }
            }
            if(flag == 0){
                break;
            }
        }
        return numberOfIterations;
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
