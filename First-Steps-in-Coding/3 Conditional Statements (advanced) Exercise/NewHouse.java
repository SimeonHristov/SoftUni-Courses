package Exercise03;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String flowers = scanner.nextLine();  //•	Вид цветя - текст с възможности - "Roses", "Dahlias", "Tulips", "Narcissus", "Gladiolus"
        int flowersQuantity = Integer.parseInt(scanner.nextLine());  //input
        int budget = Integer.parseInt(scanner.nextLine()); //input

        double priceRoses = flowersQuantity * 5;
        double priceDahlias = flowersQuantity * 3.80;
        double priceTulips = flowersQuantity * 2.80;
        double priceNarcissus = flowersQuantity * 3;
        double priceGladiolus = flowersQuantity * 2.50;

        double discount = 0;
        double totalPrice = 0;

        if (flowers.equals("Roses")) {
            if  (flowersQuantity > 80) {
                discount = 0.10;
                totalPrice = priceRoses - priceRoses * discount;
                if (budget >= totalPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-totalPrice);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",totalPrice-budget);
                }

            } else {
                if (budget >= priceRoses) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-priceRoses);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",priceRoses-budget);
                }
            }
        } else if (flowers.equals("Dahlias")) {
                if  (flowersQuantity > 90) {
                    discount = 0.15;
                    totalPrice = priceDahlias - priceDahlias * discount;
                    if (budget >= totalPrice) {
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-totalPrice);
                    } else {
                        System.out.printf("Not enough money, you need %.2f leva more.",totalPrice-budget);
                    }

                } else {
                    if (budget >= priceDahlias) {
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-priceDahlias);
                    } else {
                        System.out.printf("Not enough money, you need %.2f leva more.",priceDahlias-budget);
                    }
                }
        } else if (flowers.equals("Tulips")) {
            if  (flowersQuantity > 80) {
                discount = 0.15;
                totalPrice = priceTulips - priceTulips * discount;
                if (budget >= totalPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-totalPrice);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",totalPrice-budget);
                }

            } else {
                if (budget >= priceTulips) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-priceTulips);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",priceTulips-budget);
                }
            }
        } else if (flowers.equals("Narcissus")) {
            if  (flowersQuantity < 120) {
                discount = 0.15;
                totalPrice = priceNarcissus + priceNarcissus * discount;
                if (budget >= totalPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-totalPrice);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",totalPrice-budget);
                }

            } else {
                if (budget >= priceNarcissus) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-priceNarcissus);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",priceNarcissus-budget);
                }
            }
        } else if (flowers.equals("Gladiolus")) {
            if  (flowersQuantity < 80) {
                discount = 0.20;
                totalPrice = priceGladiolus + priceGladiolus * discount;
                if (budget >= totalPrice) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-totalPrice);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",totalPrice-budget);
                }

            } else {
                if (budget >= priceGladiolus) {
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-priceGladiolus);
                } else {
                    System.out.printf("Not enough money, you need %.2f leva more.",priceGladiolus-budget);
                }
            }
        }

//        if (flowersQuantity > 80 && flowers.equals("Roses")) {
//            discount = (flowersQuantity * 5) * 0.10;
//            totalPrice = flowersQuantity * 5 - discount;
//            if (budget >= totalPrice) {
//                System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-totalPrice);
//            } else {
//                System.out.printf("Not enough money, you need %.2f leva more.",totalPrice-budget);
//            }
//        } else if (flowersQuantity > 90 && flowers.equals("Dahlias")) {
//            discount = (flowersQuantity * 3.80) * 0.15;
//            totalPrice = (flowersQuantity * 3.80) - discount;
//            if (budget >= totalPrice) {
//                System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-totalPrice);
//            } else {
//                System.out.printf("Not enough money, you need %.2f leva more.",totalPrice-budget);
//            }
//        } else if (flowersQuantity > 80 && flowers.equals("Tulips")) {
//            discount = (flowersQuantity * 2.80) * 0.15;
//            totalPrice = (flowersQuantity * 2.80) - discount;
//            if (budget >= totalPrice) {
//                System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-totalPrice);
//            } else {
//                System.out.printf("Not enough money, you need %.2f leva more.",totalPrice-budget);
//            }
//        } else if (flowersQuantity > 120 && flowers.equals("Narcissus")) {
//            discount = (flowersQuantity * 3) * 0.10;
//            totalPrice = (flowersQuantity * 3) + discount;
//            if (budget >= totalPrice) {
//                System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-totalPrice);
//            } else {
//                System.out.printf("Not enough money, you need %.2f leva more.",totalPrice-budget);
//            }
//        } else if (flowersQuantity > 80 && flowers.equals("Gladiolus")) {
//            discount = (flowersQuantity * 2.50) * 0.10;
//            totalPrice = (flowersQuantity * 2.50) + discount;
//            if (budget >= totalPrice) {
//                System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-totalPrice);
//            } else {
//                System.out.printf("Not enough money, you need %.2f leva more.",totalPrice-budget);
//            }
//        }
//
//        switch (flowers) {
//            case "Roses":
//                totalPrice = flowersQuantity * 5;
//                break;
//            case "Dahlias":
//                totalPrice = flowersQuantity * 3.80;
//                break;
//            case "Tulips":
//                totalPrice = flowersQuantity * 2.80;
//                break;
//            case "Narcissus":
//                totalPrice = flowersQuantity * 3;
//                break;
//            case "Gladiolus":
//                totalPrice = flowersQuantity * 2.5;
//                break;
//        }
//
////        if (budget >= totalPrice) {
////            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",flowersQuantity,flowers,budget-totalPrice);
////        } else {
////            System.out.printf("Not enough money, you need %.2f leva more.",totalPrice-budget);
//        }

//        Съществуват следните отстъпки:
//    •	Ако Нели купи повече от 80 Рози - 10% отстъпка от крайната цена
//    •	Ако Нели купи повече от 90  Далии - 15% отстъпка от крайната цена
//    •	Ако Нели купи повече от 80 Лалета - 15% отстъпка от крайната цена
//    •	Ако Нели купи по-малко от 120 Нарциса - цената се оскъпява с 15%
//    •	Ако Нели Купи по-малко от 80 Гладиоли - цената се оскъпява с 20%






//        Да се отпечата на конзолата на един ред:
//          •	Ако бюджета им е достатъчен - "Hey, you have a great garden with {броя цвета} {вид цветя} and {останалата сума} leva left."
//          •	Ако бюджета им е НЕ достатъчен - "Not enough money, you need {нужната сума} leva more."
//        Сумата да бъде форматирана до втория знак след десетичната запетая.






    }
}
