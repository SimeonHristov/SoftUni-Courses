package rpg_tests;


import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;


public class DummyTests {
    public static int XP = 10;
    public static int DUMMY_HP = 10;
    public static int ATTACK_POINTS = 1;

    Dummy dummy;
    Dummy deadDummy;

    @Before
    public void createObjects(){
        this.dummy = new Dummy(DUMMY_HP, XP);
        this.deadDummy = new Dummy(0, XP);
    }

    @Test
    public void loseHealthWhenAttacked(){
        int actual = dummy.getHealth();

        dummy.takeAttack(ATTACK_POINTS);

        assertEquals(DUMMY_HP - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowWhenDeadAttacked(){
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void shouldGiveXPWhenDead(){
        assertEquals(XP, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowWhenGiveXpAlive(){
        dummy.giveExperience();
    }
}
