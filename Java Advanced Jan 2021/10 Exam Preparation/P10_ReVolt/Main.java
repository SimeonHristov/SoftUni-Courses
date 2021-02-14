package _18_ExamPreparation.P10_ReVolt;

import java.util.Scanner;

public class Main {

    public static int playerRow = 0;
    public static int playerCol = 0;
    public static int finishRow = 0;
    public static int finishCol = 0;
    public static boolean hasWon = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            if (line.contains("f")) {
                playerRow = row;
                playerCol = line.indexOf('f');
            }
            if (line.contains("F")) {
                finishRow = row;
                finishCol = line.indexOf('F');
            }
            matrix[row] = line.toCharArray();
        }

        while (commandsCount-- > 0 && !hasWon) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    moveUp(matrix);
                    break;
                case "down":
                    moveDown(matrix);
                    break;
                case "left":
                    moveLeft(matrix);
                    break;
                case "right":
                    moveRight(matrix);
                    break;
            }

            hasWon = playerRow == finishRow && playerCol == finishCol;
        }

        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);

    }

    private static void moveRight(char[][] matrix) {
        int prevCol = playerCol;
        if (playerCol + 1 == matrix.length) {
            playerCol = -1;
        }
        if (matrix[playerRow][playerCol + 1] != 'T') {
            if (playerCol == -1) {
                prevCol = matrix.length - 1;
            }
            matrix[playerRow][prevCol] = '-';
            playerCol++;
            if (matrix[playerRow][playerCol] == 'B') {
                int beforeRecursiveRow = playerRow;
                int beforeRecursiveCol = playerCol;
                moveRight(matrix);
                matrix[beforeRecursiveRow][beforeRecursiveCol] = 'B';
            }
            matrix[playerRow][playerCol] = 'f';
        } else {
            playerCol = prevCol;
        }
    }

    private static void moveLeft(char[][] matrix) {
        int prevCol = playerCol;
        if (playerCol - 1 < 0) {
            playerCol = matrix.length;
        }
        if (matrix[playerRow][playerCol - 1] != 'T') {
            if (playerCol == matrix.length) {
                prevCol = 0;
            }
            matrix[playerRow][prevCol] = '-';
            playerCol--;
            if (matrix[playerRow][playerCol] == 'B') {
                int beforeRecursiveRow = playerRow;
                int beforeRecursiveCol = playerCol;
                moveLeft(matrix);
                matrix[beforeRecursiveRow][beforeRecursiveCol] = 'B';
            }
            matrix[playerRow][playerCol] = 'f';
        } else {
            playerCol = prevCol;
        }
    }

    private static void moveDown(char[][] matrix) {
        int prevRow = playerRow;
        if (playerRow + 1 == matrix.length) {
            playerRow = -1;
        }
        if (matrix[playerRow + 1][playerCol] != 'T') {
            if (playerRow == 0) {
                prevRow = matrix.length - 1;
            }
            matrix[prevRow][playerCol] = '-';
            playerRow++;
            if (matrix[playerRow][playerCol] == 'B') {
                int beforeRecursiveRow = playerRow;
                int beforeRecursiveCol = playerCol;
                moveDown(matrix);
                matrix[beforeRecursiveRow][beforeRecursiveCol] = 'B';
            }
            matrix[playerRow][playerCol] = 'f';
        } else {
            playerRow = prevRow;
        }
    }

    private static void moveUp(char[][] matrix) {
        // playerRow = matrix.length (3) and not length - 1 because this way
        // the logic below will handle the movement (if != T -> playerRow - 1 which is what we want
        // if there is trap it will handle the situation
        // if there is a bonus it will handle the situation
        int prevRow = playerRow;
        if (playerRow - 1 < 0) {
            playerRow = matrix.length;
        }
        if (matrix[playerRow - 1][playerCol] != 'T') {
            if (playerRow == matrix.length) {
                prevRow = 0;
            }
            matrix[prevRow][playerCol] = '-';
            playerRow--;
            if (matrix[playerRow][playerCol] == 'B') {
                int beforeRecursiveRow = playerRow;
                int beforeRecursiveCol = playerCol;
                moveUp(matrix);
                matrix[beforeRecursiveRow][beforeRecursiveCol] = 'B';
            }
            matrix[playerRow][playerCol] = 'f';
        } else {
            playerRow = prevRow;
        }
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return !isOutOfBounds(row, col, matrix);
    }

    private static void printMatrix(char[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
