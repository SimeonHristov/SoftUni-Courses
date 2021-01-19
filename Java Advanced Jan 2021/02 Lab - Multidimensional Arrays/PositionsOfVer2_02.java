package MultidimensionalArrays_Lab_03;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOfVer2_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [][] firstMatrix = readMatrix(scanner);
        //int [][] secondMatrix = readMatrix(scanner);

        int n = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] == n) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }

        }

        if (!isFound){
            System.out.println("not found");
        }
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
