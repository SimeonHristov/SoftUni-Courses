package _18_ExamPreparation.P16_SantasPresentFactory;

import com.sun.source.tree.WhileLoopTree;

import java.awt.image.ImagingOpException;
import java.util.*;
import java.util.stream.Collectors;

public class Draft {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materials = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materials::push);
        ArrayDeque<Integer> magicLevel = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // add()

        // Stack


        Map<Integer, String> table = new HashMap<>();
        table.put(150, "Doll");
        table.put(250, "Wooden train");
        table.put(300, "Teddy bear");
        table.put(400, "Bicycle");

        Map<String, Integer> craftedGifts = new TreeMap<>();
        craftedGifts.put("Doll", 0);
        craftedGifts.put("Wooden train", 0);
        craftedGifts.put("Teddy bear", 0);
        craftedGifts.put("Bicycle", 0);

        boolean isCompeleted = false;

        while (!materials.isEmpty() && !magicLevel.isEmpty()) {


            int currentMaterial = materials.peek();
            int currentMagicLevel = magicLevel.peek();
            int sum = currentMaterial * currentMagicLevel;

            if (currentMaterial != 0 && currentMagicLevel != 0) {
                materials.pop();
                magicLevel.poll();
                if (sum > 0) {
                    if (canCraft(sum)) {
                        String craftedItem = table.get(sum);
                        craftedGifts.put(craftedItem, craftedGifts.get(craftedItem) + 1);
                    } else {
                        materials.push(currentMaterial + 15);
                    }
                } else {
                    materials.push(currentMaterial + currentMagicLevel);
                }
            } else {
                if (materials.peek() == 0) {
                    materials.pop();
                }
                if (magicLevel.peek() == 0) {
                    magicLevel.poll();
                }
            }
        }
        if (((craftedGifts.containsKey("Teddy bear") && craftedGifts.containsKey("Bicycle"))
                && (craftedGifts.get("Teddy bear") > 0 && craftedGifts.get("Bicycle") > 0))
                || ((craftedGifts.containsKey("Wooden train") && craftedGifts.containsKey("Doll"))
                && (craftedGifts.get("Wooden train") > 0 && craftedGifts.get("Doll") > 0))) {

            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }


        if (!materials.isEmpty()) {
            System.out.printf("Materials left: %s%n", materials.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        }

        if (!magicLevel.isEmpty()) {
            System.out.printf("Magic left: %s%n", magicLevel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }


        for (Map.Entry<String, Integer> gift : craftedGifts.entrySet()) {
            if (gift.getValue() != 0) {
                System.out.printf("%s: %d%n", gift.getKey(), gift.getValue());
            }
        }
    }

    private static boolean canCraft(int sum) {
        return sum == 400 || sum == 300 || sum == 250 || sum == 150;
    }

}