package _01_Working_With_Abstraction_EXCERCISE.P02_CardRank;

import _00_Utils.ConsoleReader;


public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        String input = reader.readLine();

        System.out.println(input + ":");
        for (CardRanks v : CardRanks.values()) {
            System.out.println(v);
        }

    }
}
