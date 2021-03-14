package _05_Polymorphism_EXERCISE.P02_VehicleExtension;

public class Bus extends Vehicle implements iVehicle{

    private static final boolean DEFAULT_IS_EMPTY = true;
    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        setEmpty(DEFAULT_IS_EMPTY);
    }

    public void setEmpty(boolean empty) {
        this.isEmpty = isEmpty;
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        if (!this.isEmpty){
            super.setFuelConsumption(fuelConsumption + 1.4);
        }
    }

    @Override
    public String drive(double distance) {
        return "Bus " + super.drive(distance);
    }
}
