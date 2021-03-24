package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Hero;

public class DummyTests {

    @Test
    public void DummyLosesHealthWhenAttacked () {
        Axe axe = new Axe(10,10);
        Dummy dummy = new Dummy(20,10);
        //Act
        axe.attack(dummy);
        //Assert
        Assert.assertEquals(10,dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void DeadDummyThrowsException () {
        Axe axe = new Axe(10,1);
        Dummy dummy = new Dummy(20,10);

        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void DeadDummyGivesXP () {
        //Axe axe = new Axe(10,1);
        Dummy dummy = new Dummy(5,10);
        Hero hero = new Hero("Gogo");

        hero.attack(dummy);

        Assert.assertEquals(10, hero.getExperience());
    }

    @Test
    public void LiveDummyDoesntGiveXP () {
        Dummy dummy = new Dummy(15,10);
        Hero hero = new Hero("Gogo");

        hero.attack(dummy);

        Assert.assertEquals(0,hero.getExperience());
    }
}
