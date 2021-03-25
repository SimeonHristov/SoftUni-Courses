package viceCity.models.guns;

public class Pistol extends BaseGun {

    private static final int BULLETS_BARREL = 10;
    private static final int TOTAL_BULLETS = 10;
    private static final int BULLETS_FIRED = 1;

    public Pistol(String name) {
        super(name, BULLETS_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        return BULLETS_FIRED;
    }
}
