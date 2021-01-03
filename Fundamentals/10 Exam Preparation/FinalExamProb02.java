package com.company.FinalExamPrep04April2020;

import javax.xml.crypto.dsig.spec.XPathType;
import javax.xml.xpath.XPath;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalExamProb02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^([$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<num1>\\d+)\\]\\|\\[(?<num2>\\d+)\\]\\|\\[(?<num3>\\d+)\\]\\|$";

        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher match = pattern.matcher(input);

            if (match.find()) {

                String tag = match.group(2);
                int num1 = Integer.parseInt(match.group("num1"));
                char num1toChar = (char) num1;
                int num2 = Integer.parseInt(match.group("num2"));
                char num2toChar = (char) num2;
                int num3 = Integer.parseInt(match.group("num3"));
                char num3toChar = (char) num3;

                String test = tag + ": " + num1toChar + num2toChar + num3toChar;

                System.out.println(test);
            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
