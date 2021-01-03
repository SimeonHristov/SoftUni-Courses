package com.company.Lab09.RegularExpressions;

        import javax.swing.text.MutableAttributeSet;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = "\\+359([- ])2\\1\\d{3}\\1\\d{4}\\b";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(input);

        List<String> phones = new ArrayList<>();
        while (matcher.find()) {
            phones.add(matcher.group());
        }

        System.out.println(String.join(", ",phones));
    }
}
