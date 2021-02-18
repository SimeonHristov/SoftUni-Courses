//package guild;
package _18_ExamPreparation.P18_Guild.guild;

//import _18_ExamPreparation.P17_Parking.parking.Car;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    //The class constructor should receive name and capacity, also it should initialize the roster with a new instance of the collection
    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    //•	Method addPlayer(Player player) - adds an entity to the roster if there is room for it
    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    //•	Method removePlayer(String name) - removes a player by given name, if such exists, and returns boolean
    public boolean removePlayer(String name) {
          return roster.removeIf(p ->p.getName().equals(name));
//        for (Player player : roster) {
//            if (player.getName().equals(name)) {
//                roster.remove(name);
//                return true;
//            }
//        }
//        return false;
    }

    //•	Method promotePlayer(String name) - promote (set his rank to "Member")
    // the first player with the given name. If the player is already a "Member", do nothing.
    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                //not to waste time going over the rest of the list after we've found a match
                break;
            }
        }
    }
    //•	Method demotePlayer(String name)- demote (set his rank to "Trial") the first player with the given name.
    // If the player is already a "Trial",  do nothing.
    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                //not to waste time going over the rest of the list after we've found a match
                break;
            }
        }
    }

    //•	Method kickPlayersByClass(String clazz) - removes all the players by the given class
    // and returns all removed players from that class as an array
    public Player[] kickPlayersByClass(String clazz) {
        Player[] players = this.roster.stream().filter(p -> p.getClazz().equals(clazz)).toArray(Player[]::new);
        for (Player player : players) {
            this.roster.removeIf(p ->p.getName().equals(player.getName()));
        }

        return  players;
    }

    //•	Method count() - returns the number of players
    public int count() {
        return this.roster.size();
    }

    //•	Method report() - returns a String in the following format:
    public String report() {
        StringBuilder out = new StringBuilder();
        out.append("Players in the guild: " + this.name).append(":").append(System.lineSeparator());

        for (Player player : roster) {
            out.append(player.toString())
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }
}
