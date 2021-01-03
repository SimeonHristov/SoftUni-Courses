package com.company.Exerrcise07AssociativeAArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        //int counter = 0;

        Map<String, Integer> resQuantity = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            Integer quantity = Integer.parseInt(scanner.nextLine());
            //counter++;
            //if (counter % 2 != 0) {
            if (resQuantity.containsKey(input)) {
                int currentQuantity = resQuantity.get(input);
                resQuantity.put(input, currentQuantity + quantity);
            } else {
                resQuantity.put(input, quantity);
            }
            input = scanner.nextLine();
        }

        resQuantity.forEach((k,v)-> System.out.println(k + " -> " + v));

    }
}
