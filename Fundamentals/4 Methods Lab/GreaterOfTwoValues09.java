package com.company.Lab04.Methods;

import java.util.Scanner;

public class GreaterOfTwoValues09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String valueOne = scanner.nextLine();
        String valueTwo = scanner.nextLine();

        if (type.equals("int")){
            System.out.println(getMax(valueOne,valueTwo));;
        } else if (type.equals("string")){
            System.out.println(getMax(valueOne,valueTwo));;
        } else if (type.equals("char")) {
            System.out.println(getMax(valueOne,valueTwo));;
        }
    }

    public static int getMax (int valueOne, int valueTwo){
        if (valueOne > valueTwo){
            return valueOne;
        }
        return valueTwo;
    }

    public static String getMax (String valueOne, String valueTwo){
        if(valueOne.compareTo(valueTwo)>=0){
            return valueOne;
        }
        return valueTwo;
    }

    public static char getMax (char valueOne, char valueTwo){
        if (valueOne > valueTwo){
            return valueOne;
        }
        return valueTwo;
    }


}


