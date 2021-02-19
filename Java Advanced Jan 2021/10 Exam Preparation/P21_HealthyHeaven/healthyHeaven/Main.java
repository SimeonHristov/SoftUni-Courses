//package healthyHeaven;
package _18_ExamPreparation.P21_HealthyHeaven.healthyHeaven;

public class Main {
    public static void main(String[] args) {
// Initialize the repository
        Restaurant restaurant = new Restaurant("Casa Domingo");

// Initialize the entities
        Vegetable tomato = new Vegetable("Tomato", 20);
        Vegetable cucumber = new Vegetable("Cucumber", 15);

//        Vegetable qwe = new Vegetable("qwe", 222);
//        Vegetable asd = new Vegetable("asd", 1335);
//        Vegetable cxz = new Vegetable("cxz", 4444);

        Salad salad = new Salad("Tomatoes with cucumbers");

       // Salad salad2 = new Salad("qwe with cucumbers");
       // Salad salad3 = new Salad("cxz with cucumbers");

        salad.add(tomato);
        salad.add(cucumber);

//        salad2.add(cxz);
//        salad2.add(asd);
//        salad3.add(qwe);
//        salad3.add(asd);

        System.out.println(salad.getTotalCalories()); // 35
        System.out.println(salad.getProductCount());  // 2

        System.out.println(salad.toString());
// * Salad Tomatoes with cucumbers is 35 calories and have 2 products:
//  - Tomato have 20 calories
//  - Cucumber have 15 calories

        restaurant.add(salad);

//        restaurant.add(salad3);
//        restaurant.add(salad2);

        System.out.println(restaurant.buy("Invalid salad")); // false

// Initialize the second entities
        Vegetable corn = new Vegetable("Corn", 90);
        Salad casaDomingo = new Salad("Casa Domingo");

        casaDomingo.add(tomato);
        casaDomingo.add(cucumber);
        casaDomingo.add(corn);

        restaurant.add(casaDomingo);

        System.out.println(restaurant.getHealthiestSalad()); // Tomatoes with cucumbers

        System.out.println(restaurant.generateMenu());
        System.out.println(restaurant.generateMenu());



    }
}
