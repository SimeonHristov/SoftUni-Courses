package testExam20_21April;

import java.util.Scanner;

public class EasterLunch_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int kozunak = Integer.parseInt(scanner.nextLine());
        int eggs = Integer.parseInt(scanner.nextLine());
        int kgCookies = Integer.parseInt(scanner.nextLine());

        double kozunakCost = kozunak * 3.20;
        double eggsCost = eggs * 4.35;
        double cookieCost = kgCookies * 5.40;
        double eggPaint = eggs * 12 * 0.15;

        System.out.printf("%.2f",kozunakCost+eggsCost+cookieCost+eggPaint);

    }
}
