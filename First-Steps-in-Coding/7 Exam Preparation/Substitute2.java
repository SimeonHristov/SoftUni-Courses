package exam22_August;

import java.util.Scanner;

public class Substitute2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        boolean hasEnded = false;


        for (int i = k; i <= 8 ; i++) {
            for (int j = 9; j >= l ; j--) {
                for (int o = m; o <= 8; o++) {
                    for (int p = 9; p >= n ; p--) {

                        boolean isPossible = i % 2 == 0 && k % 2 == 0 && l % 2 != 0 && j % 2 != 0;

                        int firstNum = i * 10 + j;
                        int secondNum = k * 10 + l;

                        if (isPossible && firstNum == secondNum) {
                            System.out.println("Cannot change the same player.");
                        } else if (isPossible && firstNum != secondNum) {
                            System.out.printf("%d%d - %d%d%n", i, j, k, l);
                            counter++;
                        }
                        if (counter >= 6) {
                            hasEnded = true;
                        }
                        if (hasEnded) {
                            return;
                        }

                    }
                }
            }
        }

    }
}
