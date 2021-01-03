package Exercise03;

import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String year = scanner.nextLine(); //"leap" (високосна година) или "normal" (невисокосна).
        int holidays = Integer.parseInt(scanner.nextLine());            //брой празници в годината (които не са събота и неделя).
        int travel = Integer.parseInt(scanner.nextLine());            //брой уикенди, в които Влади си пътува до родния град.

        int weekends = 48;
        double freeWeekends = weekends - travel;
        double saturdayGames= freeWeekends * 3/4.0;
        double holidayGames=  holidays * 2/3.0;
        double total = saturdayGames + travel + holidayGames;
        double totalPlus15= total * 1.15;

        if (year.equals("leap")) {
            System.out.println(Math.floor(totalPlus15));
        } else if (year.equals("normal")) {
            System.out.println(Math.floor(total));
        }


//        Той е много запален по волейбола, но е зает през работните дни и играе волейбол само през уикендите и в празничните дни.
//                Влади играе в София всяка събота, когато не е на работа и не си пътува до родния град, както и в 2/3 от празничните дни.
//                Той пътува до родния си град h пъти в годината, където играе волейбол със старите си приятели в неделя.
//        Влади не е на работа 3/4 от уикендите, в които е в София. Отделно, през високосните години
//        Влади играе с 15% повече волейбол от нормалното. Приемаме, че годината има точно 48 уикенда, подходящи за волейбол.
    }
}
