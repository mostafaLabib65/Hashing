import java.io.*;

public class Hash {
    File file;
    IDictionary dictionary;
    IHashFunction hashFunction;
    public Hash(File file){
        this.file = file;
        hashFunction = new MatrixMethod();
        dictionary = new Dictionary(hashFunction,getSize());
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
                    if (collision == true){
                        dictionary.clear();
                        dictionary.newHashFunc();
                        flag = true;
                        break;
                    }
                }
                if (flag == true){
                    numberOfIterations ++;
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
