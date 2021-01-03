package com.company.FinalExamPrep04April2020;

import javax.swing.border.MatteBorder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String regex = "([=/])([A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> destinations = new ArrayList<>();

        while (matcher.find()) {
            destinations.add(matcher.group(2));
        }
        System.out.println("Destinations: " + String.join(", ",destinations));
        System.out.println("Travel Points: " +  destinations.stream().mapToInt(l -> l.length()).sum());
    }
}
