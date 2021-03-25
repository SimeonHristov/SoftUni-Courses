package viceCity.models.guns;

public class Rifle extends BaseGun{
    private static final int BULLETS_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int BULLETS_FIRED = 5;

    public Rifle(String name) {
        super(name, BULLETS_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        return BULLETS_FIRED;
    }
}
