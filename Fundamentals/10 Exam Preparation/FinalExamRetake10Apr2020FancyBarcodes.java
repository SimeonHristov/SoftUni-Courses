package com.company.FinalExamPrep04April2020;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalExamRetake10Apr2020FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^@#+([A-Z][A-Za-z0-9]{4,}[A-Z])@#+$";
        Pattern pattern = Pattern.compile(regex);

        while (n-- > 0) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String productGroup = "";

                for (int i = 0; i < matcher.group().length(); i++) {
                    if (Character.isDigit(matcher.group().charAt(i))) {
                        productGroup += matcher.group().charAt(i);
                    }
                }
                if (productGroup != "")
                {
                    System.out.println("Product group: "+ productGroup);
                }
                else
                {
                    System.out.println("Product group: 00");
                }
            } else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
