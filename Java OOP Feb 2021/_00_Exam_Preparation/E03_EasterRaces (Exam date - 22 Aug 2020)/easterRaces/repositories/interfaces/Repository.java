package easterRaces.repositories.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Repository<T> {

    T getByName(String name);

    Collection<T> getAll();

    void add(T model);

    boolean remove(T model);
}
