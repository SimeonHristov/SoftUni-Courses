package Exercise05;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bookName = scanner.nextLine();
        int bookCount = 0;
        boolean isFound = false;
        String input = scanner.nextLine();

        while (!input.equals("No More Books")) {

            if (input.equals(bookName)) {
                isFound = true;
                break;
            }
            bookCount++;
            input = scanner.nextLine();
        }

        if (isFound) {
            System.out.printf("You checked %d books and found it.",bookCount);
        } else{
            System.out.printf("The book you search is not here!%nYou checked %d books.",bookCount);
        }
    }
}

