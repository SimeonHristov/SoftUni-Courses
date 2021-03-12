package _04_Interfaces_And_Abstraction_EXERCISE.P05_Telephony;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable{


    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        this.urls.forEach(e -> output.append(e.matches("^[^0-9]+$") ? String.format("Browsing: %s!", e)
                : "Invalid URL!").append(System.lineSeparator()));
        return output.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        this.numbers.forEach(e -> output.append(e.matches("^[0-9]+$") ? String.format("Calling... %s", e)
                : "Invalid number!").append(System.lineSeparator()));
        return output.toString().trim();
    }
}