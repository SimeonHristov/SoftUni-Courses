package MultidimensionalArrays_Exercise_04;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[rowsAndCols[0]][rowsAndCols[1]];

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        int maxSum = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        System.out.println(matrix[maxRow][maxCol] + " " + matrix[maxRow][maxCol + 1] + " " + matrix[maxRow][maxCol + 2]);
        System.out.println(matrix[maxRow + 1][maxCol] + " " + matrix[maxRow + 1][maxCol + 1] + " " + matrix[maxRow + 1][maxCol + 2]);
        System.out.println(matrix[maxRow + 2][maxCol] + " " + matrix[maxRow + 2][maxCol + 1] + " " + matrix[maxRow + 2][maxCol + 2]);


    }
}
