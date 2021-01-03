package com.company.FinalExamPrep04April2020;

import java.util.Scanner;

public class FinalExam04Apr2020PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());
        String line = scanner.nextLine();

        while (!line.equals("Done")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "TakeOdd":
                    String takeOdd = password.toString();
                    password = new StringBuilder();
                    for (int i = 1; i <= takeOdd.length()-1; i++) {
                        if (i % 2 != 0) {
                            char x = takeOdd.charAt(i);
                            password.append(x);
                        }
                    }
                    System.out.println(password);
                    break;

                case "Cut":
                    int indexFrom = Integer.parseInt(tokens[1]);
                    int indexTo = Integer.parseInt(tokens[2]);
                    String cutText = password.substring(indexFrom,indexFrom+indexTo);
                    int firstIndex = password.indexOf(cutText);
                    password.delete(indexFrom,indexFrom+cutText.length());
                    System.out.println(password);
                    break;

                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if (password.indexOf(substring) == -1) {
                        System.out.println("Nothing to replace!");
                    } else {
                        String x = password.toString();
                        String y = x.replace(substring, substitute);
                        password = new StringBuilder(y);
                        System.out.println(password);
                    }

//                    if (password.indexOf(substring) != -1) {
//                        while (password.indexOf(substring) != -1) {
//                            password.replace(password.indexOf(substring), password.indexOf(substring) + substitute.length(), substitute);
//                        }
//                    } else {
//                        System.out.println("Nothing to replace");
//                    }
                    break;
            }
            line =scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
