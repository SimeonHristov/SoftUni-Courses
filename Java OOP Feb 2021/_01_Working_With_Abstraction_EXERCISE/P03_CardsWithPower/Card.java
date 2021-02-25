package _01_Working_With_Abstraction_EXCERCISE.P03_CardsWithPower;

public class Card {

    private CardRanks rank;
    private CardSuits suit;
    private int power;

    public Card (CardRanks rank, CardSuits suit) {
        this.rank = rank;
        this.suit = suit;
        calculatePower();
    }

    private void calculatePower(){
        this.power = rank.getValue() + suit.getValue();
    }



    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rank, this.suit.name(), this.power);
    }
}
