package _18_ExamPreparation.P11_Bee;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static int beeRow;
    public static int beeCol;
    public static int pollinatedFlowers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.contains("B")) {
                beeRow = i;
                beeCol = line.indexOf('B');
            }
            matrix[i] = line.toCharArray();
        }

        String line = "";
        while (!"End".equals(line = scanner.nextLine())) {
            if (line.equals("up")) {
                if (isOutOfBounds(beeRow - 1, beeCol, matrix)) {
                    matrix[beeRow][beeCol] = '.';
                    System.out.println("The bee got lost!");
                    break;
                } else {
                    moveUp(matrix);
                }
            } else if (line.equals("down")) {
                if (isOutOfBounds(beeRow + 1, beeCol, matrix)) {
                    matrix[beeRow][beeCol] = '.';
                    System.out.println("The bee got lost!");
                    break;
                } else {
                    moveDown(matrix);
                }
            } else if (line.equals("left")) {
                if (isOutOfBounds(beeRow, beeCol - 1, matrix)) {
                    matrix[beeRow][beeCol] = '.';
                    System.out.println("The bee got lost!");
                    break;
                } else {
                    moveLeft(matrix);
                }
            } else if (line.equals("right")) {
                if (isOutOfBounds(beeRow, beeCol + 1, matrix)) {
                    matrix[beeRow][beeCol] = '.';
                    System.out.println("The bee got lost!");
                    break;
                } else {
                    moveRight(matrix);
                }
            }

        }

        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }
        printMatrix(matrix);

    }

    private static void moveUp(char[][] matrix) {

        if (matrix[beeRow - 1][beeCol] != 'O') {
            if (matrix[beeRow - 1][beeCol] == 'f') {
                pollinatedFlowers++;
            }
            matrix[beeRow][beeCol] = '.';
            matrix[beeRow - 1][beeCol] = 'B';
            beeRow--;
        } else if (matrix[beeRow - 1][beeCol] == 'O') {
            if (matrix[beeRow - 2][beeCol] == 'f') {
                pollinatedFlowers++;
            }
            matrix[beeRow][beeCol] = '.';
            matrix[beeRow - 1][beeCol] = '.';
            matrix[beeRow - 2][beeCol] = 'B';
            beeRow = beeRow - 2;
        }
    }

    private static void moveDown(char[][] matrix) {
        if (matrix[beeRow + 1][beeCol] != 'O') {
            if (matrix[beeRow + 1][beeCol] == 'f') {
                pollinatedFlowers++;
            }
            matrix[beeRow][beeCol] = '.';
            matrix[beeRow + 1][beeCol] = 'B';
            beeRow++;
        } else if (matrix[beeRow + 1][beeCol] == 'O') {
            if (matrix[beeRow + 2][beeCol] == 'f') {
                pollinatedFlowers++;
            }
            matrix[beeRow][beeCol] = '.';
            matrix[beeRow + 1][beeCol] = '.';
            matrix[beeRow + 2][beeCol] = 'B';
            beeRow = beeRow + 2;
        }
    }

    private static void moveLeft(char[][] matrix) {

        if (matrix[beeRow][beeCol - 1] != 'O') {
            if (matrix[beeRow][beeCol - 1] == 'f') {
                pollinatedFlowers++;
            }
            matrix[beeRow][beeCol] = '.';
            matrix[beeRow][beeCol - 1] = 'B';
            beeCol--;
        } else if (matrix[beeRow][beeCol - 1] == 'O') {
            if (matrix[beeRow][beeCol - 2] == 'f') {
                pollinatedFlowers++;
            }
            matrix[beeRow][beeCol] = '.';
            matrix[beeRow][beeCol - 1] = '.';
            matrix[beeRow][beeCol - 2] = 'B';
            beeCol = beeCol - 2;
        }
    }

    private static void moveRight(char[][] matrix) {
        if (matrix[beeRow][beeCol + 1] != 'O') {
            if (matrix[beeRow][beeCol + 1] == 'f') {
                pollinatedFlowers++;
            }
            matrix[beeRow][beeCol] = '.';
            matrix[beeRow][beeCol + 1] = 'B';
            beeCol++;
        } else if (matrix[beeRow][beeCol + 1] == 'O') {
            if (matrix[beeRow][beeCol + 2] == 'f') {
                pollinatedFlowers++;
            }
            matrix[beeRow][beeCol] = '.';
            matrix[beeRow][beeCol + 1] = '.';
            matrix[beeRow][beeCol + 2] = 'B';
            beeCol = beeCol + 2;
        }
    }

    private static void printMatrix(char[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
