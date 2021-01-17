package MultidimensionalArrays_Exercise_04;

import java.util.Scanner;

public class FillTheMatrix01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = fillMatrix(n, pattern);

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.println(String.format("%d ", element));
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(int n, String pattern) {
        int[][] matrix = new int[n][n];
        if ("A".equals(pattern)) {
            fillPatternA(matrix);
        } else if ("B".equals(pattern)) {
            fillPatternB(matrix);
        }
        return new int[0][];
    }

    private static void fillPatternB(int[][] matrix) {
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[j][i] = number++;
                }
            } else {
                for (int j = matrix[i].length - 1; j > 0; j--) {
                    matrix[j][i] = number++;
                }
            }
        }
    }

    private static void fillPatternA(int[][] matrix) {
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = number++;
            }
        }
    }

}
