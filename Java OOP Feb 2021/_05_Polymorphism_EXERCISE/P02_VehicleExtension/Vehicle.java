package _05_Polymorphism_EXERCISE.P02_VehicleExtension;

import java.text.DecimalFormat;

public class Vehicle implements iVehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void  setTankCapacity (double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;

        DecimalFormat df = new DecimalFormat("#.##");

        String result = "needs refueling";

        if (this.fuelQuantity >= fuelNeeded) {
            result = String.format("travelled %s km", df.format(distance));
            this.fuelQuantity -= fuelNeeded;
        }

        return result;
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this.fuelQuantity + liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
