package com.company.FinalExamPrep04April2020;



import java.util.Scanner;

public class FinalExamRetake10Apr2020SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder concealedMsg = new StringBuilder(scanner.nextLine());


        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace":
                    int insIndex = Integer.parseInt(tokens[1]);
                    concealedMsg.insert(insIndex," ");
                    System.out.println(concealedMsg);
                    break;

                case "Reverse":
                    String substring = tokens[1];

                    if (concealedMsg.indexOf(substring) == -1) {
                        System.out.println("error");
                    }else  {
                        int cutFrom = concealedMsg.indexOf(substring);
                        int cutTo = cutFrom + substring.length();
                        concealedMsg.replace(cutFrom,cutTo,"");
                        StringBuilder x = new StringBuilder(substring);
                        x.reverse();
                        concealedMsg.append(x);
                        System.out.println(concealedMsg);
                    }

                    break;
                case "ChangeAll":
                    String replace = tokens[1];
                    String replaceWith = tokens[2];

                    while (concealedMsg.indexOf(replace) != -1){
                        int startIndex = concealedMsg.indexOf(replace);
                        int endIndex = startIndex + replace.length();
                        concealedMsg.replace(startIndex,endIndex,replaceWith);
                    }
                    System.out.println(concealedMsg);

                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("You have a new text message: "+concealedMsg);
    }
}
