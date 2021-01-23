package SetsAndMaps_EXERCISE_06;

import java.util.*;

public class SetOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> listOne = new LinkedHashSet<>();
        Set<Integer> listTwo = new LinkedHashSet<>();
        for (int i = 0; i < numbers[0]+numbers[1]; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (i < numbers[0]) {
                listOne.add(num);
            } else {
                listTwo.add(num);
            }
        }

        for (Integer integer : listOne) {
            if (listTwo.contains(integer)){
                System.out.print(integer + " ");
            }
        }

    }
}
