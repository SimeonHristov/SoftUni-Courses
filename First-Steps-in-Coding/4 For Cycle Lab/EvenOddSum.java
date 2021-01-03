package Lab04;

import java.util.Scanner;

public class EvenOddSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int evenSum = 0;
        int oddSium = 0;

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += number;
            } else {
                oddSium += number;
            }
        }
        if (evenSum == oddSium) {
            System.out.printf("Yes%nSum = %d", evenSum);
        } else {
            System.out.printf("No%nDiff = %d", Math.abs(evenSum - oddSium));
        }
    }
}
