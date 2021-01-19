package MultidimensionalArrays_Lab_03;

import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            firstMatrix[row] = scanner.nextLine().replace(" ", "").toCharArray();
        }

        for (int row = 0; row < rows; row++) {
            secondMatrix[row] = scanner.nextLine().replace(" ", "").toCharArray();
        }

        char[][] finalMatrix = new char[rows][cols];
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    finalMatrix[i][j] = '*';
                } else {
                    finalMatrix[i][j] = firstMatrix[i][j];
                }
            }
        }

        printMatrix(finalMatrix);
        // printMatrix(secondMatrix);
    }
        private static char[][] createMatrix (Scanner scanner){
            int rows = Integer.parseInt(scanner.nextLine());
            int cols = Integer.parseInt(scanner.nextLine());

            char[][] matrix = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                char[] arr = scanner.nextLine().replace(" ", "").toCharArray();
                matrix[i] = arr;
            }
            return matrix;
        }

        private static void printMatrix ( char[][] matrix){
            //for each row of int[][]
            for (int r = 0; r < matrix.length; r++) {

                //matrix of the current row, take length of the current row because that gives us the Arrays we want to iterate on the given row
                for (int c = 0; c < matrix[r].length; c++) {

                    //Array on teh current row and the element in the current column
                    System.out.print(matrix[r][c] + " ");
                }
                System.out.println();
            }
        }
    }
