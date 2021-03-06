
package org.orielly.javaGoodParts.examples.statistics;

import java.util.List;
/**
 * The <code>Team</code> interface, which defines
 * the notion of a team for our statistics package. A
 * team is, at first incarnation, simply a collection of
 * players. All teams have a name. 
 */
public interface Team {
    /**
     * Return a <code>String</code> that is the name of
     * this team
     */
    public String getName();
    /**
     * Return a list of the players that are on this
     * team
     */
    public List<? extends Player> getPlayerList();
    /**
     * Add a player to the team
     */
    public void addPlayer(Player toAdd);
    /**
     * Remove a player from the team
     */
    public void removePlayer(Player toRemove);
}
