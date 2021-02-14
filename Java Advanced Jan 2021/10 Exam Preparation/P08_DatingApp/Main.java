package _18_ExamPreparation.P08_DatingApp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).forEach(malesStack::push);

        ArrayDeque<Integer> femaleQue = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;

        while (!malesStack.isEmpty() && !femaleQue.isEmpty()) {
            int currentMale = malesStack.peek();
            int currentFemale = femaleQue.peek();

            if (currentMale <= 0) {
                malesStack.pop();
                continue;
            }

            if (currentFemale <= 0) {
                femaleQue.poll();
                continue;
            }

            if (currentMale % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }

            if (currentFemale % 25 == 0) {
                femaleQue.poll();
                femaleQue.poll();
                continue;
            }

            if (currentMale == currentFemale) {
                matches++;
                malesStack.pop();
                femaleQue.poll();
            } else {
                femaleQue.poll();
                malesStack.pop();
                currentMale -= 2;
                if (currentMale <= 0) {
                    continue;
                } else {
                    malesStack.push(currentMale);
                }
            }
        }

        System.out.println("Matches: " + matches);
        System.out.println("Males left: " + getInfo(malesStack));
        System.out.println("Females left: " + getInfo(femaleQue));


    }

    private static String getInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "none"
                : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
