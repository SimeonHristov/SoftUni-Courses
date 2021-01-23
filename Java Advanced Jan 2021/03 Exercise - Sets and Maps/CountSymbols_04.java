package SetsAndMaps_EXERCISE_06;

import java.util.*;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        Map<Character, Integer> charInfo = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (charInfo.containsKey(c)) {
                int count = charInfo.get(c);
                charInfo.put(c, count + 1);
                continue;
            }
            charInfo.putIfAbsent(c,1);

        }

        charInfo.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() +" time/s"));
    }
}
