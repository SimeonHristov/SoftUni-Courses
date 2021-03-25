package viceCity.models.players;

import viceCity.models.BasePlayer;

public class CivilPlayer extends BasePlayer implements Player {

    private int lifePoints = 50;

    public CivilPlayer(String name, int lifePoints, int lifePoints1) {
        super(name, lifePoints);
        this.lifePoints = lifePoints1;
    }
}

