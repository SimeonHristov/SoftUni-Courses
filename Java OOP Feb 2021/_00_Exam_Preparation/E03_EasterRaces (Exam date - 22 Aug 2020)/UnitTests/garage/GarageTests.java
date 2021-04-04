package garage;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class GarageTests {
    //TODO: Test Garage class
    private Garage garage;

    @Before
    public void setUp() {
        this.garage = new Garage();
        garage.addCar(new Car("audi", 130, 1000.00));
        garage.addCar(new Car("lada", 90, 420.00));
        garage.addCar(new Car("audi", 123, 1111));
        garage.addCar(new Car("honda", 113, 1311));
    }
    //public List<Car> getCars() {
    //        return Collections.unmodifiableList(this.cars);
    //    }
    //

    @Test(expected = UnsupportedOperationException.class)
    public void testGarageUnmodCarList() {
        garage.getCars().add(new Car("qwe", 20, 300));
        assertEquals(5, garage.getCount());
    }

    @Test
    public void testAddingCar() {
        garage.addCar(new Car("dacia", 30, 40));
        assertEquals(5, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCantAddNullCar() {
        Car car = null;
        garage.addCar(car);
    }

    @Test
    public void testGarageSize() {
        assertEquals(4, garage.getCount());
    }

    @Test
    public void testGarageSizeShouldReturnZeroWhenEmpty() {
     Garage garage = new Garage();
     assertEquals(0, garage.getCars().size());
    }

    @Test
    public void testGetCarsWithMaxSpeed() {
//        List<Car> cars = garage.getCars().stream().filter(c -> c.getMaxSpeed() > 131).collect(Collectors.toList());
//        assertEquals(2, cars.size());
        List<Car> expected =  garage.findAllCarsWithMaxSpeedAbove(110);
        assertEquals(3, expected.size());

    }

    @Test
    public void testGetMostExpensiveCar() {
        assertEquals("honda", garage.getTheMostExpensiveCar().getBrand());
//
//       Car car = garage.getCars()
//                .stream()
//                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
//                .limit(1)
//                .findFirst()
//                .orElse(null);
    }

    @Test
    public void testFindAllCarsByBrand() {
        List<Car> expected =  garage.findAllCarsByBrand("audi");
        assertEquals(2, expected.size());


//        List<Car> cars = garage.getCars().stream().filter(c -> c.getBrand().equals("audi")).collect(Collectors.toList());
//        assertEquals(2, cars.size());
    }

}