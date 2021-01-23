package SetsAndMaps_EXERCISE_06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();
        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            phonebook.put(tokens[0],tokens[1]);
            input=scanner.nextLine();
        }

        String search = scanner.nextLine();
        while (!search.equals("stop")) {
           if (phonebook.containsKey(search)){
               System.out.println(search + " -> " + phonebook.get(search));
           } else {
               System.out.println("Contact " + search + " does not exist.");
           }
           search= scanner.nextLine();
        }

        //phonebook.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

    }
}
