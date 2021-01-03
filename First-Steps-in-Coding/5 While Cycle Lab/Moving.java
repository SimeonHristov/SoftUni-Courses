package Lab05;



import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int volume = width*length*height;

        while (!input.equals("Done")) {
            int boxCount = Integer.parseInt(input);
            volume -= boxCount;

            if (volume < 0) {
                System.out.printf("No more free space! You need %d Cubic meters more.",Math.abs(volume));
                return;
            }
            input = scanner.nextLine();

        }
        System.out.printf("%d Cubic meters left.", volume);
    }
}
