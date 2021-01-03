package exam22_August;

import java.util.Scanner;

public class Rate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    double investedSum = Double.parseDouble(scanner.nextLine());
    int monthsTerm = Integer.parseInt(scanner.nextLine());

    double simpleTotal = investedSum;
    double complexTotal = investedSum;

        for (int i = 1; i <= monthsTerm ; i++) {
            simpleTotal += 0.03 * investedSum;
            complexTotal *= 1.027;
        }

        System.out.printf("Simple interest rate: %.2f lv.%n",simpleTotal);
        System.out.printf("Complex interest rate: %.2f lv.%n",complexTotal);

        if (simpleTotal > complexTotal) {
            System.out.printf("Choose a simple interest rate. You will win %.2f lv.",simpleTotal - complexTotal);
        }else {
            System.out.printf("Choose a complex interest rate. You will win %.2f lv.",complexTotal - simpleTotal);
        }

    }
}
