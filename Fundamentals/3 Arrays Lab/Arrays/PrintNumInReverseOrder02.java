package com.company.Lab03.Arrays;

import java.util.Scanner;

public class PrintNumInReverseOrder02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        int[] numbers = new int[input];
        for (int i = 0; i < numbers.length ; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = numbers.length - 1; i >= 0 ; i--) {
            System.out.print(numbers[i] + " ");
        }

        //за разместване на стойности
//отива да средата на масива
//      for (int i = 0; i < inputAsString.length/2 ; i++) {
//взиме числото/символа на позиция (размера на масива - 1) - i (символ до който е стигнало (най-далечния))
//       int swapIndex = inputAsString - 1 - i;
//разменяме стойноститте
//       int oldNumbersI = numbers[i];
//       numbers[i] = numbers[swapIndex];
//       numbers[swapIndex] = oldNumbersI;
//        }


    }
}
