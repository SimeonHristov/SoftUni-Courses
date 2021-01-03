package com.company.Lab07AssociativeArrays07;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, List> wordsSynonyms = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            List<String> currentSynonyms = wordsSynonyms.get(word);

            if (currentSynonyms == null) {
                currentSynonyms = new ArrayList<>();
                wordsSynonyms.put(word,currentSynonyms);
            }

            currentSynonyms.add(synonym);
        }

        for (Map.Entry<String, List> entry : wordsSynonyms.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ",entry.getValue()));

        }


    }
}
