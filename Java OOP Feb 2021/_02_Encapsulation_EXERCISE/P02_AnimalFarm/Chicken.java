package _02_Encapsulation_EXERCISE.P02_AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalStateException("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalStateException("Age should be between 0 and 15.");
        } else {
            this.age = age;
        }
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.age < 6) {
            return 2.00;
        } else if (this.age < 12) {
            return 1.00;
        } else {
            return 0.75;
        }

    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, this.productPerDay());
    }
}
