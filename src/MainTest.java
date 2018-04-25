import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;

public class MainTest {
    public static void main(String [ ] args){
        String[] files = new String[4];
        /*files[0] = "/home/mostafa/Downloads/testCases_lab3/testCases_lab4/keys1001000.txt";
        files[1] = "/home/mostafa/Downloads/testCases_lab3/testCases_lab4/keys10001000.txt";
        files[2] = "/home/mostafa/Downloads/testCases_lab3/testCases_lab4/keys100001000000.txt";
        files[3] = "/home/mostafa/Downloads/testCases_lab3/testCases_lab4/keys10000001000000.txt";*/
        files[0]= "E:\\keys1001000.txt";
        files[1]= "E:\\keys10001000.txt";
        files[2]= "E:\\keys100001000000.txt";
        files[3]= "E:\\keys10000001000000.txt";

        
        System.out.println("O(N^2) test");
        System.out.println("------------");
        for(int i = 0; i < 4; i++) {
            int l = i+1;
            System.out.println("File: " + l);
            File file = new File(files[i]);
            int average = 0;
            int numberOfHashFunctions = 0;
            System.out.print("number of hash functions tried for each test ==>  ");
            for (int j = 0; j < 10; j++) {
               // Hash hash = new Hash(file);
            	HashON hash = new HashON(file);
                numberOfHashFunctions = hash.hashFile();
                average = average + numberOfHashFunctions;
               // System.out.print(numberOfHashFunctions + " , ");
            }
            System.out.println();
         //   System.out.println("Average : " + average / 10);
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }
}
