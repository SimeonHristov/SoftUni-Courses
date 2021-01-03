package com.company.FinalExamPrep04April2020;


import java.sql.SQLOutput;
import java.util.*;


public class Pirates03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cityInfo = scanner.nextLine();

        Map<String, City> citiesMap = new HashMap<>();
        while (!cityInfo.equals("Sail")) {
            String[] cityInfoData = cityInfo.split("\\|\\|");
            String name = cityInfoData[0];
            int population = Integer.parseInt(cityInfoData[1]);
            int gold = Integer.parseInt(cityInfoData[2]);

            City c = new City(name, population, gold);
            if (!citiesMap.containsKey(name)) {
                citiesMap.put(name, c);
            } else {
                citiesMap.get(name).population += population;
                citiesMap.get(name).gold += gold;
            }

            cityInfo = scanner.nextLine();
        }

        String eventsInfo = scanner.nextLine();
        while (!eventsInfo.equals("End")) {
            String[] events = eventsInfo.split("=>");

            switch (events[0]) {
                case "Plunder":
                    String plunderCity = events[1];
                    int peopleKilled = Integer.parseInt(events[2]);
                    int goldStolen = Integer.parseInt(events[3]);

                    citiesMap.get(plunderCity).setGold(citiesMap.get(plunderCity).gold - goldStolen);
                    citiesMap.get(plunderCity).setPopulation(citiesMap.get(plunderCity).population - peopleKilled);
                    System.out.println(plunderCity + " plundered! " + goldStolen + " gold stolen, " + peopleKilled + " citizens killed.");

                    if (citiesMap.get(plunderCity).population <= 0 || citiesMap.get(plunderCity).gold <= 0) {
                        citiesMap.remove(plunderCity);
                        System.out.println(plunderCity + " has been wiped off the map!");
                    }
                    break;


                case "Prosper":
                    String prosperCity = events[1];
                    int goldAdded = Integer.parseInt(events[2]);
                    if (goldAdded < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    }
                    citiesMap.get(prosperCity).setGold(citiesMap.get(prosperCity).gold + goldAdded);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldAdded, prosperCity, citiesMap.get(prosperCity).gold);
                    break;
            }


            eventsInfo = scanner.nextLine();
        }



        List<City> cityiesSorted = new ArrayList<>(citiesMap.values());
        Collections.sort(cityiesSorted, (a, b) -> {
            int goldCompare = Integer.compare(b.getGold(), a.getGold());
            if (goldCompare == 0) {
                return a.getName().compareTo(b.getName());
            } else {
                return goldCompare;
            }
        });
        if(citiesMap.size()>0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesMap.size());

            for (City city : cityiesSorted) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", city.name, city.population, city.gold);
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }

    static class City {
        String name;
        int population;
        int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }

}
