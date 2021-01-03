package com.company.FinalExamPrep04April2020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalExamRetake15Aug2020AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        String regex = "([#\\|])(?<item>[A-Za-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})*\\1(?<calories>\\d{1,5})\\1";

        Pattern datePattern = Pattern.compile(regex);
        Matcher dateMatch = datePattern.matcher(line);

        int totalCalories = 0;
        List<String> info = new ArrayList<>();
//        Map<String,List<String>> map = new LinkedHashMap<>();
        while (dateMatch.find()) {
            totalCalories += Integer.parseInt(dateMatch.group("calories"));
            String item = dateMatch.group("item");
            String date = dateMatch.group("date");
            String cals = dateMatch.group("calories");
            info.add(item);
            info.add(date);
            info.add(cals);

//
//            map.putIfAbsent(item, new ArrayList<>());
//            map.get(item).add(date);
//            map.get(item).add(cals);
        }

        int amountDays = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", amountDays);

        for (int i = 0; i < info.size() - 2; i += 3) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s", info.get(i), info.get(i + 1), info.get(i + 2));
            System.out.println();
        }

//        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
//            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n",stringListEntry.getKey(), stringListEntry.getValue());
//        }
    }
}
