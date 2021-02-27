package _02_Encapsulation.P02_SalaryIncrease;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.1f leva.", this.firstName, this.lastName, this.salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary (double percentage) {
        if (this.age < 30) {
            this.setSalary(this.getSalary() +  ((this.getSalary() /100) * (percentage / 2)));
        } else {
            this.setSalary(this.getSalary() +  ((this.getSalary() /100) * percentage));
        }
    }
}
