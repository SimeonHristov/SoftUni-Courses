package _04_Interfaces_And_Abstraction_EXERCISE.P04_FoodShortage;

public class Citizen implements Person, Identifiable, Birthable, Buyer {
    private static int FOOD_INCREASE = 10;

    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;


    public Citizen(String name, int age, String id, String birthDate) {
        setName(name);
        setAge(age);
        setId(id);
        setBirthDate(birthDate);

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }


    @Override
    public String getBirthDate() {
        return  this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void buyFood() {
        this.food += FOOD_INCREASE;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    private void setFood(int food) {
        this.food = food;
    }
}
