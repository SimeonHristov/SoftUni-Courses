package com.company.Exerrcise07AssociativeAArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Orders04 {

    static class product{
        String name;
        double price;
        int quantity;

        public product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, List> itemInfo = new TreeMap<>();
        ArrayList<product> allProducts = new ArrayList<>();



        while (!input.equals("buy")){

            input= scanner.nextLine();
        }

    }
}
