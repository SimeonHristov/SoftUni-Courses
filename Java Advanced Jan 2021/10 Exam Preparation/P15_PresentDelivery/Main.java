package _18_ExamPreparation.P15_PresentDelivery;

import java.util.Scanner;

public class Main {

    public static int santaRow, santaCol;
    public static int presentsCount;
    public static int niceKidsWithPresent = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        presentsCount = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        int countNiceKids = 0;


        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replace(" ", "");
            matrix[i] = line.toCharArray();
            if (line.contains("S")) {
                santaRow = i;
                santaCol = line.indexOf('S');
            }
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'V') {
                    countNiceKids++;
                }
            }
        }

        String input = "";
        while (!"Christmas morning".equals(input = scanner.nextLine()) && presentsCount > 0) {


            if (input.equals("up")) {
                if (isOutOfBounds(santaRow - 1, santaCol, matrix)) {
                    System.out.println("Santa ran out of presents.");
                    break;
                } else {
                    moveUp(matrix);
                }
            } else if (input.equals("down")) {
                if (isOutOfBounds(santaRow + 1, santaCol, matrix)) {
                    System.out.println("Santa ran out of presents.");
                    break;
                } else {
                    moveDown(matrix);
                }
            } else if (input.equals("left")) {
                if (isOutOfBounds(santaRow, santaCol - 1, matrix)) {
                    System.out.println("Santa ran out of presents.");
                    break;
                } else {
                    moveLeft(matrix);
                }
            } else if (input.equals("right")) {
                if (isOutOfBounds(santaRow, santaCol + 1, matrix)) {
                    System.out.println("Santa ran out of presents.");
                    break;
                } else {
                    moveRight(matrix);
                }
            }

            System.out.println();
        }

        printMatrix(matrix);
        if (countNiceKids - niceKidsWithPresent <= 0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n",countNiceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.",countNiceKids-niceKidsWithPresent);
        }


    }

    private static void moveUp(char[][] matrix) {
        if (matrix[santaRow - 1][santaCol] == '-') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow - 1][santaCol] = 'S';
            santaRow--;
        } else if (matrix[santaRow - 1][santaCol] == 'X') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow - 1][santaCol] = 'S';
            santaRow--;
        } else if (matrix[santaRow - 1][santaCol] == 'V') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow - 1][santaCol] = 'S';
            presentsCount--;
            niceKidsWithPresent++;
            santaRow--;
        } else if (matrix[santaRow - 1][santaCol] == 'C') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow - 1][santaCol] = 'S';
            santaRow--;
            if (matrix[santaRow - 1][santaCol] == 'X' || matrix[santaRow - 1][santaCol] == 'V') {
                presentsCount--;
                if (matrix[santaRow - 1][santaCol] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow - 1][santaCol] = '-';
            }
            if (matrix[santaRow][santaCol - 1] == 'X' || matrix[santaRow][santaCol - 1] == 'V') {
                presentsCount--;
                if (matrix[santaRow][santaCol - 1] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow][santaCol - 1] = '-';
            }
            if (matrix[santaRow][santaCol + 1] == 'X' || matrix[santaRow][santaCol + 1] == 'V') {
                presentsCount--;
                if (matrix[santaRow][santaCol + 1] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow][santaCol + 1] = '-';
            }

        }
    }

    private static void moveDown(char[][] matrix) {
        if (matrix[santaRow + 1][santaCol] == '-') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow + 1][santaCol] = 'S';
            santaRow++;
        } else if (matrix[santaRow + 1][santaCol] == 'X') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow + 1][santaCol] = 'S';
            santaRow++;
        } else if (matrix[santaRow + 1][santaCol] == 'V') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow + 1][santaCol] = 'S';
            presentsCount--;
            niceKidsWithPresent++;
            santaRow++;
        } else if (matrix[santaRow + 1][santaCol] == 'C') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow + 1][santaCol] = 'S';
            santaRow++;
            if (matrix[santaRow + 1][santaCol] == 'X' || matrix[santaRow + 1][santaCol] == 'V') {
                presentsCount--;
                if (matrix[santaRow + 1][santaCol] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow + 1][santaCol] = '-';
            }
            if (matrix[santaRow][santaCol - 1] == 'X' || matrix[santaRow][santaCol - 1] == 'V') {
                presentsCount--;
                if (matrix[santaRow][santaCol - 1] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow][santaCol - 1] = '-';
            }
            if (matrix[santaRow][santaCol + 1] == 'X' || matrix[santaRow][santaCol + 1] == 'V') {
                presentsCount--;
                if (matrix[santaRow][santaCol + 1] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow][santaCol + 1] = '-';
            }

        }
    }

    private static void moveLeft(char[][] matrix) {
        if (matrix[santaRow][santaCol - 1] == '-') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow][santaCol - 1] = 'S';
            santaCol--;
        } else if (matrix[santaRow][santaCol - 1] == 'X') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow][santaCol - 1] = 'S';
            santaCol--;
        } else if (matrix[santaRow][santaCol - 1] == 'V') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow][santaCol - 1] = 'S';
            presentsCount--;
            niceKidsWithPresent++;
            santaCol--;
        } else if (matrix[santaRow][santaCol - 1] == 'C') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow][santaCol - 1] = 'S';
            santaCol--;
            if (matrix[santaRow - 1][santaCol] == 'X' || matrix[santaRow - 1][santaCol] == 'V') {
                presentsCount--;
                if (matrix[santaRow - 1][santaCol] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow - 1][santaCol] = '-';
            }
            if (matrix[santaRow][santaCol - 1] == 'X' || matrix[santaRow][santaCol - 1] == 'V') {
                presentsCount--;
                if (matrix[santaRow][santaCol - 1] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow][santaCol - 1] = '-';
            }
            if (matrix[santaRow + 1][santaCol] == 'X' || matrix[santaRow + 1][santaCol] == 'V') {
                presentsCount--;
                if (matrix[santaRow + 1][santaCol] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow + 1][santaCol] = '-';
            }

        }
    }

    private static void moveRight(char[][] matrix) {
        if (matrix[santaRow][santaCol + 1] == '-') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow][santaCol + 1] = 'S';
            santaCol++;
        } else if (matrix[santaRow][santaCol + 1] == 'X') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow][santaCol + 1] = 'S';
            santaCol++;
        } else if (matrix[santaRow][santaCol + 1] == 'V') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow][santaCol + 1] = 'S';
            presentsCount--;
            niceKidsWithPresent++;
            santaCol++;
        } else if (matrix[santaRow][santaCol + 1] == 'C') {
            matrix[santaRow][santaCol] = '-';
            matrix[santaRow + 1][santaCol + 1] = 'S';
            santaCol++;
            if (matrix[santaRow - 1][santaCol] == 'X' || matrix[santaRow - 1][santaCol] == 'V') {
                presentsCount--;
                if (matrix[santaRow - 1][santaCol] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow - 1][santaCol] = '-';
            }
            if (matrix[santaRow][santaCol + 1] == 'X' || matrix[santaRow][santaCol + 1] == 'V') {
                presentsCount--;
                if (matrix[santaRow][santaCol + 1] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow][santaCol + 1] = '-';
            }
            if (matrix[santaRow + 1][santaCol] == 'X' || matrix[santaRow + 1][santaCol] == 'V') {
                presentsCount--;
                if (matrix[santaRow + 1][santaCol] == 'V') {
                    niceKidsWithPresent++;
                }
                matrix[santaRow + 1][santaCol] = '-';
            }

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

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
