package Exercise02;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pts = Integer.parseInt(scanner.nextLine());
        double bonusPts = 0;

        if (pts <= 100) {
            bonusPts = 5;
        } else if (pts > 1000) {
            bonusPts = pts * 0.10;
        } else {
            bonusPts = pts * 0.20;
        }

        if (pts % 2 == 0) {
            bonusPts = bonusPts + 1;
        } else if (pts % 10 == 5) {
            bonusPts = bonusPts + 2;
        }

        System.out.println(bonusPts);
        System.out.println(pts+bonusPts);
    }
}
