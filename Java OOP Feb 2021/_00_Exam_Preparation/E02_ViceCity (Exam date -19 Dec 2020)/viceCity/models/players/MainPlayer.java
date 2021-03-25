package viceCity.models.players;

import viceCity.models.BasePlayer;

public class MainPlayer extends BasePlayer implements Player {
    private String name = "Tommy Vercetti";
    private int lifePoints = 100;


    private MainPlayer() {
        this.name = name;
        this.lifePoints = lifePoints;
    }
}
