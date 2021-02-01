package _12_DefiningClasses_Exercise.P01_OpinionPoll;

public class Person {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString () {
        return String.format("%s - %d", this.name,this.age);
    }
}
