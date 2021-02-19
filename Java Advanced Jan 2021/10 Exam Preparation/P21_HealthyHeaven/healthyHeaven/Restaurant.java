//package healthyHeaven;
package _18_ExamPreparation.P21_HealthyHeaven.healthyHeaven;



import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        return this.data.removeIf(s -> s.getName().equals(name));
    }

    public String getHealthiestSalad() {
        Salad healthiest = null;
        for (Salad salad : data) {
           if (healthiest==null || healthiest.getTotalCalories() > salad.getTotalCalories()) {
               healthiest = salad;
           }
        }
        return healthiest.getName();
    }

    public String generateMenu() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("%s have %d salads:",this.name,this.data.size()))
                .append(System.lineSeparator());
        for (Salad salad : data) {
            out.append(salad.toString()).append(System.lineSeparator());
        }

        return out.toString().trim();
    }

}
