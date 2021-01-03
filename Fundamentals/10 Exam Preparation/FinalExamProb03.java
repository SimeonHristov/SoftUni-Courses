package com.company.FinalExamPrep04April2020;

import java.util.*;

public class FinalExamProb03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> userInfo = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("Statistics")) {
            String[] tokens = line.split("->");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "Add":
                    if (userInfo.containsKey(username)) {
                        System.out.println(username + " is already registered");
                    } else {
                        userInfo.put(username,new ArrayList<>());
                    }
                    break;

                case "Send":
                    String email = tokens[2];
                    userInfo.get(username).add(email);
                    break;

                case "Delete":
                    if (userInfo.containsKey(username)) {
                        userInfo.remove(username);
                    } else {
                        System.out.println(username + " not found!");
                    }
                    break;
            }

            line = scanner.nextLine();
        }

        System.out.println("Users count: "+ userInfo.size());

        userInfo.entrySet()
                .stream()
                //.sorted((f, s) -> s.getValue().size() - f.getValue().size())
                .sorted((f,s) -> {
                    int size = s.getValue().size() - f.getValue().size();
                    if (size == 0) {
                      size = f.getKey().compareTo(s.getKey());
                    }
                    return  size;
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue()
                            .stream()
                            //.sorted((f, s) -> f.compareTo(s))
                            .forEach(f -> System.out.println(" - " + f));
                });

    }
}
