package testExam20_21April;

import java.util.Scanner;
import java.util.function.DoubleToLongFunction;

public class EasterBakery_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double flourPrice = Double.parseDouble(scanner.nextLine());
        double flourKg = Double.parseDouble(scanner.nextLine());
        double sugarKg = Double.parseDouble(scanner.nextLine());
        int eggs = Integer.parseInt(scanner.nextLine());
        int yeast = Integer.parseInt(scanner.nextLine());

        double sugarPrice = flourPrice * 0.75;
        double eggPrice = flourPrice * 1.1;
        double yeastPrice = sugarPrice * 0.20;

        double totalFlour = flourKg * flourPrice;
        double totalSugar = sugarKg * sugarPrice;
        double totalEggs = eggs * eggPrice;
        double totalYeast = yeast * yeastPrice;

        double totalCost = totalFlour + totalSugar + totalEggs + totalYeast;

        System.out.printf("%.2f",totalCost);





    }
}
