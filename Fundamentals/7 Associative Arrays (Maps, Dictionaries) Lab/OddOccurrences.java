package com.company.Lab07AssociativeArrays07;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Map<String, Integer> inputOccurance = new LinkedHashMap<>();

        for (String s : input) {
            String words = s.toLowerCase();
            if (inputOccurance.containsKey(words)){
                inputOccurance.put(words, inputOccurance.get(words) + 1);
                // vzemi value-to na tozi kluch i dobavi +1
            } else {
                inputOccurance.put (words,1);
            }
        }

        List <String> odds = new ArrayList<>();

//        for (Map.Entry<String, Integer> entry : inputOccurance.entrySet()) {
//            if (entry.getValue() % 2 == 0){
//                odds.add(entry.getKey());
//            }
//        }

        for (var entry : inputOccurance.entrySet()){
            if (entry.getValue() % 2 == 1){
                odds.add(entry.getKey());
            }
        }


        for (int i = 0; i < odds.size() ; i++) {
            System.out.print(odds.get(i));
            if (i < odds.size()-1){
                System.out.print(", ");
            }
        }

      //  System.out.println(String.join(", ",odds));

    }

}
