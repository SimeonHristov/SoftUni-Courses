package com.company.Exercise06ObjectClasses;

import com.company.Exercise01.PrintAndSum;
import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage01 {
    public static class Message {
        String[] phrases = new String[]{"Excellent product.", "Such a great product."
                , "I always use that product.", "Best product of its category."
                , "Exceptional product.", "I can’t live without this product."};

        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product."
                , "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome."
                , "Try it yourself, I am very satisfied.", "I feel great!"};

        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random random = new Random();

        public String randomMessage() {
            return String.format("%s %s %s - %s", phrases[random.nextInt(phrases.length)]
                    , events[random.nextInt(events.length)]
                    , authors[random.nextInt(authors.length)]
                    , cities[random.nextInt(cities.length)]
            );

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Message message = new Message();

        for (int i = 0; i < n; i++) {
            System.out.println(message.randomMessage());
        }

    }

}
