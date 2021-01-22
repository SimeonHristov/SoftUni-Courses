package MultidimensionalArrays_Exercise_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rotations = Integer.parseInt(scanner.nextLine().split("[\\(\\)]")[1]) % 360;
//        if (rotations > 270) {
//            rotations = 90 % rotations;
//        }
        ArrayList<String> dataForMatrix = new ArrayList<>();
        String input = scanner.nextLine();
        int maxLen = -1;
        while (!input.equals("END")) {
            dataForMatrix.add(input);
            if (input.length() > maxLen) {
                maxLen = input.length();
            }
            input = scanner.nextLine();
        }

        int rowCount = dataForMatrix.size();
        int colCount = maxLen;

        char[][] matrix = new char[rowCount][colCount];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (col < dataForMatrix.get(row).length()) {
                    matrix[row][col] = dataForMatrix.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        if (rotations == 90) {
            for (int col = 0; col < colCount; col++) {
                for (int row = rowCount -1; row >= 0 ; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotations == 180){
            for (int row = rowCount - 1; row >= 0 ; row--) {
                for (int col = colCount - 1;  col >= 0 ; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotations == 270) {
            for (int col = colCount - 1; col >= 0; col--) {
                for (int row = 0 ; row < rowCount ; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotations == 0){
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < colCount ; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }

    }
}
