package SetsAndMaps_EXERCISE_06;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //country       city     population
        Map<String, Map<String, Long>> populationInfo = new LinkedHashMap<>();

        String line = "";
        while (!"report".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            populationInfo.putIfAbsent(country, new LinkedHashMap<>());
            populationInfo.get(country).putIfAbsent(city, population);
        }

        // durjava 1 sravnena s durjava 2
        populationInfo.entrySet().stream().sorted((c1, c2) -> {
            //c1.getValue (vzima vutreshniq map -> values stoinostitne na vutreshniq map
            long p1 = c1.getValue().values().stream().mapToLong(l -> l).sum();
            long p2 = c2.getValue().values().stream().mapToLong(e -> e).sum();
            //sortirame v namalqvash red
            return Long.compare(p2, p1);
        }).forEach(c -> {
            long totalPopulation = c.getValue().values().stream().mapToLong(e -> e).sum();
            System.out.println(String.format("%s (total population: %d)",c.getKey(),totalPopulation));
            Map<String, Long> cityInfo = c.getValue();
            cityInfo.entrySet().stream().sorted((c1, c2) -> Long.compare(c2.getValue(),c1.getValue()))
                    .forEach(c1 -> System.out.println(String.format("=>%s: %d",c1.getKey(),c1.getValue())));
        });
    }
}