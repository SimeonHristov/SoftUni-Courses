package _14_Generics_LAB.P03_Generic_Scale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> integerScale = new Scale<>(10, 20);

        System.out.println(integerScale.getHeavier());

        Scale<Integer> integerScaleEqual = new Scale<>(10, 10);

        System.out.println(integerScaleEqual.getHeavier());

        Scale<String> stringScale = new Scale<>("A", "B");

        System.out.println(stringScale.getHeavier());
    }
}

