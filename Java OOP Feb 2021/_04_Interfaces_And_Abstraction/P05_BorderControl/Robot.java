package _04_Interfaces_And_Abstraction.P05_BorderControl;

public class Robot implements Identifiable {
    private String model;
    private String id;

    public
    String getModel () {
        return model;
    }

    public
    Robot (String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public
    String getId () {
        return id;
    }
}