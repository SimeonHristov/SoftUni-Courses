package Exercise02;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double income = Double.parseDouble(scanner.nextLine());
        double grade = Double.parseDouble(scanner.nextLine());
        double minSalary = Double.parseDouble(scanner.nextLine());

        double socialScholarship = Math.floor(minSalary * 0.35);
        //Requirements:  income < minSalary && grade > 4.5
        double scholarship = Math.floor(grade * 25);
        //Requirements:  grade > 5.5

        if (income < minSalary && grade >= 5.5 && socialScholarship > scholarship) {
            System.out.printf("You get a Social scholarship %.0f BGN",socialScholarship);
        } else if (income < minSalary && grade >= 5.5 && socialScholarship <= scholarship) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN",scholarship);
        } else if (income < minSalary && grade > 4.5) {
            System.out.printf("You get a Social scholarship %.0f BGN",socialScholarship);
        } else if (grade >= 5.5) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN",scholarship);
        } else {
            System.out.printf("You cannot get a scholarship!");
        }

    }
}
