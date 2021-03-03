package _02_Encapsulation_EXERCISE.P04_PizzaCalories;

import java.security.InvalidParameterException;
import java.util.LinkedHashMap;

public class Topping {
    private String toppingType;
    private double weight;
    private static LinkedHashMap<String, Double> modifiers;

    static {
        modifiers = new LinkedHashMap<>();
        modifiers.put("MEAT", 1.2);
        modifiers.put("VEGGIES", 0.8);
        modifiers.put("CHEESE", 1.1);
        modifiers.put("SAUCE", 0.9);

    }
    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        if(!modifiers.containsKey(toppingType.toUpperCase())){
            throw new InvalidParameterException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50){
            throw new InvalidParameterException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        return (2 * this.weight) * modifiers.get(this.toppingType.toUpperCase());
    }
}
