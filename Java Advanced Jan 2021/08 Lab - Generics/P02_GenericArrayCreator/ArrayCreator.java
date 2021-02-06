package _14_Generics_LAB.P02_GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {
        T[] result = (T[]) Array.newInstance(item.getClass(), length);
        fill(result, item);
        return result;
    }

    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] result = (T[]) Array.newInstance(tClass, length);
        fill(result, item);
        return result;
    }

    private static <T> void fill(T[] array, T item) {
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
    }

    private static <T> T[] fill(T item, int length) {
        List<T> temp = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            temp.add(item);
        }

        return (T[]) temp.toArray();
    }
}
