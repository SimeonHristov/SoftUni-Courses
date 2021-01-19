package MultidimensionalArrays_Lab_03;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsSquareMatrix_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        // printMatrix(matrix);

        //print matrix diagonal
        int row = 0;
        int col = 0;

        //print matrix left (top) to right (bot) diagonal
        while (row < n && col < n){
            System.out.print(matrix[row++][col++] + " ");
        }
        System.out.println();


        //print matrix left (bot) to right (top) diagonal
        row = n - 1;
        col = 0;

        while (row >= 0 && col < n){
            System.out.print(matrix[row--][col++] + " ");
        }


    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
