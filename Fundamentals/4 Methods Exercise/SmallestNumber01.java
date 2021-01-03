package com.company.Exercise04.Methods;

import java.util.Scanner;

public class SmallestNumber01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        System.out.println(smallestNum(n1,n2,n3));
    }

    public static int smallestNum (int n1, int n2, int n3){
        int num = 0;

        if (n1 <= n2 && n1 <= n3) {
            num = n1;
        } else if (n2 <= n1 && n2 <= n3){
            num = n2;
        } else {
            num = n3;
        }

        return  num;
    }
}
