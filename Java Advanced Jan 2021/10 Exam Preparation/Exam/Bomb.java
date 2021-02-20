package _18_ExamPreparation.Exam;

import java.util.Arrays;
import java.util.Scanner;

public class Bomb {

    static int playerRow, playerCol, totalBombs, foundBomb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        int commandsCount = commands.length;

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


        boolean foundAllBombs = false;
        boolean hasEnded = false;

            for (int i = 0; i < commands.length; i++) {
                String direction = commands[i];

                if (direction.equals("up")) {
                    if (isOutOfBounds(playerRow - 1, playerCol, matrix)) {
                        continue;
                    } else {
                        if (matrix[playerRow - 1][playerCol] == 'B') {
                            foundBomb++;
                            playerRow--;
                            matrix[playerRow][playerCol] = '+';
                            System.out.println("You found a bomb!");
                            if (foundBomb == totalBombs) {
                                foundAllBombs = true;
                            }
                        } else if (matrix[playerRow - 1][playerCol] == 'e') {
                            System.out.printf("END! %d bombs left on the field%n", totalBombs- foundBomb);
                            return;
                        } else {
                            playerRow--;
                        }

                    }
                } else if (direction.equals("down")) {
                    if (isOutOfBounds(playerRow + 1, playerCol, matrix)) {
                        continue;
                    } else {
                        if (matrix[playerRow + 1][playerCol] == 'B') {
                            foundBomb++;
                            playerRow++;
                            matrix[playerRow][playerCol] = '+';
                            System.out.println("You found a bomb!");
                            if (foundBomb == totalBombs) {
                                foundAllBombs = true;
                            }
                        } else if (matrix[playerRow + 1][playerCol] == 'e') {
                            System.out.printf("END! %d bombs left on the field%n", totalBombs- foundBomb);
                            return;
                        } else {
                            playerRow--;
                        }
                    }
                } else if (direction.equals("left")) {
                    if (isOutOfBounds(playerRow, playerCol - 1, matrix)) {
                        continue;
                    } else {
                        if (matrix[playerRow][playerCol - 1] == 'B') {
                            foundBomb++;
                            playerCol--;
                            matrix[playerRow][playerCol] = '+';
                            System.out.println("You found a bomb!");
                            if (foundBomb == totalBombs) {
                                foundAllBombs = true;
                            }
                        } else if (matrix[playerRow ][playerCol- 1] == 'e') {
                            System.out.printf("END! %d bombs left on the field%n", totalBombs- foundBomb);
                            return;
                        } else {
                            playerCol--;
                        }
                    }
                } else if (direction.equals("right")) {
                    if (isOutOfBounds(playerRow, playerCol + 1, matrix)) {
                       continue;
                    } else {
                        if (matrix[playerRow][playerCol + 1] == 'B') {
                            foundBomb++;
                            playerCol++;
                            matrix[playerRow][playerCol] = '+';
                            System.out.println("You found a bomb!");
                            if (foundBomb == totalBombs) {
                                foundAllBombs = true;
                            }
                        } else if (matrix[playerRow ][playerCol+ 1] == 'e') {
                            System.out.printf("END! %d bombs left on the field%n", totalBombs- foundBomb);
                            return;
                        } else {
                            playerCol++;
                        }
                    }
                }

                matrix[playerRow][playerCol] = 's';
                if (hasEnded || foundAllBombs){
                    break;
                }

            }




        if (foundAllBombs) {
            System.out.println("Congratulations! You found all bombs!");
        } else {
            System.out.printf("END! %d bombs left on the field", totalBombs - foundBomb);
        }
        System.out.println();

//        printMatrix(matrix);

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
