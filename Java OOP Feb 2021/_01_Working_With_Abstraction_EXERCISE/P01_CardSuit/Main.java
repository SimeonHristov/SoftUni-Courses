package _01_Working_With_Abstraction_EXCERCISE.P01_CardSuit;

import _00_Utils.ConsoleReader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ConsoleReader reader = new ConsoleReader();
        String input = reader.readLine();

        System.out.println(input + ":");
        for (CardSuits v : CardSuits.values()) {
            System.out.println(v);
        }

    }
}
