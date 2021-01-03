package com.company.FinalExamPrep04April2020;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinalExamProbOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();
        String line = scanner.nextLine();
       // StringBuilder sb = new StringBuilder(email);

        while (!line.equals("Complete")) {
            String[] tokens = line.split(" ");
            String command = tokens[0];
            if (command.equals("Make")){
                command = command +" "+ tokens[1];
            }


            switch (command) {
                case "Make Upper":
                    email = email.toUpperCase();
                    System.out.println(email);
                    break;

                case "Make Lower":
                    email = email.toLowerCase();
                    System.out.println(email);
                    break;

                case "GetDomain":
                    int x = Integer.parseInt(tokens[1]);
                    String domain = email.substring(email.length()-x, email.length());
                    System.out.println(domain);
                    break;

                case "GetUsername":
                    if(email.indexOf('@') == -1) {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n",email);
                    } else {
                        int index = email.indexOf('@');
                        String username = email.substring(0,index);
                        System.out.println(username);
                    }
                    break;

                case "Replace":
                    char toReplace = tokens[1].charAt(0);
                    char replaceWith = '-';
                    email = email.replace(toReplace,replaceWith);
                    System.out.println(email);
                    break;

                case "Encrypt":
                    List<Integer> asciiValue = new ArrayList<>();
                    for (int i = 0; i <email.length() ; i++) {
                        char y = email.charAt(i);
                        asciiValue.add((int) y);
                    }

                    for (Integer integer : asciiValue) {
                        System.out.print(integer + " ");
                    }

                    break;
            }

            line = scanner.nextLine();
        }


    }

}
