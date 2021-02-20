package _18_ExamPreparation.Exam;

import java.util.Scanner;

public class BombV3 {

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
        for (String c : commands) {
            matrix[playerRow][playerCol] = '+';
            switch (c) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow++;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow >= matrix.length) {
                        playerRow--;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol++;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol >= matrix.length) {
                        playerCol--;
                    }
                    break;
            }
            if (matrix[playerRow][playerCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", totalBombs);
                return;
            } else if (matrix[playerRow][playerCol] == 'B') {
                System.out.println("You found a bomb!");
                totalBombs--;
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
    }


    private static void printMatrix(char[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
