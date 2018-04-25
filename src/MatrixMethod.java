import java.util.Random;

public class MatrixMethod implements IHashFunction {
    private int[][] hashMatrix;
    private int size;
    public MatrixMethod(int size){
        this.size = size;
    }
    @Override
    public void generateHashMatrix() {
        int rows = (int)Math.ceil(Math.log(size)/Math.log(2));
        int[][] hashMatrix = new int[rows][32];
        Random random = new Random(System.nanoTime());
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < 32; j++){
                hashMatrix[i][j] = Math.abs(random.nextInt() % 2);
            }
        }
        this.hashMatrix = hashMatrix;
    }

    @Override
    public int hash(int key){
        int rows = (int)Math.ceil(Math.log(size)/Math.log(2));
        StringBuilder hashedIndexBinaryRepresentation = new StringBuilder();
        String binary = Integer.toBinaryString(key);
        String[] splitedBinary = binary.split("");
        int[] binaryKey = new int[32];
        int size = splitedBinary.length;
        for (int i = 31; i >= (32-size); i--){
            binaryKey[i] = Integer.parseInt(splitedBinary[i-(32-size)]);
        }
        for (int i = 0; i < (32-size); i++){
            binaryKey[i] = 0;
        }
        for(int i = 0; i < rows; i++){
            int sumOfProducts = 0;
            for(int j = 0; j < 32; j++){
                sumOfProducts = sumOfProducts + hashMatrix[i][j] * binaryKey[j];
            }
            hashedIndexBinaryRepresentation.append(sumOfProducts % 2);
        }
        return Integer.parseInt(hashedIndexBinaryRepresentation.toString(), 2);
    }
}
