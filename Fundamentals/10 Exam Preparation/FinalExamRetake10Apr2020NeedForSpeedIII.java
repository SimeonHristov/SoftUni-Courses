package com.company.FinalExamPrep04April2020;

import javax.print.DocFlavor;
import java.util.*;

public class FinalExamRetake10Apr2020NeedForSpeedIII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Car> carsMap = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carInformation = scanner.nextLine().split("\\|");
            String name = carInformation[0];
            int mileage = Integer.parseInt(carInformation[1]);
            int fuel = Integer.parseInt(carInformation[2]);
            Car c = new Car(name, mileage, fuel);
            carsMap.put(name, c);
        }

        String line = scanner.nextLine();
        while (!line.equals("Stop")) {
            String[] tokens = line.split(" : ");
            String command = tokens[0];

            switch (command) {
                case "Drive":
                    String driveCar = tokens[1];
                    int distance = Integer.parseInt(tokens[2]);
                    int fuelNeeded = Integer.parseInt(tokens[3]);

                    if (carsMap.get(driveCar).getFuel() < fuelNeeded) {
                        System.out.println("Not enough fuel to make that ride");
                        break;
                    } else {
                        carsMap.get(driveCar).setMileage(carsMap.get(driveCar).getMileage()+distance);
                        carsMap.get(driveCar).setFuel(carsMap.get(driveCar).getFuel()-fuelNeeded);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",driveCar,distance,fuelNeeded);
                    }

                    if (carsMap.get(driveCar).getMileage() > 100000) {
                        System.out.printf("Time to sell the %s!%n",driveCar);
                        carsMap.remove(driveCar);
                    }

                    break;


                case "Refuel":
                    String fuelCar = tokens[1];
                    int fuelAmount = Integer.parseInt(tokens[2]);

                    if (carsMap.get(fuelCar).getFuel() + fuelAmount > 75) {
                        int reFueledAmount = 75 - carsMap.get(fuelCar).getFuel();
                        carsMap.get(fuelCar).setFuel(75);
                        System.out.printf("%s refueled with %d liters%n", fuelCar, reFueledAmount);
                    } else {
                        carsMap.get(fuelCar).setFuel(carsMap.get(fuelCar).getFuel() + fuelAmount);
                        System.out.printf("%s refueled with %d liters%n", fuelCar, fuelAmount);
                    }
                    break;


                case "Revert":
                    String carRevert = tokens[1];
                    int mileageRevert = Integer.parseInt(tokens[2]);

                    if (carsMap.get(carRevert).getMileage() - mileageRevert <= 10000) {
                        carsMap.get(carRevert).setMileage(10000);
                        break;

                    } else {
                        carsMap.get(carRevert).setMileage(carsMap.get(carRevert).getMileage() - mileageRevert);
                        System.out.printf("%s mileage decreased by %d kilometers%n", carRevert, mileageRevert);
                    }
                    break;
            }
            line = scanner.nextLine();
        }


        List<Car> sortedCars = new ArrayList<>(carsMap.values());
        Collections.sort(sortedCars,(a,b) -> {
            int compareMileage = Integer.compare(b.getMileage(),a.getMileage());
            if (compareMileage ==0 ) {
                return a.getName().compareTo(b.getName());
            } else {
                return  compareMileage;
            }
        });

        for (Car sortedCar : sortedCars) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                    sortedCar.getName(),sortedCar.getMileage(),sortedCar.getFuel());
        }

    }

    static class Car {
        String name;
        int mileage;
        int fuel;

        public Car(String name, int mileage, int fuel) {
            this.name = name;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }
}
