//package FinalExamPrep04April2020Group1;
//
//import kotlin.reflect.jvm.internal.impl.util.CheckResult;
//
//import java.util.*;
//
//public class PiratesWithLists03 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//
//        String[] input = scanner.nextLine().split("\\|\\|");
//
//        Map<String, List<Integer>> cities = new HashMap<>();
//        while (!input[0].equals("Sail")) {
//
//            String name = input[0];
//            int population = Integer.parseInt(input[1]);
//            int gold = Integer.parseInt(input[2]);
//
//
////            if (!cities.containsKey(name)) {
//////                cities.put(name, Arrays.asList(population, gold));
//////                cities.get(name).get(1) > 1 ;
////
////            } else {
////                List<Integer> currentResource = cities.get(name);
////
////                cities.get(name).curr> population;
//////                int newPop = currentResource.get(0) + population;
//////                int newGold = currentResource.get(1) + gold;
////
////                cities.put(name, Arrays.asList(newPop, newGold));
////            }
//
//            input = scanner.nextLine().split("\\|\\|");
//            ;
//
//        }
//
//        String[] inputEvents = scanner.nextLine().split("=>");
//
//        while (!inputEvents[0].equals("End")) {
//            if (inputEvents[0] == "Plunder") {
//                cities = PlunderCity(cities, inputEvents[1], int.Parse(inputEvents[2]), int.Parse(inputEvents[3]));
//            } else {
//                cities = ProsperCity(cities, inputEvents[1], int.Parse(inputEvents[2]));
//            }
//
//            inputEvents = scanner.nextLine().split("=>");
//
//        }
//
//        //cities = cities.OrderByDescending(x = > x.Value[1]).ThenBy(x = > x).ToDictionary(x = > x.Key, x =>x.Value);
//
//        if (cities.size() > 0) {
//            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",cities.size());
//
//            cities.entrySet()
//                    .stream()
//                    .sorted((f, s) -> s.getValue().size() - f.getValue().size())
//                    .forEach(e -> {
//                        System.out.println(e.getKey() + ": " + e.getValue().size());
//                        e.getValue()
//                                .stream()
//                                .sorted((f, s) -> f.compareTo(s))
//                                .forEach(s -> System.out.println("-- " + s));
//                    });
//        } else {
//            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
//        }
//
//    }
//    static Dictionary<String, List<Integer>> PlunderCity(Dictionary<String, List<Integer>> cities, String town,int people, int gold)
//    {
//        cities[town][0] -= people;
//        cities[town][1] -= gold;
//
//        int newPop = currentResource.get(0) + population;
//        int newGold = currentResource.get(1) + gold;
//
//        cities.put(name, Arrays.asList(newPop, newGold));
//        Console.WriteLine($"{town} plundered! {gold} gold stolen, {people} citizens killed.");
//
//        if (cities[town][0] <= 0 || cities[town][1] <= 0)
//        {
//            cities.Remove(town);
//            Console.WriteLine($"{town} has been wiped off the map!");
//        }
//        return cities;
//    }
//
//    static Dictionary<string, List<int>> ProsperCity(Dictionary<string, List<int>> cities, string town, int gold)
//    {
//        if (gold <= 0)
//        {
//            Console.WriteLine("Gold added cannot be a negative number!");
//        }
//        else
//        {
//            cities[town][1] += gold;
//            Console.WriteLine($"{gold} gold added to the city treasury. {town} now has {cities[town][1]} gold.");
//        }
//        return cities;
//    }
//}
