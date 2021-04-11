package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import javax.naming.spi.DirObjectFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


public class ControllerImpl implements Controller {

    private DecorationRepository decorations;
    //private Map<String, Aquarium> aquariums;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        //this.aquariums = new LinkedHashMap<>();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
//        Aquarium aquarium;
//        switch (aquariumType) {
//            case "FreshwaterAquarium":
//                aquarium = new FreshwaterAquarium(aquariumName);
//                this.aquariums.add(aquarium);
//                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
//            case "SaltwaterAquarium":
//                aquarium = new SaltwaterAquarium(aquariumName);
//                this.aquariums.add(aquarium);
//                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
//            default:
//                throw new IllegalArgumentException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
//        }

        Aquarium aquarium;
        if ("FreshwaterAquarium".equals(aquariumType)) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if ("SaltwaterAquarium".equals(aquariumType)){
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }

        this.aquariums.add(aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        if ("Ornament".equals(type)) {
            decoration = new Ornament();
        } else  if ("Plant".equals(type)) {
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }

        this.decorations.add(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE,type);

    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }

        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        //aquarium.getDecorations().add(decoration);
        aquarium.addDecoration(decoration);
        this.decorations.remove(decoration);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);

//        if ("FreshwaterFish".equals())

        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                if (aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")) {
                    aquarium.addFish(fish);
                    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
                } else {
                    return String.format(ConstantMessages.WATER_NOT_SUITABLE);
                }

            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                if (aquarium.getClass().getSimpleName().equals("SaltwaterAquarium")) {
                    aquarium.addFish(fish);
                    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
                } else {
                    return String.format(ConstantMessages.WATER_NOT_SUITABLE);
                }

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        ;
        aquarium.getFish().stream().forEach(f -> f.eat());
        return String.format(ConstantMessages.FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        ;
        double fishSum = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decSum = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, fishSum + decSum);
    }

    @Override
    public String report() {
        StringBuilder reportPerPrint = new StringBuilder();

        for (Aquarium aquarium : aquariums) {
            reportPerPrint
                    .append(aquarium.getInfo()).append(System.lineSeparator());
        }
        return reportPerPrint.toString().trim();
    }
}
