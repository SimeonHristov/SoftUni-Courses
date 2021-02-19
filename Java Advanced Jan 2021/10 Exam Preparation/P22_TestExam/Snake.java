package _18_ExamPreparation.P22_TestExam;

import java.util.Scanner;

public class Snake {

    public static int snakeRow, snakeCol, foodQuantity;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.contains("S")) {
                snakeRow = i;
                snakeCol = line.indexOf('S');
            }
            matrix[i] = line.toCharArray();
        }

        while (foodQuantity < 10) {

            String input = scanner.nextLine();

            if (input.equals("up")) {
                if (isOutOfBounds(snakeRow - 1, snakeCol, matrix)) {
                    break;
                } else {
                    if(!moveSnake(snakeRow, snakeCol, snakeRow - 1, snakeCol, matrix)){
                        snakeRow--;
                    };
                }
            } else if (input.equals("down")) {
                if (isOutOfBounds(snakeRow + 1, snakeCol, matrix)) {
                    break;
                } else {
                   if(!moveSnake(snakeRow, snakeCol, snakeRow + 1, snakeCol, matrix)){
                       snakeRow++;
                   };
                }
            } else if (input.equals("left")) {
                if (isOutOfBounds(snakeRow, snakeCol - 1, matrix)) {
                    break;
                } else {
                    if(!moveSnake(snakeRow, snakeCol, snakeRow, snakeCol - 1, matrix)){
                        snakeCol--;
                    };
                }
            } else if (input.equals("right")) {
                if (isOutOfBounds(snakeRow, snakeCol + 1, matrix)) {
                    break;
                } else {
                   if (!moveSnake(snakeRow, snakeCol, snakeRow, snakeCol + 1, matrix)){
                       snakeCol++;
                   };
                }
            }

        }
        if (foodQuantity >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            matrix[snakeRow][snakeCol] = '.';
            System.out.println("Game over!");
        }

        System.out.println("Food eaten: " + foodQuantity);

        printMatrix(matrix);

    }

    private static boolean moveSnake(int oldRow, int oldCol, int newRow, int newCol, char[][] matrix) {
        if (matrix[newRow][newCol] == '-') {
            matrix[newRow][newCol] = 'S';
        } else if (matrix[newRow][newCol] == '*') {
            matrix[newRow][newCol] = 'S';
            foodQuantity++;
        } else if (matrix[newRow][newCol] == 'B') {
            //which burrow is the snake at ?
            // where is the other one ??
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 'B' && (row != newRow || col != newCol)) {
                        matrix[row][col] = 'S';
                        matrix[newRow][newCol] = '.';
                        matrix[oldRow][oldCol] = '.';
                        snakeRow = row;
                        snakeCol = col;
                        return true;
                    }
                }
            }
        }
        matrix[oldRow][oldCol] = '.';
        return false;
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
