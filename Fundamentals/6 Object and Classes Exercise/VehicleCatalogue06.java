package com.company.Exercise06ObjectClasses;

import org.w3c.dom.ls.LSOutput;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue06 {
    static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        public Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public String vehicleInfo() {
            return String.format("Type: %s%n" +
                            "Model: %s%n" +
                            "Color: %s%n" +
                            "Horsepower: %d", getType().toUpperCase().charAt(0) + getType().substring(1)
                    , getModel(), getColor(), getHorsePower()
            );
        }
    }

    public static double averageHorsePower(List<Vehicle> vehicles) {
        if (vehicles.size() == 0) {
            return 0.0;
        }
        return vehicles.stream().mapToDouble(Vehicle::getHorsePower).sum()/ vehicles.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Vehicle> allVehicles = new ArrayList<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            Vehicle vehicle = new Vehicle(data[0], data[1], data[2], Integer.parseInt(data[3]));
            allVehicles.add(vehicle);

            input = scanner.nextLine();
        }

        String printBy = scanner.nextLine();

        while (!printBy.equals("Close the Catalogue")) {
            String model = printBy;

            allVehicles.stream()
                    .filter(vehicle -> vehicle.getModel().equals(model))
                    .forEach(vehicle -> System.out.println(vehicle.vehicleInfo()));

            printBy = scanner.nextLine();
        }

        List<Vehicle> cars = allVehicles.stream()
                .filter(vehicle -> vehicle.getType().equals("car"))
                .collect(Collectors.toList());

        List<Vehicle> trucks = allVehicles.stream()
                .filter(vehicle -> vehicle.getType().equals("truck"))
                .collect(Collectors.toList());

        System.out.printf("Cars have average horsepower of: %.2f.%n",averageHorsePower(cars));
        System.out.printf("Trucks have average horsepower of: %.2f.",averageHorsePower(trucks));
    }
}
