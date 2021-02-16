package _18_ExamPreparation.P14_TheGraden;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static  int countOfHarmedVegetables = 0;

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][];

        //int matrixCols = 0;
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().replace(" ","").toCharArray();
//            if ((matrix[i].length) > matrixCols) {
//                matrixCols = matrix[i].length;
//            }
        }

        Map<String, Integer> harvestedVegetables = new LinkedHashMap<>();
        harvestedVegetables.put("Carrots", 0);
        harvestedVegetables.put("Potatoes", 0);
        harvestedVegetables.put("Lettuce", 0);


        String input = "";
        while (!"End of Harvest".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            if (command.equals("Harvest")) {
                if (!isOutOfBounds(row, col, matrix)) {
                    harvest(matrix, harvestedVegetables, row, col);
                }
            } else if (command.equals("Mole")) {
                String direction = tokens[3];
                if (!isOutOfBounds(row, col, matrix)) {
                   moleMovement(matrix, row, col, direction);
                }
            }
        }

        printMatrix(matrix);
        harvestedVegetables.entrySet().forEach(e -> System.out.println(e.getKey() +": "+ e.getValue()));
        System.out.println("Harmed vegetables: " + countOfHarmedVegetables);

    }

    private static void moleMovement(char[][] matrix, int row, int col, String direction) {
        switch (direction) {
            case "up":
                for (int i = row; i > 0; i -= 2) {
                    if (matrix[i][col] != ' ') {
                        countOfHarmedVegetables++;
                        matrix[i][col] = ' ';
                    }
                }
                break;
            case "down":
                for (int i = row; i <= matrix.length; i += 2) {
                    if (matrix[i][col] != ' ') {
                        countOfHarmedVegetables++;
                        matrix[i][col] = ' ';
                    }
                }
                break;
            case "left":
                for (int i = col; i >= 0; i -= 2) {
                    if (matrix[row][i] != ' ') {
                        countOfHarmedVegetables++;
                        matrix[row][i] = ' ';
                    }
                }
                break;
            case "right":
                for (int i = col; i <= matrix[row].length; i += 2) {
                    if (matrix[row][i] != ' ') {
                        countOfHarmedVegetables++;
                        matrix[row][i] = ' ';
                    }
                }
                break;
        }
    }

    private static void harvest(char[][] matrix, Map<String, Integer> harvestedVegetables, int row, int col) {
        if (matrix[row][col] != ' ') {
            if (matrix[row][col] == 'C') {
                harvestedVegetables.put("Carrots", harvestedVegetables.get("Carrots") + 1);
                matrix[row][col] = ' ';
            }
            if (matrix[row][col] == 'P') {
                harvestedVegetables.put("Potatoes", harvestedVegetables.get("Potatoes") + 1);
                matrix[row][col] = ' ';
            }
            if (matrix[row][col] == 'L') {
                harvestedVegetables.put("Lettuce", harvestedVegetables.get("Lettuce") + 1);
                matrix[row][col] = ' ';
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

