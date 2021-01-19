package MultidimensionalArrays_Lab_03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class SumMatrixElements_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int sum = 0;

        int[][] firstMatrix = createMatrix(scanner);

        //1st option
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                sum += firstMatrix[i][j];
            }
        }

       //2nd option iterated each element
       // for (int[] matrix : firstMatrix) {
       //     for (int number : matrix) {
       //        sum += number;
       //     }
       // }

        //3rd option
        int totalSum = Arrays.stream(firstMatrix).mapToInt(arr -> Arrays.stream(arr).sum()).sum();

        //4th option
        int flatMapSum = Arrays.stream(firstMatrix).flatMapToInt(Arrays::stream).sum();


        //print row count
        System.out.println(firstMatrix.length);
        //print column count
        System.out.println(firstMatrix[0].length);
        System.out.println(sum);
        //System.out.println(totalSum);
       // System.out.println(flatMapSum);
    }

    private static int[][] createMatrix(Scanner scanner) {
        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            int[] arr = readArray(scanner);
            matrix[r] = arr;
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

}
