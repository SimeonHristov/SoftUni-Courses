package com.company.Lab07AssociativeArrays07;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numberOccurances = new TreeMap<>();
        String[] line = scanner.nextLine().split(" ");
        for (int i = 0; i < line.length; i++) {
            double num = Double.parseDouble(line[i]);

             Integer occurances = numberOccurances.get(num);
             if (occurances == null) {
                 occurances = 0;
             }
             
             numberOccurances.put(num, occurances + 1);
        }

        for (Map.Entry<Double, Integer> doubleIntegerEntry : numberOccurances.entrySet()) {
           //System.out.println(doubleIntegerEntry.getKey() + " -> " + doubleIntegerEntry.getValue());
            System.out.printf("%.0f -> %d%n",doubleIntegerEntry.getKey(),doubleIntegerEntry.getValue());
        }

    }
}
