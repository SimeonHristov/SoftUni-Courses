package _18_ExamPreparation.P07_FlowerWreaths;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //stack
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(", ")).mapToInt(Integer::parseInt).forEach(liliesStack::push);

        //que
        ArrayDeque<Integer> rosesQue = Arrays.stream(scanner.nextLine()
                .split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        //one wreath = 15 flowers : NEED 5 WREATHS
        int leftOvers = 0;
        int wreaths = 0;

        while (!liliesStack.isEmpty() && !rosesQue.isEmpty()) {
            int lilies = liliesStack.peek();
            int roses = rosesQue.peek();
            int sum = lilies + roses;

            if (sum == 15) {
                wreaths++;
                liliesStack.pop();
                rosesQue.poll();
            } else if (sum < 15) {
                leftOvers += sum;
                liliesStack.pop();
                rosesQue.poll();
            } else {
                while (sum > 15) {
                    lilies -= 2;
                    sum = lilies + roses;
                    if (sum == 15) {
                        wreaths++;
                        liliesStack.pop();
                        rosesQue.poll();
                        break;
                    } else if (sum < 15){
                        leftOvers+=sum;
                        liliesStack.pop();
                        rosesQue.poll();
                        break;
                    } else {
                       continue;
                    }
                }
            }
        }

        int additionalWreaths = leftOvers / 15;
        wreaths += additionalWreaths;

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }

    }
}

