package blueOrigin;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    private Spaceship spaceship;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("test", 5);
    }

    @Test
    public void testSpaceshipConstructor() {

        String name = "Qwe";
        int size = 3;

        Spaceship expectedSpaceship = new Spaceship(name, size);

        assertEquals(name, expectedSpaceship.getName());
        assertEquals(size, expectedSpaceship.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNullNameThrowsException() {
        new Spaceship(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testSetEmptyNameThrowsException() {
        new Spaceship("", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailWhenNegativeCapacity() {
        new Spaceship("qwe", -3);
    }

    @Test
    public void testGetCapacity() {
        assertEquals(5, spaceship.getCapacity());
    }

    @Test
    public void testAddingAstronauts() {
        Astronaut a1 = new Astronaut("a1", 10);
        Astronaut a2 = new Astronaut("a2", 10);
        spaceship.add(a1);
        spaceship.add(a2);
        assertEquals(2, spaceship.getCount());

    }

    @Test (expected = IllegalArgumentException.class)
    public void testCantAddAstronautsWhenCapacityREached () {
        Spaceship spaceship = new Spaceship("test", 1);
        Astronaut a1 = new Astronaut("a1", 10);
        Astronaut a2 = new Astronaut("a2", 10);
        spaceship.add(a1);
        spaceship.add(a2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCantAddExistingAstronaut () {
        Astronaut a1 = new Astronaut("a1", 10);

        spaceship.add(a1);
        spaceship.add(a1);
    }

    @Test
    public void testRemoveAstronaut () {
        Astronaut a1 = new Astronaut("a1", 10);
        Astronaut a2 = new Astronaut("a2", 10);
        spaceship.add(a1);
        spaceship.add(a2);
        //spaceship.remove("a2");
        assertTrue(spaceship.remove("a2"));
        //assertEquals(a2.getName(), spaceship.remove(a2.getName()));
    }
}
