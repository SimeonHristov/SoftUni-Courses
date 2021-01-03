package Exercise01;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int rent = Integer.parseInt(scan.nextLine());
    double cake = rent * 0.20;
    double drinks = cake - cake * 0.45;
    double animator = rent / 3;
    System.out.println(rent+cake+drinks+animator);
    }
}
