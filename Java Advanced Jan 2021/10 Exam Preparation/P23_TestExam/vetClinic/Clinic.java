//package vetClinic;
package _18_ExamPreparation.P23_TestExam.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {

    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()){
            this.data.add(pet);
        }
    }

    public boolean remove (String name){
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner){
        Pet returnPet = null;
        for (Pet pet: data) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
                returnPet = pet;
            }
        }
        return returnPet;
    }

    public Pet getOldestPet (){
        Pet oldestPet = null;
        for (Pet pet: data) {
            if(oldestPet == null || pet.getAge() > oldestPet.getAge()){
                 oldestPet = pet;
            }
        }
        return oldestPet;
    }

    public int getCount (){
        return this.data.size();
    }

    public String getStatistics (){
        StringBuilder out = new StringBuilder();
        out.append("The clinic has the following patients:").append(System.lineSeparator());

        for (Pet p : data) {
            out.append(String.format("%s %s", p.getName(), p.getOwner())).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}

