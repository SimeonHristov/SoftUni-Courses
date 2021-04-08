package easterRaces.entities.racers;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RaceImpl implements Race {

    private String name;
    private int laps;
    private List<Driver> driverList;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        this.driverList = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.driverList;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw  new IllegalArgumentException(ExceptionMessages.DRIVER_INVALID);
        }

        //driver.getCar() == null
        if (driver.getCar() == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_PARTICIPATE,driver.getName()));
        }

        if (this.driverList.contains(driver)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_ALREADY_ADDED,driver.getName(),this.name));
        }

        this.driverList.add(driver);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() < 5) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name));
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps < 1){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, 1));
        }
        this.laps = laps;
    }
}
