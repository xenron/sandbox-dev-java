package org.oreilly.javaGoodParts.examples.impl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.oreilly.javaGoodParts.examples.statistics.Batter;
import org.oreilly.javaGoodParts.examples.statistics.BoxScore;
import org.oreilly.javaGoodParts.examples.statistics.Player;
import org.oreilly.javaGoodParts.examples.statistics.StatRecorder;
import org.oreilly.javaGoodParts.examples.statistics.Team;

/**
 * An implementation of the StatRecorder interface. This will
 * create a server that is exported using the default RMI registry
 * (which will need to be started by some other means) on the
 * standard port (1099). The server will name itself Recorder,
 * and can be found by clients if they know the machine on which
 * the server is running.
 */
public class StatRecorderImpl implements StatRecorder {

    private Hashtable<String, Team> teams = new Hashtable<String, Team>();
    private Registry registry;
    private StatRecorder myStub;

    StatRecorderImpl(List<Team> initTeams) {
        for (Team t : initTeams) {
            teams.put(t.getName(), t);
        }
        try {
            exportRecorder();
        } catch (RemoteException e) {
            System.out.println("unable to export stat recorder");
        }
    }

    @Override
    public void recordGame(BoxScore stats) throws RemoteException {
        for (String teamName : stats.getTeams()) {
            Team toUpdate = teams.get(teamName);
            processScore(toUpdate, stats);
        }
    }

    @Override
    public Set<Player> getRoster(String forTeam) throws RemoteException {
        return (teams.get(forTeam)).getRoster();
    }

    /**
     *  Export a stub object so that calls can be made from
     * another address space thorugh that object. This is done
     * by putting the stub in a {@link Registry}, which itself
     * is a remote object that others can use to find the stub
     * that in turn is used to call the remote objects of this
     * implementation
     * @throws RemoteException
     */
    private void exportRecorder() throws RemoteException {
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        registry = LocateRegistry.getRegistry();
        myStub = (StatRecorder) UnicastRemoteObject.exportObject(this, 5550);
        registry.rebind("Recorder", myStub);
    }

    /**
     * Process the box score for a particular team. This
     * implementation will go through the players (by their
     * id), and call {@link upDatePlayer} for each player
     * that was in the game
     * @param forTeam the team whose players are being
     * updated
     * @param game the {@link BoxScore} object that
     * contains the record of the game
     */
    private void processScore(Team forTeam, BoxScore game) {
        List<UUID> players = game.getPlayers(forTeam.getName());
        for (UUID id : players) {
            Player toUpdate = forTeam.getPlayer(id);
            updatePlayer(toUpdate, game);
        }
    }

    /**
     * Update the statistics of a particular player, given
     * the boxscore of the game. The actual implementation
     * of this method is an exercise left to the reader...
     * @param toUpdate
     * @param game
     */
    private void updatePlayer(Player toUpdate, BoxScore game) {
        List<Batter.AtBatResult> batting = game.getBatting(toUpdate.getId());
        if (!batting.isEmpty()){
            updateBatting(toUpdate, batting);
        }
        /* Need to add further clauses to update other statistics*/
    }
    /**
     * Update the batting statistics for a player for a particular game.
     * This method assumes that the player is associated with some batting
     * statistics (i.e., that there is a {@link Batter} object associated
     * with the player
     * @param batter Player whose batting statistics are to be updated
     * @param results a list of the batting results for a particular game
     */
    private void updateBatting(Player batter, List<Batter.AtBatResult> results) {
        Batter batStats = batter.asBatter();
        synchronized (batter) {
            for (Batter.AtBatResult r : results) {
                batStats.atBat(r);
            }
        }
    }
}
