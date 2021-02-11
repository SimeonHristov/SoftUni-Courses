package _15_Generics_EXERCISE.P06_GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends   Comparable>  {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void addValue (T value) {
        this.values.add(value);
    }

    public void swap (int indexOne, int indexTwo){
        T firstEl = this.values.get(indexOne);
        this.values.set(indexOne, this.values.get(indexTwo));
        this.values.set(indexTwo, firstEl);
    }


    public long countGreaterElements (T toCompare){
        return this.values.stream().filter(e -> e.compareTo(toCompare) >0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : this.values) {
            sb.append(String.format("%s: %s", value.getClass().getName(), value.toString()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

