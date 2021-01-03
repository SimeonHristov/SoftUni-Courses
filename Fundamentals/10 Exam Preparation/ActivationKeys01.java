package com.company.FinalExamPrep04April2020;

import java.util.Scanner;

public class ActivationKeys01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String rawActivationKeys = scanner.nextLine();
        StringBuilder rawActivationKeys = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    String text = tokens[1];
                    if (rawActivationKeys.indexOf(text) != -1){
                        System.out.println(rawActivationKeys + " contains " + text);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;


                case "Flip":
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    String currentChars = rawActivationKeys.substring(startIndex,endIndex);
                    String charsToUpper = "";
                    String charsToLower = "";
                    if (tokens[1].equals("Upper")) {
                        for (int i = 0; i < currentChars.length(); i++) {
                            charsToUpper += currentChars.toUpperCase().charAt(i);
                        }
                        rawActivationKeys.replace(startIndex, endIndex, charsToUpper);
                        System.out.println(rawActivationKeys);
                    } else {
                        for (int i = 0; i < currentChars.length(); i++) {
                            charsToLower += currentChars.toLowerCase().charAt(i);
                        }
                        rawActivationKeys.replace(startIndex, endIndex, charsToLower);
                        System.out.println(rawActivationKeys);
                    }
                    break;


                case "Slice":
                    int sliceFromIndex = Integer.parseInt(tokens[1]);
                    int sliceToIndex = Integer.parseInt(tokens[2]);
                    rawActivationKeys.replace(sliceFromIndex,sliceToIndex,"");
                    System.out.println(rawActivationKeys);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + rawActivationKeys);

    }
}
