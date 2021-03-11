package _04_Interfaces_And_Abstraction_EXERCISE.P03_BirthdayCelebrations;

public class Robot implements Identifiable{

    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }
}
