package com.company.MidExamREAL07112020;

import com.company.Exercise01.StrongNumber;

import java.util.*;
import java.util.stream.Collectors;

public class Loot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasureChest = Arrays.stream(scanner.nextLine()
                .split("\\|"))
                .collect(Collectors.toList());
//    String[] itemsText = scanner.nextLine().split("\\|");
//        List<String> items = new ArrayList<>(Arrays.asList(itemsText));


      //  int itemLength = 0;

        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Loot":
                    String[] loot = tokens[1].split(" ");
                    for (String s : loot) {
                        if (!treasureChest.contains(s)) {
                            treasureChest.add(0, s);
                        }
                    }
                    break;
                case "Drop":
                    if (Integer.parseInt(tokens[1]) >= 0 && Integer.parseInt(tokens[1]) < treasureChest.size()) {
                        String remove = treasureChest.remove(Integer.parseInt(tokens[1]));
                        treasureChest.add(remove);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    List<String> stolen = new ArrayList<>();
                    while (stolen.size() < count && !treasureChest.isEmpty()) {
                        int lastIndex = treasureChest.size() - 1;
                        stolen.add(treasureChest.get(lastIndex));
                        treasureChest.remove(lastIndex);
                    }

                    Collections.reverse(stolen);
                    System.out.println(String.join(", ", stolen));

                    break;

            }
            //treasureChest.get(input.length());

            input = scanner.nextLine();
        }


        int count = 0;
        double totalLength = 0;
        for (String item : treasureChest) {
            int length = item.length();
            totalLength += length;
            count++;
        }

        if (treasureChest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", totalLength / count);
        }

    }
}
