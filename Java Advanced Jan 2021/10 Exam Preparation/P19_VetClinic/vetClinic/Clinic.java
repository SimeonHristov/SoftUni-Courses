//package vetClinic;
package _18_ExamPreparation.P19_VetClinic.vetClinic;

//import _18_ExamPreparation.P17_Parking.parking.Car;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

//•	Field data – List that holds added pets

    //•	Method add(Pet pet) – adds an entity to the data if there is an empty cell for the pet.
    public void add(Pet pet) {
        this.data.add(pet);
    }

    //•	Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        if (data.removeIf(p -> p.getName().equals(name))) {
            return true;
        }
        return false;
    }

    //•	Method getPet(String name, String owner) – returns the pet with the given name and owner or null if no such pet exists.
    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    //•	Method getOldestPet() – returns the oldest Pet.
    public Pet getOldestPet() {
        Pet oldestPet = null;
        for (Pet pet : data) {
            if (oldestPet == null || oldestPet.getAge() < pet.getAge()) {
                oldestPet = pet;
            }
        }

        return oldestPet;
    }


    //•	Getter getCount – returns the number of pets.
    public int getCount() {
        return this.data.size();
    }

    //•	getStatistics() – returns a String in the following format:
    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        out.append("The clinic has the following patients:").append(System.lineSeparator());

        for (Pet pet : data) {
            out.append(pet.getName() + " " + pet.getOwner())
            .append(System.lineSeparator());
        }

        return out.toString().trim();
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Pet> getData() {
        return data;
    }

    public void setData(List<Pet> data) {
        this.data = data;
    }
}
