package Exercise05;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double change = Double.parseDouble(scanner.nextLine());
        change = Math.floor(change * 100);
        int coinsCount = 0;

        while (change > 0) {
        if (change >= 200) {
            change = change - 200;
            coinsCount++;
        } else if (change >= 100) {
            change = change - 100;
            coinsCount++;
        } else if (change >= 50) {
            change = change - 50;
            coinsCount++;
        } else if (change >= 20) {
            change = change - 20;
            coinsCount++;
        } else if (change >= 10) {
            change = change - 10;
            coinsCount++;
        } else if (change >= 5) {
            change = change - 5;
            coinsCount++;
        } else if (change >= 2) {
            change = change - 2;
            coinsCount++;
        } else if (change >= 1) {
            change = change - 1;
            coinsCount++;
        }

    }
        System.out.println(coinsCount);
    }
}

