package MultidimensionalArrays_Exercise_04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheHeiganDance_08 {

    private static final Integer CENTER = 7;
    private static final Integer DAMAGE_CLOUD = 3500;
    private static final Integer DAMAGE_ERUPTION = 6000;
    private static String ATTACK_CLOUD = "Cloud";
    private static String ATTACK_ERUPTION = "Eruption";
    private static String OUTPUT_CLOUD = "Plague Cloud";
    private static String OUTPUT_ERUPTION = "Eruption";

    private static Integer playerRow = 7;
    private static Integer playerCol = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer playerHealthPoints = 18500;
        Double heiganHealthPoints = 3000000d;
        Double playerDamage = Double.parseDouble(scanner.nextLine());
        List<List<Character>> matrix = createMatrix();
        ArrayDeque<Integer> clouds = new ArrayDeque<>();
        String lastAttackType = null;
        while (true) {
            String[] attackInput = scanner.nextLine().split("\\s+");
            String attackType = attackInput[0];
            Integer attackRow = Integer.parseInt(attackInput[1]);
            Integer attackCol = Integer.parseInt(attackInput[2]);

            if (!clouds.isEmpty()) {
                playerHealthPoints -= clouds.poll();
            }
            heiganHealthPoints -= playerDamage;
            if (playerHealthPoints > 0 && heiganHealthPoints > 0 && attack(attackRow, attackCol)) {
                if (attackType.equals(ATTACK_ERUPTION)) {
                    playerHealthPoints -= DAMAGE_ERUPTION;
                    lastAttackType = OUTPUT_ERUPTION;
                } else if (attackType.equals(ATTACK_CLOUD)) {
                    playerHealthPoints -= DAMAGE_CLOUD;
                    lastAttackType = OUTPUT_CLOUD;
                    clouds.push(DAMAGE_CLOUD);
                }
            }

            if (playerHealthPoints <= 0 || heiganHealthPoints <= 0) {
                if (heiganHealthPoints <= 0) {
                    System.out.println("Heigan: Defeated!");
                } else {
                    System.out.println(String.format("Heigan: %.2f", heiganHealthPoints));
                }

                if (playerHealthPoints <= 0) {
                    System.out.println("Player: Killed by " + lastAttackType);
                } else {
                    System.out.println("Player: " + playerHealthPoints);
                }
                System.out.println(String.format("Final position: %s, %s", playerRow, playerCol));
                break;
            }

        }

    }

    private static boolean attack(int attackRow, int attackCol) {

        if (!isPlayerHit(attackRow, attackCol, playerRow, playerCol)) {
            return false;
        }

        // Try to move up!
        if (!isPlayerHit(attackRow, attackCol, playerRow - 1, playerCol) && playerRow - 1 >= 0) {
            playerRow--;
            return false;
        }

        // Try to move right

        if (!isPlayerHit(attackRow, attackCol, playerRow, playerCol + 1) && playerCol + 1 < 15) {
            playerCol++;
            return false;
        }

        // Try to move down

        if (!isPlayerHit(attackRow, attackCol, playerRow + 1, playerCol) && playerRow + 1 < 15) {
            playerRow++;
            return false;
        }

        // Try to move left

        if (!isPlayerHit(attackRow, attackCol, playerRow, playerCol - 1) && playerCol - 1 >= 0) {
            playerCol--;
            return false;
        }

        return true;
    }

    private static boolean isPlayerHit(int attackRow, int attackCol, int playerRow, int playerCol) {

        // UP (Left side)
        if (attackRow - 1 == playerRow && attackCol - 1 == playerCol) {
            return true;
        }

        // UP (Center)
        if (attackRow - 1 == playerRow && attackCol == playerCol) {
            return true;
        }

        // UP (Right side)

        if (attackRow - 1 == playerRow && attackCol + 1 == playerCol) {
            return true;
        }

        // Center (Left side)

        if (attackRow == playerRow && attackCol - 1 == playerCol) {
            return true;
        }

        // Center (Center)

        if (attackRow == playerRow && attackCol == playerCol) {
            return true;
        }

        // Center (Right side)

        if (attackRow == playerRow && attackCol + 1 == playerCol) {
            return true;
        }

        // Down (Left side)

        if (attackRow + 1 == playerRow && attackCol - 1 == playerCol) {
            return true;
        }

        // Down (Center)

        if (attackRow + 1 == playerRow && attackCol == playerCol) {
            return true;
        }

        // Down (Right side)

        if (attackRow + 1 == playerRow && attackCol + 1 == playerCol) {
            return true;
        }

        return false;
    }

    private static void printMatrix(List<List<Character>> matrix) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(matrix.get(i).get(j));
            }
            System.out.println();
        }
    }

    private static List<List<Character>> createMatrix() {

        List<List<Character>> matrix = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            List<Character> cols = new ArrayList<>();
            for (int j = 0; j < 15; j++) {
                cols.add('*');
            }
            matrix.add(new ArrayList<>(cols));
        }
        return matrix;


    }

}
