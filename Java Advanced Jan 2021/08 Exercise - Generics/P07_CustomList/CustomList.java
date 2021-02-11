package _15_Generics_EXERCISE.P07_CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<E extends Comparable> {
    private List<E> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(E element) {
        this.data.add(element);
    }

    public E remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(E element) {
        return this.data.contains(element);
    }

    public void swap(int indexOne, int indexTwo) {
        E firstEl = this.data.get(indexOne);
        this.data.set(indexOne, this.data.get(indexTwo));
        this.data.set(indexTwo, firstEl);
    }

    public long countGreaterThan(E toCompare) {
        return this.data.stream().filter(e -> e.compareTo(toCompare) > 0).count();
    }

    public E getMax() {

        E maxEl = this.data.get(0);
        for (E datum : this.data) {
            if (datum.compareTo(maxEl) > 0) {
                maxEl = datum;
            }
        }

        return maxEl;
    }

    public E getMin() {
        E minEl = this.data.get(0);
        for (E datum : this.data) {
            if (datum.compareTo(minEl) < 0) {
                minEl = datum;
            }
        }

        return minEl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E value : this.data) {
            sb.append(value.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
