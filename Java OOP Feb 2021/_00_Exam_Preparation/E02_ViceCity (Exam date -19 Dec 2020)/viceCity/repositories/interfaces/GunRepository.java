package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static viceCity.common.ConstantMessages.GUN_TYPE_INVALID;

public class GunRepository implements Repository {

    private List<Gun> models;

    public GunRepository(List<Gun> models) {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection getModels() {
        return Collections.unmodifiableList(this.models);
    }

    @Override
    public void add(Object model) {
        if (this.models.contains(model)){
            throw new IllegalArgumentException(GUN_TYPE_INVALID);
        }
        this.models.add((Gun) model);
    }

    @Override
    public boolean remove(Object model) {
        return this.models.removeIf(g -> g.getName().equals(model.getClass().getSimpleName()));
    }

    @Override
    public Object find(String name) {
        Gun gun = null;
        for (Gun model : models) {
            if (model.getName().equals(name)){
               gun = model;
               break;
            }
        }
        return gun;
    }
}
