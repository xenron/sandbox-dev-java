
package org.oreilly.javaGoodParts.examples.impl;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.oreilly.javaGoodParts.examples.statistics.Batter.AtBatResult;
import org.oreilly.javaGoodParts.examples.statistics.BoxScore;
import org.oreilly.javaGoodParts.examples.statistics.DidNotPlayException;
import org.oreilly.javaGoodParts.examples.statistics.Fielder.AttemptResult;
import org.oreilly.javaGoodParts.examples.statistics.Player.Position;

/**
 * An implementation of the {@link BoxScore} interface, ignoring
 * all of the little details like how the data that populates the private
 * fields is actually placed into the object.
 */
public class BoxScoreImpl implements BoxScore, Serializable {
    static private long serialVersionUID = 1;

    private LinkedList<String> teams
            = new LinkedList<String>();
    private Hashtable<String, List<UUID>> whoPlayed
            = new Hashtable<String, List<UUID>>();
    private Hashtable<UUID, Position> positions
            = new Hashtable<UUID, Position>();
    private Hashtable<UUID, List<AtBatResult>> atBats
            = new Hashtable<UUID, List<AtBatResult>>();
    private Hashtable<UUID, List<AttemptResult>> fielding
            = new Hashtable<UUID, List<AttemptResult>>();
    private Hashtable<UUID, Integer> passedBalls
            = new Hashtable<UUID, Integer>();

    public BoxScoreImpl(String team1, String team2){
        teams.add(team1);
        teams.add(team2);
    }
    @Override
    public List<String> getTeams() {
        return(teams);
    }

    @Override
    public List<UUID> getPlayers(String forTeam) {
        return(whoPlayed.get(forTeam));
    }

    @Override
    public Position getPosition(UUID forPlayer) throws DidNotPlayException {
        if (positions.contains(forPlayer))
            return positions.get(forPlayer);
        else
            throw new DidNotPlayException();
    }

    @Override
    public List<AtBatResult> getBatting(UUID playerID) {
        return atBats.get(playerID);
    }

    @Override
    public List<AttemptResult> getFielding(UUID forPlayer) {
        return fielding.get(forPlayer);
    }

    @Override
    public int getPassedBalls(UUID forPlayer) {
        return passedBalls.get(forPlayer).intValue();
    }

}
