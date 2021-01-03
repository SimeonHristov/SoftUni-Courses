//package com.company.Exercise05.Lists;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//
//public class SoftUniCoursePlanning10 {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//    List<String> lessons = Arrays.stream(scanner.nextLine()
//            .split("\\, "))
//            .collect(Collectors.toList());
//
//    String input = scanner.nextLine();
//    while (!input.equals("course start")){
//        String[] command = input.split("\\:");
//
//        if (command[0].equals("Add")){
//            lessons.add(command[1]);
//        } else if (command[0].equals("Insert")){
//            if (lessons.contains(command[1])) {
//                continue;
//            } else {
//                lessons.add(Integer.parseInt(command[2]),command[1]);
//            }
//        } else if (command[0].equals("Remove")){
//            if (lessons.contains(command[1])) {
//               lessons.removeAll(Collections.singleton(command[1]));
//            } else {
//                return;
//            }
//        } else if (command[0].equals("Swap")){
//            if (lessons.contains(command[1]) && lessons.contains(command[2])){
//                lessons.set();
//            }
//        } else if (command[0].equals("Exercise")){
//
//        }
//
//
//        input = scanner.nextLine();
//
//    }
//
//        for (String lesson : lessons) {
//            System.out.println(lesson);
//        }
//
//
//
//    }
//}
