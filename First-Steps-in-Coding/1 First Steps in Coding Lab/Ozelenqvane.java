package Lab01;

import java.util.Scanner;

public class Ozelenqvane {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double squareMeter = Double.parseDouble(scan.nextLine());
        double price = squareMeter * 7.61;
        double discount = price * 0.18;
        double totalsum = price - discount;
        //double finalPrice = price - discount;
        //System.out.printf("The final price is: %d lv. \nThe discount price is: %d lv.",finalPrice,discount);
        System.out.printf("The final price is: %.2f lv.%n",totalsum);
        System.out.printf("THe discount is: %.2f lv.", discount);
    }
}
