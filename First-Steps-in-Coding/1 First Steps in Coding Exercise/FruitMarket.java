package Exercise01;

import java.sql.DriverPropertyInfo;
import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double priceStrawberries = Double.parseDouble(scan.nextLine());
        double bananas = Double.parseDouble(scan.nextLine());
        double oranges = Double.parseDouble(scan.nextLine());
        double raspberries = Double.parseDouble(scan.nextLine());
        double strawberries = Double.parseDouble(scan.nextLine());
        double princeRaspberries = priceStrawberries * 0.50;
        double priceOranges = princeRaspberries - princeRaspberries * 0.40;
        double priceBananas = princeRaspberries - princeRaspberries * 0.80;
        double totalSum = strawberries * priceStrawberries + bananas*priceBananas+oranges*priceOranges+raspberries*princeRaspberries;
        System.out.printf("%.2f",totalSum);
    }
}
