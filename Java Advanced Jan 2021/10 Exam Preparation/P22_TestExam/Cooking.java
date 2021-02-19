package _18_ExamPreparation.P22_TestExam;



import java.util.*;

import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque <Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(liquids::offer);

        ArrayDeque <Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::push);

        Map<Integer,String> foodMap = new HashMap<>();
        foodMap.put(25,"Bread");
        foodMap.put(50,"Cake");
        foodMap.put(75,"Pastry");
        foodMap.put(100,"Fruit Pie");

        Map<String, Integer> cookedItems = new TreeMap<>();
        cookedItems.put("Bread",0);
        cookedItems.put("Cake",0);
        cookedItems.put("Pastry",0);
        cookedItems.put("Fruit Pie",0);



        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int currentLiquid = liquids.poll();
            int currentIngredient = ingredients.pop();
            int sum = currentLiquid + currentIngredient;

            if (canCook(sum)) {
                cookedItems.put(foodMap.get(sum), cookedItems.get(foodMap.get(sum)) + 1);
            } else {
                ingredients.push(currentIngredient + 3);
            }
        }

        if (hasCookedAll(cookedItems)){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        System.out.println("Liquids left: " + getInfo(liquids));
        System.out.println("Ingredients left: " + getInfo(ingredients));

        for (Map.Entry<String, Integer> entry : cookedItems.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    private static boolean hasCookedAll(Map<String, Integer> cookedItems) {
        return  cookedItems.values().stream().noneMatch(v-> v==0);
    }

    private static boolean canCook(int sum) {
        return  sum == 25 || sum == 50 || sum == 75 || sum == 100;
    }

    private static String getInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "none"
                : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
