package exam30_August;

import java.util.Scanner;

public class ShopingForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    int pencils = Integer.parseInt(scanner.nextLine());
    int colorPen = Integer.parseInt(scanner.nextLine());
    int notepad = Integer.parseInt(scanner.nextLine());
    int books = Integer.parseInt(scanner.nextLine());

    double pencilsCost = pencils * 4.75;
    double colorPenCost = colorPen * 1.8;
    double notepadCost = notepad * 6.50;
    double booksCost = books * 2.50;

    double totalCost =  pencilsCost + colorPenCost+ notepadCost+ booksCost;
    double discount = totalCost  * 0.05;

        System.out.printf("Your total is %.2flv",totalCost - discount);
    }
}
