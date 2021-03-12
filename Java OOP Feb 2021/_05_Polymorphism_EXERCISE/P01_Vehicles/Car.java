package _05_Polymorphism_EXERCISE.P01_Vehicles;

public class Car extends Vehicle implements  iVehicle{

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 0.9);
    }

    @Override
    public String drive(double distance) {
        return "Car " + super.drive(distance);
    }
}
