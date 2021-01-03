package com.company.FinalExamPrep04April2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalExamRetake10Apr2020MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();
        String regex = "([@#])(?<firstWord>[A-z]{3,})\\1\\1(?<secondWord>[A-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int wordPairsFound = 0;
        //int validPairsCount = 0;
        int mirrorWords = 0;
        Boolean hasWordPairs = false;
        Boolean hasMirrorWords = false;
        List<String> mirrorWordsList = new ArrayList<>();

        while (matcher.find()) {
            hasWordPairs = true;
            wordPairsFound++;
            String w1 = matcher.group("firstWord");
            String w2 = matcher.group("secondWord");
            String w2Reversed = "";
            for (int i = w2.length() - 1; i >= 0; i--) {
                w2Reversed += w2.charAt(i);
            }

            if (w1.equals(w2Reversed)) {
                hasMirrorWords = true;
                mirrorWords++;
                mirrorWordsList.add(w1);
                mirrorWordsList.add(w2);
            }

        }

        if (!hasWordPairs) {
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        } else {
            System.out.println(wordPairsFound + " word pairs found!");
            if (!hasMirrorWords) {
                System.out.println("No mirror words!");
            } else {
                System.out.println("The mirror words are:");
                for (int i = 0; i < mirrorWordsList.size() - 1; i += 2) {
                    if (i == mirrorWordsList.size() - 2) {
                        System.out.printf(mirrorWordsList.get(i) + " <=> " + mirrorWordsList.get(i + 1));
                    } else {
                        System.out.printf(mirrorWordsList.get(i) + " <=> " + mirrorWordsList.get(i + 1) + ", ");
                    }
                }
            }

        }
    }
}
