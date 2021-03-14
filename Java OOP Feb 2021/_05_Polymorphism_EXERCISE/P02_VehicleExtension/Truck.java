package _05_Polymorphism_EXERCISE.P02_VehicleExtension;

public class Truck extends Vehicle implements iVehicle {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6);
    }



    @Override
    public String drive(double distance) {
        return "Truck " + super.drive(distance);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters* 0.95);
    }
}
