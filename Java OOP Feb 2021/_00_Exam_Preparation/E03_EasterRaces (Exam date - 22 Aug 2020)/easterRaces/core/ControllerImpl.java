package easterRaces.core;

import easterRaces.common.ExceptionMessages;
import easterRaces.common.OutputMessages;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;


    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }


    @Override
    public String createDriver(String driver) {
        Driver newDriver = new DriverImpl(driver);

        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driver));
        }
        driverRepository.add(newDriver);

        return String.format(OutputMessages.DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        if (this.carRepository.getByName(model)!=null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, model));
        }
        switch (type){
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model,horsePower);
                break;
        }
        carRepository.add(car);
        return String.format(OutputMessages.CAR_CREATED, car.getClass().getSimpleName(), model );
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver;
        if (this.driverRepository.getByName(driverName) == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND,driverName));
        }

        if (this.carRepository.getByName(carModel) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND,carModel));
        }
        Car car = this.carRepository.getByName(carModel);
        driver = this.driverRepository.getByName(driverName);
        driver.addCar(car);

        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Driver driver;
        Race race;

        if (this.raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        }

        if (this.driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND,driverName));
        }

        driver = this.driverRepository.getByName(driverName);
        race = this.raceRepository.getByName(raceName);
        race.addDriver(driver);

        return String.format(OutputMessages.DRIVER_ADDED, driverName,raceName);
    }

    @Override
    public String startRace(String raceName) {

        if (this.raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        }

        if (this.raceRepository.getByName(raceName).getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID,raceName,3));
        }

        Race race = this.raceRepository.getByName(raceName);
        List<Driver> listOfWinners = race.getDrivers().stream()
                .sorted((f,s)-> Double.compare(s.getCar().calculateRacePoints(race.getLaps()),
                        f.getCar().calculateRacePoints(race.getLaps()))).
                        limit(3).collect(Collectors.toList());

        this.raceRepository.remove(race);

        StringBuilder sb = new StringBuilder(String.format(OutputMessages.DRIVER_FIRST_POSITION, listOfWinners.get(0).getName(), race.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(OutputMessages.DRIVER_SECOND_POSITION, listOfWinners.get(1).getName(), race.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(OutputMessages.DRIVER_THIRD_POSITION, listOfWinners.get(2).getName(), race.getName()));

        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
      Race race;
      if (this.raceRepository.getByName(name) != null) {
          throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS,name));
      }

      race = new RaceImpl(name, laps);

      this.raceRepository.add(race);

      return String.format(OutputMessages.RACE_CREATED,name);
    }
}
