import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Float x = Float.valueOf(50);
        Float y = Float.valueOf(42);
        Float res = x/y;
        Float qwe = (x % y) * 100;
        Float zxc = y % x;

//        int x = 50;
//        int y = 42;
//        int res = Math.abs(x/y)* 100;

        System.out.println(res);
        System.out.println(qwe);
        System.out.println(zxc);
    }
}
