//package com.company.MidExamREAL07112020;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//
//public class WarshipsTony {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//       String [] sectionsPirate  =scanner.nextLine().split("\\>");
//       String [] sectionsWar  =scanner.nextLine().split("\\>");
//
//        int health = Integer.parseInt(scanner.nextLine());
//        String[] commands = scanner.nextLine().split().ToArray();
//        Boolean lost = false;
//        Boolean win = false;
//        int pirateShipSum = 0;
//        int warshipSum = 0;
//
//        while (!commands[0].equals("Retire"))
//        {
//            if (commands[0].equals("Status"))
//            {
//                double repairNeeded = health * 0.2;
//                int count = 0;
//
//                for (int i = 0; i < sectionsPirate.length; i++)
//                {
//                    double sectionsPirateToDouble = 1.0* Double.parseDouble(sectionsPirate[i]);
//                    if (Double.compare(sectionsPirateToDouble,repairNeeded))
//                    {
//                        count++;
//                    }
//                }
//
//                Console.WriteLine($"{count} sections need repair.");
//            }
//
//            if (commands[0] == "Repair")
//            {
//                int index = int.Parse(commands[1]);
//                int healthSection = int.Parse(commands[2]);
//
//                if (index >= 0 && index < sectionsPirate.Length)
//                {
//                    sectionsPirate[index] += healthSection;
//
//                    if (sectionsPirate[index] > health)
//                    {
//                        sectionsPirate[index] = health;
//                    }
//                }
//
//            }
//
//            if (commands[0] == "Fire")
//            {
//                int index = int.Parse(commands[1]);
//                int damage = int.Parse(commands[2]);
//
//                if (index >= 0 && index < sectionsWar.Length)
//                {
//                    sectionsWar[index] -= damage;
//
//                    if (sectionsWar[index] <= 0)
//                    {
//                        Console.WriteLine("You won! The enemy ship has sunken.");
//                        win = true;
//                        break;
//                    }
//                }
//            }
//
//            if (commands[0] == "Defend")
//            {
//                int startIndex = int.Parse(commands[1]);
//                int endIndex = int.Parse(commands[1]);
//                int damage = int.Parse(commands[3]);
//
//                if (startIndex >= 0 && startIndex < sectionsPirate.Length)
//                {
//                    if (endIndex >= 0 && endIndex < sectionsPirate.Length)
//                    {
//                        for (int i = startIndex; i <= endIndex; i++)
//                        {
//                            sectionsPirate[i] -= damage;
//
//                            if (sectionsPirate[i] <= 0)
//                            {
//                                Console.WriteLine("You lost! The pirate ship has sunken.");
//                                lost = true;
//                                break;
//                            }
//                        }
//                    }
//                }
//                if (lost == true)
//                {
//                    break;
//                }
//            }
//
//            commands = Console.ReadLine().Split().ToArray();
//        }
//
//        for (int i = 0; i < sectionsPirate.Length; i++)
//        {
//            pirateShipSum += sectionsPirate[i];
//        }
//        for (int i = 0; i < sectionsWar.Length; i++)
//        {
//            warshipSum += sectionsWar[i];
//        }
//
//        if (lost == false && win == false)
//        {
//            Console.WriteLine($"Pirate ship status: {pirateShipSum}");
//            Console.WriteLine($"Warship status: {warshipSum}");
//        }
//
//
//    }
//    }
//}
