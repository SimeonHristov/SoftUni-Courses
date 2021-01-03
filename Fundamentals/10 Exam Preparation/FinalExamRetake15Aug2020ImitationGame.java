package com.company.FinalExamPrep04April2020;

import java.util.Scanner;

public class FinalExamRetake15Aug2020ImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder sb =  new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "ChangeAll":
                    String valueToReplace = tokens[1];
                    String replacementValue = tokens[2];
                    while (sb.indexOf(valueToReplace) != -1){
                        int startIndex = sb.indexOf(valueToReplace);
                        int endIndex= startIndex + valueToReplace.length();
                        sb.replace(startIndex,endIndex,replacementValue);
                    }
                    break;

                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];

                    sb.insert(index,value);
                    break;

                case "Move":
                    int n = Integer.parseInt(tokens[1]);
                    String y = sb.substring(n/n-1, n);
                    for (int i = 0; i < n; i++) {
                        sb.deleteCharAt(0);
                    }
                    sb.append(y);

                    break;
            }

            input = scanner.nextLine();

        }

        System.out.println("The decrypted message is: "+ sb);


    }
}
