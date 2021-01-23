package SetsAndMaps_EXERCISE_06;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        Map<String,Integer> resources = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String material = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if(!resources.containsKey(material)) {
                resources.put(material, quantity);
            } else {
                int currQuantity = resources.get(material);
                resources.put(material, currQuantity + quantity);
            }


            input= scanner.nextLine();
        }
        //resources.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
        resources.forEach((key, value) -> System.out.println(String.format("%s -> %d", key,value)));

    }
}
