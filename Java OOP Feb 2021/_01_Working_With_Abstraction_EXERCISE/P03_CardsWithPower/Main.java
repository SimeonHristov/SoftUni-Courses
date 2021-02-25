package _01_Working_With_Abstraction_EXCERCISE.P03_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();


        Card card = new Card(CardRanks.valueOf(cardRank),CardSuits.valueOf(cardSuit));
        System.out.println(card.toString());
    }
}
