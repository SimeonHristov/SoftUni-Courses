//package rabbits;
package _18_ExamPreparation.P20_Rabbits.rabbits;


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

    //•	add(Rabbit rabbit) method - adds an entity to the data if there is room for it
    public void add(Rabbit rabbit) {
        if (this.capacity > this.data.size()) {
            this.data.add(rabbit);
        }
    }


    //•	removeRabbit(String name) method - removes a rabbit by given name, if such exists, and returns boolean
    public boolean removeRabbit(String name) {
       return this.data.removeIf(r -> r.getName().equals(name));
    }

    //•	removeSpecies(String species) method - removes all rabbits by given species
    public boolean removeSpecies(String species) {
       return this.data.removeIf(r -> r.getSpecies().equals(species));
    }

    //•	sellRabbit(String name) method - sell (set its available property to false without removing it from the collection)
    // the first rabbit with the given name, also return the rabbit
    public Rabbit sellRabbit(String name) {
        Rabbit rab = null;
        for (Rabbit r : data) {
            if (r.getName().equals(name)) {
                r.setAvailable(false);
                rab = r;
            }
        }
        return rab;


    }

    //•	sellRabbitBySpecies(String species) method - sells and returns all rabbits from that species as a List
    public List<Rabbit> sellRabbitBySpecies(String species) {
        this.data.stream().filter(e->e.getSpecies().equals(species)).forEach(v->v.setAvailable(false));
        return this.data.stream().filter(e->e.getSpecies().equals(species)).collect(Collectors.toList());
    }


    //•	count() - returns the number of rabbits
    public int count() {
        return this.data.size();
    }

    //•	report() - returns a String in the following format, including only not sold rabbits:
    public String report() {
        StringBuilder out = new StringBuilder();
        out.append("Rabbits available at " + this.name).append(":").append(System.lineSeparator());
        for (Rabbit r : data) {
            if (r.isAvailable()) {
                out.append("Rabbit " + "("+ r.getSpecies()+")" + ": " + r.getName()).append(System.lineSeparator());
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

