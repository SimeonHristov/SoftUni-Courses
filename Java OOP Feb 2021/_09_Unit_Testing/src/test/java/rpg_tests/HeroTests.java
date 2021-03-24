package rpg_tests;

import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTests {

    @Test
    public void testHeroGainXPbyKillingTargets(){

        Weapon fakeWeapon = Mockito.mock(Weapon.class);
        Target fakeTarget = Mockito.mock(Target.class);

        Hero hero = new Hero("Test Hero", fakeWeapon);

        when(fakeTarget.isDead()).thenReturn(true);
        when(fakeTarget.giveExperience()).thenReturn(10);

        hero.attack(fakeTarget);

        assertEquals(10,hero.getExperience());

    }

}
