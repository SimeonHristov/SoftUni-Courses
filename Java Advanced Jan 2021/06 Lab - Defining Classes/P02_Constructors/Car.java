package _11_DefiningClasses_LAB.P02_Constructors;

public class Car {
    public static String UNKNOWN_STR = "unknown";
    public static int INVALID_HORSE_POWER = -1;
    private String make;
    private String model;
    private Integer horsePower;

    public Car(String make, String model, Integer horsePower) {
        this(make, model);
        this.horsePower = horsePower;
    }

    public Car(String make){
        this.make = make;
        this.model = UNKNOWN_STR;
        this.horsePower = INVALID_HORSE_POWER;
    }

    public Car(String make, String model){
        this.make = make;
        this.model = model;
        this.horsePower = INVALID_HORSE_POWER;
    }

    public Car(Integer horsePower){
        this.make = UNKNOWN_STR;
        this.model = UNKNOWN_STR;
        this.horsePower = horsePower;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.make,
                this.model,
                this.horsePower);
    }
}