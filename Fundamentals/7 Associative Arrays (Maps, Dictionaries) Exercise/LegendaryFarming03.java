package com.company.Exerrcise07AssociativeAArrays;

import java.util.*;

public class LegendaryFarming03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMats = new HashMap<>();
        Map<String, Integer> junkMats = new TreeMap<>();
        keyMats.put("shards",0);
        keyMats.put("fragments",0);
        keyMats.put("motes",0);
        Boolean isDone = false;

        while (!isDone) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMats.put(material, keyMats.get(material) + quantity);
                    if (keyMats.get(material) >= 250) {
                        keyMats.put(material, keyMats.get(material) - 250);
                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        isDone = true;
                        break;
                    }

                } else {
                    junkMats.putIfAbsent(material, 0);
                    int currentJunk = junkMats.get(material);
                    junkMats.put(material, currentJunk + quantity);
                }
            }
        }

        keyMats.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                }).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junkMats.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
