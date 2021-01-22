package MultidimensionalArrays_Exercise_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args)  throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] sizes = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[sizes[0]][sizes[1]];
        fillMatrix(matrix, bufferedReader);

        if (sizes[0] <= 0 && sizes[1] <= 0) {
            return;
        }

        int prevRow = matrix.length - 1;
        int prevCol = matrix[0].length - 1;

        while (prevRow >= 0) {
            int iterableRow = prevRow;
            for (int iterableCol = prevCol; iterableCol < matrix[0].length; iterableCol++) {
                System.out.print(matrix[iterableRow][iterableCol] + " ");
                iterableRow--;
                if (iterableRow < 0) {
                    break;
                }
            }

            prevCol--;

            if (prevCol < 0) {
                prevCol = 0;
                prevRow--;
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, BufferedReader bufferedReader) throws IOException {
        for (int i = 0; i < matrix.length; i++) {
            int[] lines = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = lines;
        }
    }

}
