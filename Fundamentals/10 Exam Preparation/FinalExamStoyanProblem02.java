package com.company.FinalExamPrep04April2020;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalExamStoyanProblem02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        String regex = "([%$])(?<tag>[A-Z][a-z]{2,})\\1: (\\[(?<firstNum>\\d+)\\]\\[(?<secondNum>\\d+)\\]\\[(?<thirdNum>\\d+)\\])\\|";
        Pattern pattern = Pattern.compile(regex);
        List <String> qwe = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            String decryptedMessage = "";

            if (matcher.find()) {
                String tag = matcher.group("tag");
                int num1toInt = Integer.parseInt(matcher.group("firstNum"));
                char num1toChar = (char) num1toInt;
                decryptedMessage += num1toChar;
                int num2toInt = Integer.parseInt(matcher.group("secondNum"));
                char num2toChar = (char) num2toInt;
                decryptedMessage += num2toChar;
                int num3toInt = Integer.parseInt(matcher.group("thirdNum"));
                char num3toChar = (char) num3toInt;
                decryptedMessage += num3toChar;
                System.out.println(tag + ": " + decryptedMessage);
                qwe.add(matcher.group());
            } else {
                System.out.println("Valid message not found!");
            }
        }

        for (String s : qwe) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!" + s);
        }
    }
}


//        Pattern pattern = Pattern.compile(regex);
//
//        List<Integer> randomlist = new ArrayList<>((Arrays.asList(15, 6)));
//
//        String qwe = "abva";
//        qwe = qwe.replace('a','z');
//       // qwe = qwe.toUpperCase();
//        System.out.println(qwe);
////        randomlist.set(0, randomlist.get(0)+45);
//       // System.out.println(randomlist.get(0));
//        Collections.sort(randomlist, (b,a) -> {
//            return b.compareTo(a);
//        });
//
//        for (Integer integer : randomlist) {
//            System.out.println(integer);
//        }
//
//        for (int i = 0; i < n; i++) {
//            String input = scanner.nextLine();
//            Matcher matcher = pattern.matcher(input);
//            String decryptedMessage = "";
//
//            if (!matcher.find()) {
//                System.out.println("Valid message not found!");
//            } else {
//                String tag = matcher.group("tag");
//                int num1toInt = Integer.parseInt( matcher.group("firstNum"));
//                char num1toChar = (char) num1toInt;
//                decryptedMessage += num1toChar;
//                int num2toInt = Integer.parseInt( matcher.group("secondNum"));
//                char num2toChar = (char) num2toInt;
//                decryptedMessage += num2toChar;
//                int num3toInt = Integer.parseInt( matcher.group("thirdNum"));
//                char num3toChar = (char) num3toInt;
//                decryptedMessage += num3toChar;
//                System.out.println(tag + ": " + decryptedMessage);
//

