package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public int calculateComfort() {
        return this.getDecorations().stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length()<1) {
            throw new NullPointerException(aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() >= this.capacity) {
            throw new IllegalStateException(aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.getFish().remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.getFish().forEach(f->f.eat());
    }

    @Override
    public String getInfo() {
        StringBuilder perPrint = new StringBuilder();
        if (this.getFish().isEmpty()) {
            perPrint.append("none");
        } else {
            perPrint.append("Fish: ");
            List<String> collect = this.getFish().stream().map(Fish::getName).collect(Collectors.toList());
            perPrint.append(String.join(" ", collect));

            perPrint
                    .append(System.lineSeparator())
                    .append("Decorations: ").append(this.getDecorations().size())
                    .append(System.lineSeparator())
                    .append("Comfort: ")
                    .append(this.calculateComfort());
        }
        return perPrint.toString();
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("%s (%s):",this.getClass().getSimpleName()))
//                .append(System.lineSeparator())
//                .append(String.format("Fish: %s", this.fish.isEmpty() ? "none" : printFish()))
//                .append(System.lineSeparator())
//                .append(String.format("Decorations: %d",this.decorations.size()))
//                .append(System.lineSeparator())
//                .append(String.format("Comfort: %d", this.calculateComfort()));
//
//        return sb.toString().trim();
    }

    protected String printFish(){
        StringBuilder sb = new StringBuilder();
        //this.fish.forEach(f->sb.append(f.getName()).append(" "));
        for (Fish fish1 : fish) {
                sb.append(fish1.getName())
                        .append(System.lineSeparator());
        }
        return sb.toString().trim();
    };

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
