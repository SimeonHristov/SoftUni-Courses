package com.company.FinalExamPrep04April2020;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String emojiRegex = "([:*]{2,})([A-Z][a-z]{2,})\\1";
        String digitRegex = "\\d";

        Pattern emojiPattern = Pattern.compile(emojiRegex);

        Pattern digitPattern = Pattern.compile(digitRegex);

        int count = 0;
        int coolnessThreshold = 1;
        Boolean isCool = false;

        Matcher matchDigits = digitPattern.matcher(input);
        while (matchDigits.find()) {
            coolnessThreshold *= Integer.parseInt(matchDigits.group());
        }

        Map<String, Integer> coolEmojis = new LinkedHashMap<>();

        Matcher matchEmoji = emojiPattern.matcher(input);
        while (matchEmoji.find()) {
            count++;
            int coolness = 0;
            String currentMatch = matchEmoji.group(2);
            for (int i = 0; i < currentMatch.length(); i++) {
                char x = currentMatch.charAt(i);
                coolness += x;
            }
            if (coolness > coolnessThreshold) {
                isCool = true;
                coolEmojis.put(matchEmoji.group(), coolness);
            }
        }
        System.out.println("Cool threshold: " + coolnessThreshold);
        System.out.println(count + " emojis found in the text. The cool ones are:");

        if(isCool) {
            for (String s : coolEmojis.keySet()) {
                System.out.println(s);
            }
        }
    }
}