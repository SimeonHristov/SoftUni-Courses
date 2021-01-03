package com.company.MidExam5July2020;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //count of students handled per hour
        int employeeOneEfficiency = Integer.parseInt(scanner.nextLine());
        int employeeTwoEfficiency = Integer.parseInt(scanner.nextLine());
        int employeeThreeEfficiency = Integer.parseInt(scanner.nextLine());

        int totalStudents = Integer.parseInt(scanner.nextLine());
        int timeNeeded = 0;

        int capacity =  (employeeOneEfficiency + employeeTwoEfficiency + employeeThreeEfficiency);

        while (totalStudents > 0) {
            timeNeeded++;
            if (timeNeeded % 4 !=0) {
                totalStudents -= capacity;
            }
        }
        System.out.printf("Time needed: %.0fh.%n", Math.ceil(timeNeeded));
        }
    }
