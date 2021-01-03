package com.company.Exercise02;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine()); //17
        int capacity = Integer.parseInt(scanner.nextLine());  //3
        int courses = people/capacity;

        if (people % capacity !=0) {
            courses += 1;
        }
        System.out.println(courses);

    }
}
