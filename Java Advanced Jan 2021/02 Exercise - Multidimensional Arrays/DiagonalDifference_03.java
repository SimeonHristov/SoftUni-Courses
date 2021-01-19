package MultidimensionalArrays_Exercise_04;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;


public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int [n][n];

        for (int row = 0; row < matrix.length; row++) {
                int[] arr =  Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                matrix[row] = arr;
        }

        int primDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col= n) {
                primDiagonal += matrix[row][row];
                secondaryDiagonal += matrix[row][n-1-row];
            }
        }

        System.out.println(Math.abs(primDiagonal - secondaryDiagonal));

    }
}
