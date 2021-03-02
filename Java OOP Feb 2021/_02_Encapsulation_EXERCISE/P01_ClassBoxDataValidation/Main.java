package _02_Encapsulation_EXERCISE.P01_ClassBoxDataValidation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Box box = new Box (length,width,height);

        System.out.printf("Surface Area - %.2f",box.calculateSurfaceArea());
        System.out.println();
        System.out.printf("Lateral Surface Area - %.2f",box.calculateLateralSurfaceArea());
        System.out.println();
        System.out.printf("Volume - %.2f",box.calculateVolume());
    }
}
