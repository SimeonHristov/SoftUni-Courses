package _04_Interfaces_And_Abstraction.P06_Ferrari;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print (new Ferrari (scanner.nextLine ()));
    }
}
