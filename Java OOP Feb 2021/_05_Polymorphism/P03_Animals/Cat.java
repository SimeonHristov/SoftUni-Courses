package _05_Polymorphism.P03_Animals;

public class Cat extends Animal{


    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }


    @Override
    public String explainSelf() {
        return super.explainSelf() + System.lineSeparator() + "MEEOW";
    }
}
