package _02_Encapsulation.P04_FirstAndReserveTeam;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
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
       if (salary < 460){
           throw new IllegalStateException("Salary cannot be less than 460 leva");
       } else {
           this.salary = salary;
       }
    }

    public void setFirstName(String firstName) {
        if (firstName.trim().length() < 3) {
            throw new IllegalStateException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.trim().length() < 3) {
            throw new IllegalStateException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age <= 0){
            throw new IllegalStateException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void increaseSalary (double percentage) {
        if (this.age < 30) {
            this.setSalary(this.getSalary() +  ((this.getSalary() /100) * (percentage / 2)));
        } else {
            this.setSalary(this.getSalary() +  ((this.getSalary() /100) * percentage));
        }
    }
}
