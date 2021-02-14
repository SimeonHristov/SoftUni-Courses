package _18_ExamPreparation.P06_Scheduling;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(e -> tasks.push(e));

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));



        int taskToKill = Integer.parseInt(scanner.nextLine());
        int killThread = 0;
        int killTask = 0;
        boolean isKilled = false;

        while (!isKilled){
            int currentTask = tasks.peek();
            int currentThread = threads.peek();

            if (currentThread >= currentTask) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }

            if (currentTask == taskToKill) {
                isKilled = true;
                killThread = currentThread;
                killTask = currentTask;
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", killThread,killTask);

        System.out.println(killThread +" " + threads.stream().map(String::valueOf)
                .collect(Collectors.joining(" ")));

//        for (Integer thread : threads) {
//            System.out.println(killThread + " " + thread);
//        }
//        if (threads.isEmpty()){
//            System.out.println(killThread);
//        }
    }
}
