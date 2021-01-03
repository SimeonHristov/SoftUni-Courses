package Exercise03;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double profit = 0.0;

        switch (projection) {
            case "Premiere":
                profit = rows * columns * 12;
                System.out.printf("%.2f leva", profit);
                break;
            case "Normal":
                profit = rows * columns * 7.50;
                System.out.printf("%.2f leva", profit);
                break;
            case "Discount":
                profit = rows * columns * 5;
                System.out.printf("%.2f leva", profit);
        }
    }
}
