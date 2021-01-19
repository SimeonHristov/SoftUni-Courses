package MultidimensionalArrays_Exercise_04;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[input[0]][input[1]];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = (char) (97 + row) + "" + (char) (97 + row + col) + "" + (char) (97 + row) + "";
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }
    }
}