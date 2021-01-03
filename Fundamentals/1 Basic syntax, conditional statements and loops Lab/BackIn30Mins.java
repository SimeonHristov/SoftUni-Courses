package com.company.Lab01;

import java.util.Scanner;

public class BackIn30Mins {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int mins = Integer.parseInt(scanner.nextLine());
        int minPlus30 = mins + 30;

        if (minPlus30 > 60){
            hours = hours +1;
            minPlus30 = minPlus30 - 60;
        }
        if (hours > 23){
            hours = 0;
        }

        if (minPlus30<10){
            System.out.printf("%d:0%d",hours,minPlus30);
        } else {
            System.out.printf("%d:%d", hours, minPlus30);
        }
    }
}
