package _18_ExamPreparation.P12_BookWorm;

import java.util.Scanner;

public class Main {

    public static int playerRow, playerCol;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String greeting = scanner.nextLine();
        sb.append(greeting);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.contains("P")) {
                playerRow = i;
                playerCol = line.indexOf('P');
            }
            matrix[i] = line.toCharArray();
        }


        String command = "";
        while (!"end".equals(command = scanner.nextLine())) {
            if (command.equals("up")) {
                if (isOutOfBounds(playerRow - 1, playerCol, matrix)) {
                    if (sb.length() >= 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    break;
                } else {
                    moveUp(matrix);
                }

            } else if (command.equals("down")) {
                if (isOutOfBounds(playerRow + 1, playerCol, matrix)) {
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    break;
                } else {
                    moveDown(matrix);
                }
            } else if (command.equals("left")) {
                if (isOutOfBounds(playerRow, playerCol  - 1, matrix)) {
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    break;
                } else {
                    moveLeft(matrix);
                }
            } else if (command.equals("right")) {
                if (isOutOfBounds(playerRow , playerCol + 1, matrix)) {
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    break;
                } else {
                    moveRight(matrix);
                }
            }

        }

        System.out.println(sb);
        printMatrix(matrix);


    }

    private static void moveUp(char[][] matrix) {
        if (matrix[playerRow - 1][playerCol] != '-') {
            sb.append(matrix[playerRow - 1][playerCol]);
        }
        matrix[playerRow][playerCol] = '-';
        matrix[playerRow - 1][playerCol] = 'P';
        playerRow--;
    }

    private static void moveDown(char[][] matrix) {
        if (matrix[playerRow + 1][playerCol] != '-') {
            sb.append(matrix[playerRow + 1][playerCol]);
        }
        matrix[playerRow][playerCol] = '-';
        matrix[playerRow + 1][playerCol] = 'P';
        playerRow++;
    }

    private static void moveLeft(char[][] matrix) {
        if (matrix[playerRow][playerCol - 1] != '-') {
            sb.append(matrix[playerRow][playerCol - 1]);
        }
        matrix[playerRow][playerCol] = '-';
        matrix[playerRow][playerCol - 1] = 'P';
        playerCol--;
    }

    private static void moveRight(char[][] matrix) {
        if (matrix[playerRow][playerCol + 1] != '-') {
            sb.append(matrix[playerRow][playerCol + 1]);
        }
        matrix[playerRow][playerCol] = '-';
        matrix[playerRow][playerCol + 1] = 'P';
        playerCol++;
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
