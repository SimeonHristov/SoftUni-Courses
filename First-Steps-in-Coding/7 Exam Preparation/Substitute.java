package exam22_August;

import java.util.Scanner;

public class Substitute {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int K = Integer.parseInt(scanner.nextLine());
        int L = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        boolean hasEnded = false;

        for (int i = K; i <= 8; i++) {
            for (int j = 9; j >= L; j--) {
                for (int k = M; k <= 8; k++) {
                    for (int l = 9; l >= N; l--) {
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

