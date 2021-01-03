package com.company.FinalExamPrep04April2020;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhatsWrongHere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(@#+)(?<barcode>[A-Za-z0-9A-Z]+)(@#+)";

        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String productGroup = "";

            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                System.out.println("Invalid barcode");
            } else {
                while (matcher.find()) {

                    String currentBarcode = matcher.group("barcode");
                    Boolean hasDigits = false;
                    for (int j = 0; j < currentBarcode.length(); j++) {
                        char x = currentBarcode.charAt(i);
                        if (Character.isDigit(x)) {
                            productGroup += x;
                            hasDigits = true;
                        }
                    }

                    if (!hasDigits) {
                        productGroup = "00";
                    } else {
                        System.out.println("Product group: " + productGroup);
                    }
                }
            }
        }
    }
}
