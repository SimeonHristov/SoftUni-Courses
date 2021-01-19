package MultidimensionalArrays_Lab_03;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean notEqual = firstMatrix.length != secondMatrix.length;

        if (!notEqual){
            for (int row = 0; row < firstMatrix.length; row++) {
                int[] firseArr = firstMatrix[row];
                int[] secondArr = secondMatrix[row];
                notEqual = firseArr.length != secondArr.length;
                if(!notEqual) {
                    for (int col = 0; col < firseArr.length; col++) {
                        if (firseArr[col] != secondArr[col]){
                            notEqual = true;
                            break;
                        }
                    }
                }
                if (notEqual) {
                    break;
                }
            }
        }

        String output = notEqual ? "not equal" : "equal";

        System.out.println(output);

    }

    private static int[][] readMatrix(Scanner scanner){
        int[] rowsAndCols = readArray(scanner);

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int [][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = readArray(scanner);
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
