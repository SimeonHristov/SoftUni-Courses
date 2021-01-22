package MultidimensionalArrays_Exercise_04;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        for (int i = 0; i < dimensions[0]; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        String input = "";
        while (!(input=scanner.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");

            if (!tokens[0].equals("swap") || tokens.length > 5) {
                System.out.println("Invalid input!");
                continue;
            }
       //     try {
                int r1 = Integer.parseInt(tokens[1]);
                int c1 = Integer.parseInt(tokens[2]);
                int r2 = Integer.parseInt(tokens[3]);
                int c2 = Integer.parseInt(tokens[4]);

                if (r1 < 0 || r1 > matrix.length || c1 < 0 || c1 > matrix[0].length
                || r2 < 0 || r2 > matrix.length || c2 < 0 || c2 > matrix[0].length) {
                    System.out.println("Invalid input!");
                    continue;
                }

                String temp = matrix[r1][c1];
                matrix[r1][c1] = matrix[r2][c2];
                matrix[r2][c2] = temp;

                printMatrix(matrix);
//            } catch (IndexOutOfBoundsException ex) {
//                System.out.println("Invalid input!");
//            }


         //   input = scanner.nextLine();
        }


    }

    private static void printMatrix(String[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
