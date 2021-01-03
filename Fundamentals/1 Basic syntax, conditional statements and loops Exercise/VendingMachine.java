package com.company.Exercise01;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double coinSum = 0;
        double productPrice = 0;

        while (!input.equals("Start")){
            double currentCoin = Double.parseDouble(input);
            if (currentCoin == 1
                || currentCoin == 2
                || currentCoin == 0.5
                || currentCoin == 0.2
                || currentCoin == 0.1) {
                coinSum += currentCoin;
            } else {
                System.out.printf("Cannot accept %.2f%n",currentCoin);
            }
        input = scanner.nextLine();
        }

        String product = scanner.nextLine();

        while (!product.equals("End")) {

            switch(product){
                case "Nuts": productPrice = 2.0;
                    break;
                case "Water": productPrice = 0.7;
                    break;
                case "Crisps": productPrice = 1.5;
                    break;
                case "Soda": productPrice = 0.8;
                    break;
                case "Coke": productPrice = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    product = scanner.nextLine();
                    continue;
            }

            if (productPrice <= coinSum) {
                System.out.printf("Purchased %s%n",product);
                coinSum -= productPrice;
            } else {
                System.out.println("Sorry, not enough money");
            }

            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f",coinSum);
    }
}
