import java.util.Random;

public class MatrixMethod implements IHashFunction {
    private int[][] hashMatrix;
    @Override
    public void generateHashMatrix() {
        int[][] hashMatrix = new int[32][32];
        Random random = new Random(System.nanoTime());
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < 32; j++){
                hashMatrix[i][j] = random.nextInt() % 2;
            }
        }
        this.hashMatrix = hashMatrix;
    }

    @Override
    public int hash(int key){
        StringBuilder hashedIndexBinaryRepresentation = new StringBuilder();
        String binary = Integer.toBinaryString(key);
        String[] splitedBinary = binary.split("");
        //TODO add zeros to the left of the binary representation to be 32 bit
        int[] binaryKey = new int[32];
        for (int i = 0; i < 32; i++){
            binaryKey[i] = Integer.parseInt(splitedBinary[i]);
        }
        for(int i = 0; i < 32; i++){
            int sumOfProducts = 0;
            for(int j = 0; j < 32; j++){
                sumOfProducts = sumOfProducts + hashMatrix[i][j] * binaryKey[j];
            }
            hashedIndexBinaryRepresentation.append(sumOfProducts % 2);
        }
        return Integer.parseInt(hashedIndexBinaryRepresentation.toString(), 2);
    }
}
