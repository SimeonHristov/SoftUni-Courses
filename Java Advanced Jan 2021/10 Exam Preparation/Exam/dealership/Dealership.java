//package dealership;
package _18_ExamPreparation.Exam.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;


    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (this.capacity > this.data.size()){
            this.data.add(car);
        }
    }

    public boolean buy (String manufacturer, String model) {
        return this.data.removeIf(c-> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }

    public Car getLatestCar() {
        Car car = null;
        for (Car c : data) {
            if (car == null || car.getYear() < c.getYear()){
                car = c;
            }
        }
        return car;
    }

    public Car getCar (String manufacturer, String model){
        Car car = null;
        for (Car c : data) {
            if (c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)){
                car = c;
            }
        }
        return car;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics (){
        StringBuilder out = new StringBuilder();
        out.append("The cars are in a car dealership " + this.name + ":").append(System.lineSeparator());

        for (Car c : data) {
           out.append(c.toString()).append(System.lineSeparator());
        }

        return out.toString().trim();
    }



}
