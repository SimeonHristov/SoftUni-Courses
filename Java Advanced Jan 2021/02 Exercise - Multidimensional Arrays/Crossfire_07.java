package MultidimensionalArrays_Exercise_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Crossfire_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        ArrayList<ArrayList<Integer>> fields = new ArrayList<>();

        int counter = 1;

        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                numbers.add(counter);
                counter++;
            }
            fields.add(numbers);
        }


        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];

//            if (row < 0 || col < 0)){
//                input = scanner.nextLine();
//                continue;
//            }

            ArrayList<Integer> currentRow = fields.get(row);
            for (int i = col - radius; i <= col + radius; i++) {
                if (row >= 0 && row < fields.size() && i >= 0 && i < fields.get(row).size()) {
                    fields.get(row).set(i,-1);
                }
            }

            for (int i = row - radius; i <= row + radius; i++) {
                if (i >= 0 && i < fields.size() && col >= 0 && col < fields.get(i).size()) {
                    fields.get(i).set(col, -1);
                }
            }

            for (ArrayList<Integer> integers : fields) {
                removeNegativeValues(integers);
            }

            fields.removeIf(ArrayList::isEmpty);
//            fields.stream()
//                    .filter(l -> !l.isEmpty())
//                    .collect(Collectors.toCollection(ArrayList::new));


            input = scanner.nextLine();
        }

        printMatrix(fields);

    }

    private static void removeNegativeValues(ArrayList<Integer> currentRow) {
        while (currentRow.contains(-1)) {
            currentRow.remove(currentRow.indexOf(-1));
        }
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
