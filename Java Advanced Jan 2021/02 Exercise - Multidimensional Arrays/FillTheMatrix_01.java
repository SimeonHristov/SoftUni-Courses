package MultidimensionalArrays_Exercise_04;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = createMatrix(n, pattern);

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(String.format("%d ", element));
            }
            System.out.println();
        }
    }

    private static int[][] createMatrix(int n, String pattern) {
        int[][] matrix = new int[n][n];

        if ("A".equals(pattern)) {
            fillPatternA(matrix);
        } else if ("B".equals(pattern)) {
            fillPatternB(matrix);
        }
        return matrix;
    }

    private static void fillPatternB(int[][] matrix) {
        int number = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = number++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = number++;
                }
            }
        }
    }

    private static void fillPatternA(int[][] matrix) {
        int number = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = number++;
            }
        }
    }

}
