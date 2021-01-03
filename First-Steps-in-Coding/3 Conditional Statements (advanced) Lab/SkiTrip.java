package Lab03;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vacationPeriod = Double.parseDouble(scanner.nextLine());
        String roomType = scanner.nextLine();
        String feedback = scanner.nextLine();
        double price = 0;
        double discount = 0;
        double roomOnePrice = 18.00;
        double roomTwoPrice = 25.00;
        double roomThreePrice = 35.00;
//        double positiveDiscount = 0.25;
//        double negativeDiscount = 0.10;


//        for (vacationPeriod = 1; vacationPeriod <= 10; vacationPeriod += 1) {
//            switch (roomType) {
//                case "room for one person":
//                    if
//                    System.out.println();

    if  (vacationPeriod <= 10 && roomType.equals("apartment")) {
            if (feedback.equals("positive")) {
            discount = 0.55;
                System.out.printf("%.2f",(vacationPeriod-1)*roomTwoPrice*discount);
        } else if (feedback.equals("negative")) {
                discount = 0.40;
                System.out.printf("%.2f",(vacationPeriod-1)*roomTwoPrice*discount);
        }
    } else if (vacationPeriod <= 10 && roomType.equals("president apartment")) {
        if (feedback.equals("positive")) {
            discount = 0.35;
            System.out.printf("%.2f",(vacationPeriod-1)*roomThreePrice*discount);
        } else if (feedback.equals("negative")) {
            discount = 0.20;
            System.out.printf("%.2f",(vacationPeriod-1)*roomThreePrice*discount);
        }
    } else if (vacationPeriod > 10 && vacationPeriod <= 15 && roomType.equals("apartment")) {
        if (feedback.equals("positive")) {
            discount = 0.60;
            System.out.printf("%.2f",(vacationPeriod-1)*roomTwoPrice*discount);
        } else if (feedback.equals("negative")) {
            discount = 0.45;
            System.out.printf("%.2f",(vacationPeriod-1)*roomTwoPrice*discount);
        }
    } else if (vacationPeriod > 10 && vacationPeriod <= 15 && roomType.equals("president apartment")) {
        if (feedback.equals("positive")) {
            discount = 0.40;
            System.out.printf("%.2f",(vacationPeriod-1)*roomThreePrice*discount);
        } else if (feedback.equals("negative")) {
            discount = 0.25;
            System.out.printf("%.2f",(vacationPeriod-1)*roomThreePrice*discount);
        }
    } else if (vacationPeriod > 15 && roomType.equals("apartment")) {
        if (feedback.equals("positive")) {
            discount = 0.75;
            System.out.printf("%.2f",(vacationPeriod-1)*roomTwoPrice*discount);
        } else if (feedback.equals("negative")) {
            discount = 0.60;
            System.out.printf("%.2f",(vacationPeriod-1)*roomTwoPrice*discount);
        }
    } else if (vacationPeriod > 15 && roomType.equals("president apartment")) {
        if (feedback.equals("positive")) {
            discount = 0.45;
            System.out.printf("%.2f",(vacationPeriod-1)*roomThreePrice*discount);
        } else if (feedback.equals("negative")) {
            discount = 0.30;
            System.out.printf("%.2f",(vacationPeriod-1)*roomThreePrice*discount);
        }
    } else if (feedback.equals("positive")) {
        discount = 0.25;
        System.out.printf("%.2f",(vacationPeriod-1)*roomOnePrice*discount);
    } else if (feedback.equals("negative")) {
        discount = 0.10;
        System.out.printf("%.2f",(vacationPeriod-1)*roomOnePrice*discount);
    }

    }


    }