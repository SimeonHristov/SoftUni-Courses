package _17_IteratorsAndComparators_EXERCISE.P01_ListyIterator;

import java.util.List;

public class ListyIterator {
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data) {
        this.data = data;
        this.index = index;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < data.size() - 1;
    }

    public void print (){
        validatePrint();
        System.out.println(this.data.get(this.index));
    }

    private void validatePrint() {
        if (this.data.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        }
    }
}