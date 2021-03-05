package _03_Inheritance.P04_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement () {
       int index = ThreadLocalRandom.current().nextInt(super.size());

        return this.remove(index);
    }

}
