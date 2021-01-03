package com.company.Lab04.Methods;

import java.util.Scanner;

public class CalculateRectangleArea06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double area = getRectangleArea(width,height);
        System.out.println(area);
    }

    public static double getRectangleArea (double width, double height) {
        return width * height;
    }
}
