package Exercise01;

import java.net.Inet4Address;
import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double deposit = Double.parseDouble(scan.nextLine());
        int term = Integer.parseInt(scan.nextLine());
        double rate = Double.parseDouble(scan.nextLine());
        double totalAmount = deposit + term * ((((deposit*rate)/100)/12));
        System.out.println(totalAmount);
    }
}

