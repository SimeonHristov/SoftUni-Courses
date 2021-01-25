package Lab04;

import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            if (min > currentNumber) {
                min = currentNumber;
            }
            if (max < currentNumber) {
                max = currentNumber;
            }
            
        } System.out.printf("Max number: %d%nMin number: %d",max,min);
    }
}
