package org.oreilly.javaGoodParts.examples.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.oreilly.javaGoodParts.examples.statistics.Player;
import org.oreilly.javaGoodParts.examples.statistics.Team;

/**
 * A fourth implementation of the Team interface, using
 * a HashSet as the backing store for the Players on
 * the team, after the interface has been changed to
 * return a Set from the getPlayers() method. This
 * iteration adds methods that allow getting player records
 * in a random access fashion. One method allows getting
 * a {@link List} of {@link Player} objects
 * for a player from the name, and the other
 * allows getting a {@link Player} object from the player
 * id. To do this, we add two {@link HashMap} objects
 * to the private fields.
 */
public class TeamImpl implements Team {

    private String name;
    private HashSet<Player> players =
            new HashSet<Player>();
    private HashMap<String, List<Player>> byName = new HashMap<String, List<Player>>();
    private HashMap<UUID, Player> byIds = new HashMap<UUID, Player>();

    /**
     * Create a TeamImpl object, with the name
     * supplied
     */
    public TeamImpl(String teamName) {
        name = teamName;
    }

    /**
     * Return a <code>String</code> that is the name of
     * this team
     */
    public String getName() {
        return name;
    }

    /**
     * Return a list of the players that are on this
     * team
     */
    public Set<Player> getRoster() {
        return players;
    }

    /**
     * Add a player to the team
     */
    public void addPlayer(Player toAdd) {
        players.add(toAdd);
        if (byName.containsKey(toAdd.getName())) {
            byName.get(toAdd.getName()).add(toAdd);
        } else {
            LinkedList<Player> newList = new LinkedList<Player>();
            newList.add(toAdd);
            byName.put(toAdd.getName(), newList);
        }
        byIds.put(toAdd.getId(), toAdd);
    }

    /**
     * Remove a player from the team
     */
    public void removePlayer(Player toRemove) {
        players.remove(toRemove);
        byName.get(toRemove.getName()).remove(toRemove);
        if (byName.get(toRemove.getName()).isEmpty()) {
            byName.remove(toRemove.getName());
        }
        byIds.remove(toRemove.getId());
    }

    @Override
    public List<Player> getPlayer(String name) {
        return byName.get(name);
    }

    @Override
    public Player getPlayer(UUID playerId) {
        return byIds.get(playerId);
    }
}
