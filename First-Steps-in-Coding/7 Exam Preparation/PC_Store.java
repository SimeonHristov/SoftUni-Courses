package exam22_August;

import java.util.Scanner;

public class PC_Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pcuPrice = Double.parseDouble(scanner.nextLine());
        double pcuPriceLev = pcuPrice * 1.57;
        double gpuPrice = Double.parseDouble(scanner.nextLine());
        double gpuPriceLev = gpuPrice * 1.57;
        double ram = Double.parseDouble(scanner.nextLine());
        int ramSet = Integer.parseInt(scanner.nextLine());
        double ramPriceLev = ram* ramSet * 1.57;
        double discount = Double.parseDouble(scanner.nextLine());

        double pcuPriceLevDiscount = pcuPriceLev - pcuPriceLev * discount;
        double gpuPriceLevDiscount = gpuPriceLev - gpuPriceLev * discount;

        double priceAfterDiscount = pcuPriceLevDiscount + gpuPriceLevDiscount + ramPriceLev;






        System.out.printf("Money needed - %.2f leva.",priceAfterDiscount);
    }
}
