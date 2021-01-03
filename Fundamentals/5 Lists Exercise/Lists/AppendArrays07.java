package com.company.Exercise05.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrays = scanner.nextLine().split("\\|");
        String result = "";

        for (int i = arrays.length - 1; i >= 0 ; i--) {
            String[] currentArr = arrays[i].split("\\s+");
            for (int j = 0; j < currentArr.length; j++) {
               if(!currentArr[j].equals("")) {
                result += currentArr[j] + " ";
            }
        }
    }
        System.out.println(result.trim());
    }

}
