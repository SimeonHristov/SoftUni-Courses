package _01_Working_With_Abstraction_EXCERCISE.P03_CardsWithPower;

public enum CardRanks {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int value;

    CardRanks(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

//    @Override
//    public String toString() {
//        return String.format("Ordinal value: %d, Name value: %s", this.value, this.name());
//    }
}
