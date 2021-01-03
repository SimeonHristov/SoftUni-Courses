package com.company.Exercise05.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> sequence = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //4 5 3  - vhod
        //1  - index za premahvane (chisloto 5)
        //0 1 2 - index na chislata ot list
        int sumOfRemoved = 0;

        while (!sequence.isEmpty()){
            int index = Integer.parseInt(scanner.nextLine());
            int numberToRemove = 0;

            if (index < 0) {
//                numberToRemove = sequence.get(sequence.get(0));
//                sequence.set(sequence.get(0),sequence.get(sequence.size()-1));
//                sumOfRemoved+= numberToRemove;
                numberToRemove = sequence.remove(0);
                sumOfRemoved+= numberToRemove;
                sequence.add(0,sequence.get(sequence.size()-1));
            } else if (index > sequence.size()-1) {
//                numberToRemove = sequence.get(sequence.size()-1);
//                sequence.set(sequence.size()-1,sequence.get(0));
//                sumOfRemoved+= numberToRemove;
                numberToRemove = sequence.remove(sequence.size()-1);
                sequence.add(sequence.get(0));
                sumOfRemoved+= numberToRemove;

            } else {
                numberToRemove = sequence.remove(index);
                sumOfRemoved+=numberToRemove;
            }

            for (int i = 0; i < sequence.size(); i++) {
                if (sequence.get(i) <= numberToRemove) {
                    sequence.set(i, sequence.get(i) + numberToRemove);
                } else if (sequence.get(i) >= numberToRemove) {
                    sequence.set(i, sequence.get(i) - numberToRemove);
                }
            }


        }

        System.out.println(sumOfRemoved);


    }
}
