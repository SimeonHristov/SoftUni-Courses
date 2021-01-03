package com.company.MidExam29February2020;

import com.sun.jdi.PathSearchingVirtualMachine;
import com.sun.security.jgss.GSSUtil;

import javax.lang.model.type.MirroredTypeException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventory = Arrays.stream(scanner.nextLine()
                .split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {

            String[] cmdInput = input.split(" - ");
            String command = cmdInput[0];
            switch (command) {
                case "Collect":
                    if (!inventory.contains(cmdInput[1])) {
                        inventory.add(cmdInput[1]);
                    }
                    break;
                case "Drop":
                    if (inventory.contains(cmdInput[1])) {
                        inventory.remove(cmdInput[1]);
                    }
                    break;
                case "Combine Items":
                    String[] items = cmdInput[1].split(":");
                    if (inventory.contains(items[0])){
                        int index = inventory.indexOf(items[0]);
                        inventory.add(index+1,items[1]);
                    }
                    break;
                case "Renew":
                    if (inventory.contains(cmdInput[1])) {
                        inventory.remove(cmdInput[1]);
                        inventory.add(cmdInput[1]);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

//        for (int i = 0; i < inventory.size() ; i++) {
//            if (i < inventory.size()-1){
//                System.out.print(inventory.get(i) + ", ");
//            }
//            System.out.print(i);
//        }

        System.out.println(String.join(", ", inventory));

    }
}
