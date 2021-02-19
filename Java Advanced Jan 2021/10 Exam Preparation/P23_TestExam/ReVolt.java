package _18_ExamPreparation.P23_TestExam;

import java.util.Scanner;

public class ReVolt {

    static int playerRow, playerCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        boolean hasWon = false;


        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.contains("f")) {
                playerRow = i;
                playerCol = line.indexOf('f');
            }
            matrix[i] = line.toCharArray();
        }

        while (commandsCount > 0) {
            String input = scanner.nextLine();

            switch (input) {
                case "up":
                    if (isOutOfBounds(playerRow - 1, playerCol, matrix)) {
                        matrix[playerRow][playerCol] = '-';
                        if (matrix[n - 1][playerCol] == 'F') {
                            playerRow = n - 1;
                            matrix[playerRow][playerCol] = 'f';
                            hasWon = true;
                            break;
                        } else if (matrix[n - 1][playerCol] == 'B') {
                            if (matrix[n - 2][playerCol] == 'F') {
                                hasWon = true;
                                playerRow = n - 2;
                                matrix[playerRow][playerCol] = 'f';
                                break;
                            } else {
                                playerRow = n - 1;
                                matrix[playerRow][playerCol] = 'f';
                            }
                        }
                    } else {
                        if (matrix[playerRow - 1][playerCol] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            playerRow--;
                            matrix[playerRow][playerCol] = 'f';
                        } else if (matrix[playerRow - 1][playerCol] == 'B') {
                            if (!isOutOfBounds(playerRow - 2, playerCol, matrix)) {
                                if (matrix[playerRow - 2][playerCol] == 'F') {
                                    hasWon = true;
                                }
                                matrix[playerRow][playerCol] = '-';
                                playerRow -= 2;
                                matrix[playerRow][playerCol] = 'f';
                            } else {
                                matrix[playerRow][playerCol] = '-';
                                if (matrix[n - 1][playerCol] == 'F'){
                                    hasWon=true;
                                    break;
                                }
                                matrix[n - 1][playerCol] = 'f';
                                playerRow = n -1;
                            }
                        } else if (matrix[playerRow - 1][playerCol] == 'F') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow - 1][playerCol] = 'f';
                            hasWon = true;
                            break;
                        }
                    }
                    break;
                case "down":
                    if (isOutOfBounds(playerRow + 1, playerCol, matrix)) {
                        matrix[playerRow][playerCol] = '-';
                        if (matrix[0][playerCol] == 'F') {
                            playerRow = 0;
                            matrix[playerRow][playerCol] = 'f';
                            hasWon = true;
                            break;
                        } else if (matrix[0][playerCol] == 'B') {
                            if (matrix[1][playerCol] == 'F') {
                                hasWon = true;
                                playerRow = 1;
                                matrix[playerRow][playerCol] = 'f';
                                break;
                            } else {
                                playerRow = 0;
                                matrix[playerRow][playerCol] = 'f';
                            }
                        }
                    } else {
                        if (matrix[playerRow + 1][playerCol] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            playerRow++;
                            matrix[playerRow][playerCol] = 'f';
                        } else if (matrix[playerRow + 1][playerCol] == 'B') {
                            if (!isOutOfBounds(playerRow + 2, playerCol, matrix)) {
                                if (matrix[playerRow + 2][playerCol] == 'F') {
                                    hasWon = true;
                                }
                                matrix[playerRow][playerCol] = '-';
                                playerRow += 2;
                                matrix[playerRow][playerCol] = 'f';
                            } else {
                                matrix[playerRow][playerCol] = '-';
                                if (matrix[0][playerCol] == 'F'){
                                    hasWon=true;
                                    break;
                                }
                                matrix[0][playerCol] = 'f';
                                playerRow = 0;
                            }
                        } else if (matrix[playerRow + 1][playerCol] == 'F') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow + 1][playerCol] = 'f';
                            hasWon = true;
                            break;
                        }
                    }
                    break;
                case "left":
                    if (isOutOfBounds(playerRow, playerCol - 1, matrix)) {
                        matrix[playerRow][playerCol] = '-';
                        if (matrix[playerRow][n - 1] == 'F') {
                            playerCol = n - 1;
                            matrix[playerRow][playerCol] = 'f';
                            hasWon = true;
                            break;
                        } else if (matrix[playerRow][n - 1] == 'B') {
                            if (matrix[playerRow][n - 2] == 'F') {
                                hasWon = true;
                                playerCol = n - 2;
                                matrix[playerRow][playerCol] = 'f';
                                break;
                            } else {
                                playerCol = n - 1;
                                matrix[playerRow][playerCol] = 'f';
                            }
                        }
                    } else {
                        if (matrix[playerRow][playerCol - 1] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            playerCol--;
                            matrix[playerRow][playerCol] = 'f';
                        } else if (matrix[playerRow][playerCol - 1] == 'B') {
                            if (!isOutOfBounds(playerRow, playerCol - 2, matrix)) {
                                if (matrix[playerRow][playerCol - 2] == 'F') {
                                    hasWon = true;
                                }
                                matrix[playerRow][playerCol] = '-';
                                playerCol -= 2;
                                matrix[playerRow][playerCol] = 'f';
                            } else {
                                matrix[playerRow][playerCol] = '-';
                                if (matrix[playerRow][n - 1] == 'F'){
                                    hasWon=true;
                                    break;
                                }
                                matrix[playerRow][n - 1] = 'f';
                                playerCol = n - 1;
                            }
                        } else if (matrix[playerRow][playerCol - 1] == 'F') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol - 1] = 'f';
                            hasWon = true;
                            break;
                        }
                    }
                    break;
                case "right":
                    if (isOutOfBounds(playerRow, playerCol + 1, matrix)) {
                        matrix[playerRow][playerCol] = '-';
                        if (matrix[playerRow][0] == 'F') {
                            playerCol = 0;
                            matrix[playerRow][playerCol] = 'f';
                            hasWon = true;
                            break;
                        } else if (matrix[playerRow][0] == 'B') {
                            if (matrix[playerRow][1] == 'F') {
                                hasWon = true;
                                playerCol = 1;
                                matrix[playerRow][playerCol] = 'f';
                                break;
                            } else {
                                playerCol = 1;
                                matrix[playerRow][playerCol] = 'f';
                            }
                        }
                    } else {
                        if (matrix[playerRow][playerCol + 1] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            playerCol++;
                            matrix[playerRow][playerCol] = 'f';
                        } else if (matrix[playerRow][playerCol + 1] == 'B') {
                            if (!isOutOfBounds(playerRow, playerCol + 2, matrix)) {
                                if (matrix[playerRow][playerCol + 2] == 'F') {
                                    hasWon = true;
                                }
                                matrix[playerRow][playerCol] = '-';
                                playerCol += 2;
                                matrix[playerRow][playerCol] = 'f';
                            } else {
                                matrix[playerRow][playerCol] = '-';
                                if (matrix[playerRow][0] == 'F'){
                                    hasWon=true;
                                    break;
                                }
                                matrix[playerRow][0] = 'f';
                                playerCol = 0;
                            }
                        } else if (matrix[playerRow][playerCol + 1] == 'F') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol + 1] = 'f';
                            hasWon = true;
                            break;
                        }
                    }
                    break;
            }
            if (hasWon) {
                break;
            }
            commandsCount--;
        }

        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);


    }


    private static void printMatrix ( char[][] matrix){

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBounds ( int row, int col, char[][] matrix){
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
