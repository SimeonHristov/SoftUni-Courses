package com.company.Exercise01;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int studentCount = Integer.parseInt(scanner.nextLine());
        double lightSabrePrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        //double lightSabreNeededCost = Math.ceil(studentCount * 1.1) * lightSabrePrice;
        double lightSabreNeededCost = (studentCount + (int)Math.ceil((double)studentCount * 0.1)) * lightSabrePrice;
        double robeNeededCost = studentCount * robePrice;

        int freeBelts = studentCount/6;
        double beltNeededCost = beltPrice*(studentCount-freeBelts);
//        if (studentCount % 6 == 0){
//            int beltCount = studentCount - studentCount/ 6;
//            beltNeededCost = beltCount * beltPrice;
//        }
        double totalCost = lightSabreNeededCost + robeNeededCost + beltNeededCost;

        if (budget >= totalCost) {
            System.out.printf("The money is enough - it would cost %.2flv.",totalCost);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.",totalCost-budget);
        }

    }
}
