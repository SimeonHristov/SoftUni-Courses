package _14_Generics_LAB.P04_ListUtilities;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable> T getMax(List<T> collection) {

        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty!");
        }

        T maxElement = collection.get(0);
        for (int i = 1; i < collection.size(); i++) {
            T currentMax = collection.get(i);
            if (maxElement.compareTo(currentMax) < 0) {
                maxElement = currentMax;
            }
        }
        return maxElement;
    }

    public static <T extends Comparable> T getMin(List<T> collection) {

        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty!");
        }

        T minElement = collection.get(0);
        for (int i = 1; i < collection.size(); i++) {
            T currentMin = collection.get(i);
            if (minElement.compareTo(currentMin) > 0) {
                minElement = currentMin;
            }
        }
        return minElement;
    }
}