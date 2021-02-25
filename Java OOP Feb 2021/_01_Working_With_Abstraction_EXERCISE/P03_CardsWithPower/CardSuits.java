package _01_Working_With_Abstraction_EXCERCISE.P03_CardsWithPower;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);


    private int value;

    CardSuits(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

//    @Override
//    public String toString() {
//        return String.format("Ordinal value: %d; Name value: %s",
//                this.value, this.name());
//    }
}
