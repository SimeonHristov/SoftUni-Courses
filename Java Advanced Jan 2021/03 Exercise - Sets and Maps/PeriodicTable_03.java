package SetsAndMaps_EXERCISE_06;

import java.util.*;

public class PeriodicTable_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        Set<String> compounds = new TreeSet<>();

        for (int i = 0; i < n ; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int j = 0; j < tokens.length; j++) {
                compounds.add(tokens[j]);
            }
        }

        for (String compound : compounds) {
            System.out.print(compound + " ");
        }
    }
}
