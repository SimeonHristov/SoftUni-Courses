package _18_ExamPreparation.Exam;

import java.util.Scanner;

public class BombV2 {

    static int playerRow, playerCol, totalBombs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            if (line.contains("s")) {
                playerRow = i;
                playerCol = line.indexOf('s');
            }
            matrix[i] = line.toCharArray();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'B') {
                    totalBombs++;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            matrix[playerRow][playerCol] = '+';
            if (commands[i].equals("up")) {
                if (isOutOfBounds(playerRow - 1, playerCol, matrix)) {
                    playerRow = 0;
                } else {
                    playerRow--;
                }
            } else if (commands[i].equals("down")) {
                if (isOutOfBounds(playerRow + 1, playerCol, matrix)) {
                    playerRow = n - 1;
                } else {
                    playerRow++;
                }
            } else if (commands[i].equals("left")) {
                if (isOutOfBounds(playerRow, playerCol - 1, matrix)) {
                    playerRow = 0;
                } else {
                    playerCol--;
                }
            } else if (commands[i].equals("right")) {
                if (isOutOfBounds(playerRow, playerCol + 1, matrix)) {
                    playerCol = n - 1;
                } else {
                    playerCol++;
                }
            }

            if (matrix[playerRow][playerCol] == 'B') {
                totalBombs--;
                System.out.println("You found a bomb!");
            } else  if (matrix[playerRow][playerCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", totalBombs);
                return;
            }

            matrix[playerRow][playerCol] = 's';
            if (totalBombs == 0) {
                break;
            }
        }

        if (totalBombs > 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", totalBombs, playerRow, playerCol);
        } else {
            System.out.println("Congratulations! You found all bombs!");
        }

        //printMatrix(matrix);
    }


    private static void printMatrix(char[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

}
