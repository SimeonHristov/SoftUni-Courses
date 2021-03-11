package _04_Interfaces_And_Abstraction_EXERCISE.P01_DefineAnInterfacePerson;

public class Citizen implements Person {

    private String name;
    private int age;

    public Citizen(String name, int age) {
        setName(name);
        setAge(age);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }
}
