package _03_Inheritance_EXERCISE.P04_NeedForSpeed;

public class Vehicle {

    final static double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuel;
    private int horsePower;
    private double fuelConsumption;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    public void drive (double kilometers) {

        double remainingFuel = this.getFuel() - (kilometers * this.getFuelConsumption());
        if (remainingFuel >= 0){
            this.setFuel(remainingFuel);
        }
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
