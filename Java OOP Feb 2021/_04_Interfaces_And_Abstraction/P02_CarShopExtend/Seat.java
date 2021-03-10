package _04_Interfaces_And_Abstraction.P02_CarShopExtend;//package _04_Interfaces_And_Abstraction.P01_CarShop;

public class Seat extends CarImpl implements Sellable{
    private double price;

    public
    Seat (String model, String color, int horsePower, String countryProduced, double price) {
        super (model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public
    Double getPrice () {
        return null;
    }

    @Override
    public
    String toString () {
        return String.format ("%s%n%s sells for %f",super.toString (), getModel (), getPrice ());
    }
}