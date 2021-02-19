//package rabbits;
package _18_ExamPreparation.P22_TestExam.rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;


    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add (Rabbit rabbit) {
        if (this.capacity > this.data.size()){
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit (String name) {
        return this.data.removeIf(r -> r.getName().equals(name));
    }

    public boolean removeSpecies (String species) {
        return this.data.removeIf(r -> r.getSpecies().equals(species));
    }

    public Rabbit sellRabbit (String name) {
        for (Rabbit r : data) {
            if (r.getName().equals(name)) {
                r.setAvailable(false);
                return r;
            }
        }
        return null;
//        Rabbit rab = null;
//        for (Rabbit r : data) {
//            if (r.getName().equals(name)) {
//                r.setAvailable(false);
//                rab = r;
//            }
//        }
//        return rab;
    }

    public List<Rabbit> sellRabbitBySpecies (String species){
        this.data.stream().filter(e->e.getSpecies().equals(species)).forEach(v->v.setAvailable(false));
        return this.data.stream().filter(e->e.getSpecies().equals(species)).collect(Collectors.toList());
    }

    public int count(){
        return this.data.size();
    }

    public String report () {
        StringBuilder out = new StringBuilder();
        out.append("Rabbits available at " + this.name + ":").append(System.lineSeparator());

        for (Rabbit r : data) {
            if (r.isAvailable()) {
                out.append(r.toString()).append(System.lineSeparator());
            }
        }

        return out.toString().trim();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }


}
