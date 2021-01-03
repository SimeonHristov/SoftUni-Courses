package Exercise01;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    int lenght = Integer.parseInt(scan.nextLine());
    int width = Integer.parseInt(scan.nextLine());
    int height = Integer.parseInt(scan.nextLine());
    double occupiedSpacePrcnt = Double.parseDouble(scan.nextLine());
    int aquaVolume = lenght * width * height;
    double totalLitres = aquaVolume * 0.001;
    double convertToPercent = occupiedSpacePrcnt * 0.01;
    double actualLitres = totalLitres * (1-convertToPercent);
    System.out.printf("%.2f",actualLitres);

    }
}
