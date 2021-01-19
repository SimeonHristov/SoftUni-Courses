package MultidimensionalArrays_Lab_03;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        //2 3  (2 rows // 3 columns)
        //1 2 3
        //2 1 3

        int [][] firstMatrix = fillMatrix(scanner);
        int [][] secondMatrix = fillMatrix(scanner);
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
       // printMatrix(firstMatrix);

    }

    private static int[][] fillMatrix (Scanner scanner){
        int[] rowsAndCols = readArray(scanner);

        int rowNum = rowsAndCols[0];
        int colNum = rowsAndCols[1];

        int[][] matrix = new int [rowNum][colNum];

        //0 -> to the row count, and everytime on the current ROW of the matrix e = arrat => [1 2 3] (using rearArray or the code there)
        for (int row = 0; row < rowNum; row++) {
            matrix[row] = readArray(scanner);
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
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

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
