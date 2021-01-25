package Exercise06;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        int sumPrime = 0;
        int sumNonPrime = 0;

        while (!input.equals("stop")) {
            int num = Integer.parseInt(input);
            boolean isPrime = true;

            if (num < 0) {
                System.out.printf("Number is negative.%n");
            } else {
                for (int i = 2; i < num; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    sumPrime += num;
                } else {
                    sumNonPrime += num;
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n",sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d",sumNonPrime);

    }
}
