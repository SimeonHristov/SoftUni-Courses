package _18_ExamPreparation;


import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //Que
        ArrayDeque<Integer> effects =Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        //Stack
        ArrayDeque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(e -> casings.push(e));

        Map<Integer, String> bombModels = new HashMap<>();
        bombModels.put(40, "Datura Bombs");
        bombModels.put(60, "Cherry Bombs");
        bombModels.put(120, "Smoke Decoy Bombs");

        Map<String, Integer> bombs = new TreeMap<>();
        bombModels.values().forEach(v -> bombs.put(v, 0));

        while (!effects.isEmpty() && !casings.isEmpty()) {
            if(isPouchFull(bombs)){
                break;
            }
            int currentEffect = effects.peek();
            int currentCasing = casings.pop();
            int sum = currentEffect + currentCasing;

            if (canCreateBomb(sum)) {
                String bombModel = bombModels.get(sum);
                bombs.put(bombModel, bombs.get(bombModel) + 1);
                effects.poll();
            } else {
                casings.push(currentCasing - 5);
            }
        }

        if (isPouchFull(bombs)){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.println("Bomb Effects: " + getInfo(effects));
        System.out.println("Bomb Casings: " + getInfo(casings));

        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            System.out.println(String.format("%s: %d", entry.getKey(),entry.getValue()));
        }

    }

    private static String getInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "empty"
                : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    private static boolean isPouchFull(Map<String, Integer> pouch) {
        return  (pouch.get("Datura Bombs") > 2 && pouch.get("Cherry Bombs") > 2
                && pouch.get("Smoke Decoy Bombs") > 2);
    }

    private static boolean canCreateBomb(int sum) {
        return sum == 40 || sum == 60 || sum == 120;
    }

}
