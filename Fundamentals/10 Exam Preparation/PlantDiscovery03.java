package com.company.FinalExamPrep04April2020;

import java.util.*;

public class PlantDiscovery03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Plants> allPlants = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("<->");
            Plants p = new Plants(line[0], Integer.parseInt(line[1]));
            allPlants.put(p.getName(), p);
        }


        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] commands = input.split(": ");
            switch (commands[0]) {
                case "Rate":
                    String[] rateParameters = commands[1].split(" - ");
                    String ratePlantName = rateParameters[0];
                    int rating = Integer.parseInt(rateParameters[1]);

                    Plants ratePlant = allPlants.get(ratePlantName);
                    if (ratePlant != null){
                        ratePlant.addRating(rating);
                    } else {
                        System.out.println("error");
                    }

                    break;
                case "Update":
                    String[] updateParameters = commands[1].split(" - ");
                    String updatePlantName = updateParameters[0];
                    int rarity = Integer.parseInt(updateParameters[1]);

                    Plants updatePlant = allPlants.get(updatePlantName);
                    if (updatePlant !=  null) {
                        updatePlant.setRarity(rarity);
                    } else {
                        System.out.println("error");
                    }

                    break;
                case "Reset":
                    String resetPlantName = commands[1];

                    Plants resetPlant = allPlants.get(resetPlantName);
                    if (resetPlant !=  null) {
                        resetPlant.resetRating();
                    } else {
                        System.out.println("error");
                    }


                    break;
                default:
                    System.out.println("error");
                    break;

            }
            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");

        allPlants.values().stream()
                .sorted((a, b) -> {
                    if (a.getRarity() != b.getRarity()) {
                        return Integer.compare(b.getRarity(),a.getRarity());
                    } else {
                        return Double.compare(b.getAverageRating(),a.getAverageRating());
                    }
                })
                .map(p -> " - " + p.getName() + "; Rarity: " + p.getRarity() + "; Rating: " + String.format("%.2f", p.getAverageRating()))
                .forEach(s -> System.out.println(s));
    }

    static class Plants {
        String name;
        int rarity;
        List<Double> ratings;

        public Plants(String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
            this.ratings = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addRating(double rating) {
            this.ratings.add(rating);
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public void resetRating() {
            this.ratings.clear();
        }

        public int getRarity() {
            return rarity;
        }

        public double getAverageRating() {
            if (this.ratings.isEmpty()) {
                return 0;
            }

            double avgRating = 0;
            for (Double rating : this.ratings) {
                avgRating += rating;
            }

            avgRating = avgRating / this.ratings.size();
            return avgRating;
        }
    }
}
