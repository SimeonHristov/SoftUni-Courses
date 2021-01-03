package com.company.Lab04.Methods;

import java.util.Scanner;

public class Orders05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        printCheck(product,quantity);


    }

    public static void printCheck (String product, int quantity){
        if (product.equals("coffee")) {
            System.out.printf("%.2f",quantity*1.50);
        } else if (product.equals("water")) {
            System.out.printf("%.2f",quantity*1.00);
        } else if (product.equals("coke")) {
            System.out.printf("%.2f",quantity*1.40);
        } else if (product.equals("snacks")) {
            System.out.printf("%.2f",quantity*2.00);
        }
    }

}

