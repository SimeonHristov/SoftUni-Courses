package Exercise01;

import java.util.Scanner;

public class VacationBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

    int totalPages = Integer.parseInt(scan.nextLine());
    int pagesPerHour = Integer.parseInt(scan.nextLine());
    int days = Integer.parseInt(scan.nextLine());
    int requiredTime = totalPages / pagesPerHour;
    System.out.println(requiredTime/days);
    }
}
