package Lab01;

import java.util.Scanner;

public class SquareArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int side = Integer.parseInt(scan.nextLine());
        int squareArea = side * side;
        System.out.println(squareArea);
    }
}

