package _14_Generics_LAB.P02_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = (Integer[]) ArrayCreator.create(3, 10);
        String[] strings = ArrayCreator.create(String.class, 3, "None");

        for (Integer number : numbers) {
            System.out.println(number);
        }

        System.out.println("--------------------------");

        for (String str : strings) {
            System.out.println(str);
        }
    }
}