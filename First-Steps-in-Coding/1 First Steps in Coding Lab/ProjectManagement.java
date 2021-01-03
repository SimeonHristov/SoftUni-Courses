package Lab01;

import java.util.Scanner;

public class ProjectManagement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

         String name = scan.nextLine();
         int projectCount = Integer.parseInt(scan.nextLine());
         int requiredTime = projectCount * 3;

         System.out.printf("The architect %s will need %d hours to complete %d project/s.", name,requiredTime,projectCount);
    }
}
