package Lab05;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double balance = 0.0;

        while (!input.equals("NoMoreMoney")) {
            Double payment = Double.parseDouble(input);
                if (payment < 0) {
                   System.out.println("Invalid operation!");
                    break;
                }
            balance += payment;
            System.out.printf("Increase: %.2f%n",payment);
            input = scanner.nextLine();
                }
        System.out.printf("Total: %.2f",balance);



//          Напишете програма, която пресмята колко общо пари има в сметката, след като направите определен брой
//            вноски. На всеки ред ще получавате сумата, която трябва да внесете в сметката, до получаване на команда
//“NoMoreMoney”. При всяка получена сума на конзолата трябва да се извежда &quot;Increase: &quot; + сумата и тя
//            да се прибавя в сметката. Ако получите число по-малко от 0 на конзолата трябва да се изведе &quot;Invalid
//            operation!&quot; и програмата да приключи. Когато програмата приключи трябва да се принтира &quot;Total: &quot; +
//                    общата сума в сметката закръглена до втория знак след десетичната запетая.
        }

    }

