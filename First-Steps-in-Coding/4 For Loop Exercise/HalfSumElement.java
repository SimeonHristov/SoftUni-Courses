package Exercise04;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int maxNum =  Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            sum = sum + currentNum;
            if (currentNum > maxNum) {
                 maxNum = currentNum;
            }
        }
        int sumWithoutMax = sum - maxNum;
        if (sumWithoutMax == maxNum) {
            System.out.printf("Yes%nSum = %d",maxNum);
        } else {
            System.out.printf("No%nDiff = %d",Math.abs(maxNum-sumWithoutMax));
        }
    }

}
