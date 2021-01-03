package com.company.Lab03.Arrays;

import java.util.Scanner;

public class DayOfWeek01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dayOfWeek = new String[7];
        dayOfWeek[0] = "Monday";
        dayOfWeek[1] = "Tuesday";
        dayOfWeek[2] = "Wednesday";
        dayOfWeek[3] = "Thursday";
        dayOfWeek[4] = "Friday";
        dayOfWeek[5] = "Saturday";
        dayOfWeek[6] = "Sunday";

        int input = scanner.nextInt();

        if (input < 1 || input >7){
            System.out.println("Invalid day!");
        } else if (input == 1) {
            System.out.println(dayOfWeek[0]);
        } else if (input == 2) {
            System.out.println(dayOfWeek[1]);
        } else if (input == 3) {
            System.out.println(dayOfWeek[2]);
        } else if (input == 4) {
            System.out.println(dayOfWeek[3]);
        } else if (input == 5) {
            System.out.println(dayOfWeek[4]);
        } else if (input == 6) {
            System.out.println(dayOfWeek[5]);
        } else if (input == 7){
            System.out.println(dayOfWeek[6]);
        }

    }
}
