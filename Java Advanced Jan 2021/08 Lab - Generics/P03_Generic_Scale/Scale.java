package _14_Generics_LAB.P03_Generic_Scale;

public class Scale<T extends Comparable> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (this.left.compareTo(this.right) > 0) {
            return this.left;
        } else if (this.left.compareTo(this.right) < 0) {
            return this.right;
        } else {
            return null;
        }
    }
}