package MultidimensionalArrays_Exercise_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class TheMatrix_12 {
    private static String START_CHAR = null;
    private static String NEW_CHAR = null;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numberOfRows = dimensions[0];
        int numberOfCols = dimensions[1];
        String[][] matrix = new String[numberOfRows][numberOfCols];

        for (int i = 0; i < numberOfRows; i++) {
            String[] cols = Arrays.stream(bufferedReader.readLine().split("\\s+")).toArray(String[]::new);
            matrix[i] = cols;
        }

        NEW_CHAR = bufferedReader.readLine();

        int[] startPositions = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int startRow = startPositions[0];
        int startCol = startPositions[1];
        START_CHAR = matrix[startRow][startCol];

        ArrayDeque<Integer[][]> path = new ArrayDeque<>();
        int iterations = 0;
        int currentIterations = 0;
        int currentRow = startRow;
        int currentCol = startCol;
        while (true) {
            iterations = 0;
            currentIterations = 0;
            int[] result = null;
            String[][] oldMatrix = matrix;


            // GO MAX LEFT
            result = goMaxLeft(matrix, currentRow, currentCol, true);
            currentRow = result[0];
            currentCol = result[1];
            currentIterations += result[2];

            // printMatrix(matrix);
            //System.out.println();

            // GO MAX RIGHT
            result = goMaxRight(matrix, currentRow, currentCol, true);
            currentRow = result[0];
            currentCol = result[1];
            currentIterations += result[2];

            //printMatrix(matrix);
            //System.out.println();

            // GO MAX UP
            result = goMaxUp(matrix, currentRow, currentCol, true);
            currentRow = result[0];
            currentCol = result[1];
            currentIterations += result[2];

            //printMatrix(matrix);
            //System.out.println();

            // GO MAX DOWN
            result = goMaxDown(matrix, currentRow, currentCol, true);
            currentRow = result[0];
            currentCol = result[1];
            currentIterations += result[2];


            //printMatrix(matrix);
            //System.out.println();

            if (isEqual(oldMatrix, matrix)) {
                break;
            }
        }
        printMatrix(matrix);

    }

    private static boolean isEqual(String[][] oldMatrix, String[][] currentMatrix) {
        for (int i = 0; i < oldMatrix.length; i++) {
            for (int j = 0; j < oldMatrix[i].length; j++) {
                if (!oldMatrix[i][j].equals(currentMatrix[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] goMaxLeft(String[][] matrix, int currentRow, int currentCol, boolean r) {
        int[] result = new int[3];
        int steps = 0;
        while (true) {
            try {
                if (isValid(matrix, currentRow, currentCol)) {
                    matrix[currentRow][currentCol] = NEW_CHAR;
                    if (r) {
                        int[] result2 = null;
                        result2 = goMaxDown(matrix, currentRow, currentCol, false);
                        result2 = goMaxLeft(matrix, result2[0], result2[1], false);
                        result2 = goMaxUp(matrix, currentRow, currentCol, false);
                        result2 = goMaxLeft(matrix, result2[0], result2[1], false);
                        result2 = goMaxRight(matrix, currentRow, currentCol, false);
                        result2 = goMaxLeft(matrix, result2[0], result2[1], false);
                    }
                    currentCol--;
                    steps++;
                } else {
                    currentCol++;
                    steps--;
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                currentCol++;
                steps--;
                break;
            }
        }
        result[0] = currentRow;
        result[1] = currentCol;
        result[2] = steps;
        return result;
    }

    private static int[] goMaxUp(String[][] matrix, int currentRow, int currentCol, boolean r) {
        int[] result = new int[3];
        int steps = 0;
        while (true) {
            try {
                if (isValid(matrix, currentRow, currentCol)) {
                    matrix[currentRow][currentCol] = NEW_CHAR;
                    if (r) {
                        int[] result2 = null;
                        result2 = goMaxLeft(matrix, currentRow, currentCol, false);
                        result2 = goMaxUp(matrix, result2[0], result2[1], false);
                        result2 = goMaxRight(matrix, currentRow, currentCol, false);
                        result2 = goMaxUp(matrix, result2[0], result2[1], false);
                        result2 = goMaxDown(matrix, currentRow, currentCol, false);
                        result2 = goMaxUp(matrix, result2[0], result2[1], false);
                    }

                    currentRow--;
                    steps++;
                } else {
                    currentRow++;
                    steps--;
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                currentRow++;
                steps--;
                break;
            }
        }
        result[0] = currentRow;
        result[1] = currentCol;
        result[2] = steps;
        return result;
    }

    private static int[] goMaxRight(String[][] matrix, int currentRow, int currentCol, boolean r) {
        int[] result = new int[3];
        int steps = 0;
        while (true) {
            try {
                if (isValid(matrix, currentRow, currentCol)) {
                    matrix[currentRow][currentCol] = NEW_CHAR;
                    if (r) {
                        int[] result2 = null;
                        result2 = goMaxLeft(matrix, currentRow, currentCol, false);
                        result2 = goMaxRight(matrix, result2[0], result2[1], false);
                        result2 = goMaxUp(matrix, currentRow, currentCol, false);
                        result2 = goMaxRight(matrix, result2[0], result2[1], false);
                        result2 = goMaxDown(matrix, currentRow, currentCol, false);
                        result2 = goMaxRight(matrix, result2[0], result2[1], false);
                    }

                    currentCol++;
                    steps++;
                } else {
                    currentCol--;
                    steps--;
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                currentCol--;
                steps--;
                break;
            }
        }
        result[0] = currentRow;
        result[1] = currentCol;
        result[2] = steps;
        return result;
    }

    private static int[] goMaxDown(String[][] matrix, int currentRow, int currentCol, boolean r) {
        int[] result = new int[3];
        int steps = 0;
        while (true) {
            try {
                if (isValid(matrix, currentRow, currentCol)) {
                    matrix[currentRow][currentCol] = NEW_CHAR;
                    if (r) {
                        int[] result2 = null;
                        result2 = goMaxLeft(matrix, currentRow, currentCol, false);
                        result2 = goMaxDown(matrix, result2[0], result2[1], false);
                        result2 = goMaxRight(matrix, currentRow, currentCol, false);
                        result2 = goMaxDown(matrix, result2[0], result2[1], false);
                        result2 = goMaxUp(matrix, currentRow, currentCol, false);
                        result2 = goMaxDown(matrix, result2[0], result2[1], false);
                    }

                    currentRow++;
                    steps++;
                } else {
                    steps--;
                    currentRow--;
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                steps--;
                currentRow--;
                break;
            }
        }
        result[0] = currentRow;
        result[1] = currentCol;
        result[2] = steps;
        return result;
    }

    private static boolean isValid(String[][] matrix, int currentRow, int currentCol) {
        if (matrix[currentRow][currentCol].equals(START_CHAR) || matrix[currentRow][currentCol].equals(NEW_CHAR)) {
            return true;
        }
        return false;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

