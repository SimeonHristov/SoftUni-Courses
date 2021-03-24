package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void weaponAttacksLoseDurability() {
        //Arrange
        //Act
        axe.attack(dummy);
        //Assert
        Assert.assertEquals(AXE_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class) // Assert
    public void brokenWeaponCantAttack() {
        Axe axe = new Axe(AXE_ATTACK, AXE_DURABILITY - AXE_DURABILITY);
        this.axe.attack(dummy);

    }
}

