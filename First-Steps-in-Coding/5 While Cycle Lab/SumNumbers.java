package Lab05;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (true) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            sum += currentNum;
            if (sum >= num){
                System.out.println(sum);
                break;
            }
        }
    }
}
