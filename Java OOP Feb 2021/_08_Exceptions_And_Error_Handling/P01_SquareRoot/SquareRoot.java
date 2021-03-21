package _08_Exceptions_And_Error_Handling.P01_SquareRoot;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Supplier;

public class SquareRoot {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        try {
            System.out.println(Math.sqrt(Integer.parseInt(scan.nextLine())));

        } catch (NumberFormatException exception) {

            System.out.println("Invalid input");

        } finally {

            System.out.println("Good bye");
        }
    }
}