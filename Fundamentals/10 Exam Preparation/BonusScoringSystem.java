package com.company.MidExam29February2020;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    int studentCount = Integer.parseInt(scanner.nextLine()); //5
    int lecturesCount = Integer.parseInt(scanner.nextLine()); //25
    int additionalBonus = Integer.parseInt(scanner.nextLine()); //30

    double maxBonus = 0;
    int attendance = 0;

        for (int i = 0; i < studentCount; i++) {
            int studentAttendances = Integer.parseInt(scanner.nextLine());
            double totalBonus = studentAttendances* 1.0 / lecturesCount * (5 +additionalBonus);
            if (totalBonus>maxBonus){
                maxBonus = totalBonus;
                attendance = studentAttendances;
            }
        }

        System.out.printf("Max Bonus: %.0f.%nThe student has attended %d lectures.",maxBonus,attendance);
    

    }
}
