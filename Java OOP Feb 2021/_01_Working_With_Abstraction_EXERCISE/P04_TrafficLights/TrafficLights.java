package _01_Working_With_Abstraction_EXCERCISE.P04_TrafficLights;

public
enum TrafficLights {
    RED("GREEN"), GREEN("YELLOW"), YELLOW("RED");
    private String colourNext;
    TrafficLights(String colorNext){
        this.colourNext = colorNext;
    }

    public
    String getColourNext () {
        return colourNext;
    }

    @Override
    public
    String toString () {
        return String.format ("%s",this.colourNext );
    }
}