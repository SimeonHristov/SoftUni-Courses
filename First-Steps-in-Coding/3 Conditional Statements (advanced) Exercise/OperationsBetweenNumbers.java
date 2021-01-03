package Exercise03;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double n1 = Integer.parseInt(scanner.nextLine());
        double n2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        double result = 0;
        String oddEven = "";

        if (operator.equals("+") || operator.equals("-") || operator.equals("*")) {
            switch (operator) {
                case "+":
                    result = n1 + n2;
                    if (result % 2 == 0) {
                        oddEven = "even";
                    } else {
                        oddEven = "odd";
                    }
                    System.out.printf("%.0f %s %.0f = %.0f - %s", n1, operator, n2, result, oddEven);
                    break;
                case "-":
                    result = n1 - n2;
                    if (result % 2 == 0) {
                        oddEven = "even";
                    } else {
                        oddEven = "odd";
                    }
                    System.out.printf("%.0f %s %.0f = %.0f - %s", n1, operator, n2, result, oddEven);
                    break;
                case "*":
                    result = n1 * n2;
                    if (result % 2 == 0) {
                        oddEven = "even";
                    } else {
                        oddEven = "odd";
                    }
                    System.out.printf("%.0f %s %.0f = %.0f - %s", n1, operator, n2, result, oddEven);
                    break;
            }
        }else if (operator.equals("/")) {
            if (n2 == 0) {
                System.out.printf("Cannot divide %.0f by zero",n1);
            } else {
                result = n1 / n2;
                System.out.printf("%.0f %s %.0f = %.2f", n1, operator, n2, result);
           }
         } else if (operator.equals("%")) {
            if (n2 == 0) {
                System.out.printf("Cannot divide %.0f by zero",n1);
            } else {
                result = n1 % n2;
                System.out.printf("%.0f %s %.0f = %.0f", n1, operator, n2, result);
            }
        }
    }
}


