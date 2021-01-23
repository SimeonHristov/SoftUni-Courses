package SetsAndMaps_EXERCISE_06;

import org.w3c.dom.xpath.XPathResult;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueUsername = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            uniqueUsername.add(input);
        }

        for (String s : uniqueUsername) {
            System.out.println(s);
        }
    }
}
