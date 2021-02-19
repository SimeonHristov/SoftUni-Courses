//package healthyHeaven;
package _18_ExamPreparation.P21_HealthyHeaven.healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {

    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        int sum = 0;
        for (Vegetable veggie : products) {
            sum += veggie.getCalories();
        }
        return sum;
    }

    //•	Method getProductCount() - returns the number of products
    public int getProductCount() {
        return products.size();
    }

    //•	Method add(Vegetable product) – adds an entity to the products
    public void add(Vegetable product) {
        products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(String.format(" * Salad %s is %d calories and have %d products:"
                , this.name, this.getTotalCalories(), this.getProductCount())).append(System.lineSeparator());
        for (Vegetable v : products) {
            out.append(v.toString()).append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}
