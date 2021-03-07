//package _04_Interfaces_And_Abstraction.P01_CarShop;

public class Seat implements Car {

    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;

    public Seat(String model, String color, int horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;

    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String getCountryProduced() {
        return countryProduced;
    }

    @Override
    public String getColor() {
        return color;
    }

        public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.getModel(),this.getCountryProduced(),this.TIRES);
    }
}
