
package org.oreilly.javaGoodParts.examples.statistics;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

/**
 * An interface for a simple server that can be
 * used to record the statistics for a game. The
 * server will take all of the statistics from a complete
 * game and enter them into the system.
 */
public interface StatRecorder extends Remote{
    /**
     * Record the statistics of a game. The statistics
     * are passed in as a {@link BoxScore} object
     * @param stats a {@link BoxScore} containing
     * the batting and fielding statistics for the game
     * @throws RemoteException  if there is
     * a problem with the underlying network or the
     * RMI system
     */
    public void recordGame(BoxScore stats)
            throws RemoteException;

    /**
     * Return a list of the players on a team, where the
     * team is identified by name
     * @param forTeam a {@link String} that is the name
     * of the team whose roster is desired
     * @return a {@link Set} of {@link Player} objects
     * that are the players on this team
     * @throws RemoteException if there is a problem
     * with the underlying network or the RMI system
     */
    public Set<Player> getRoster(String forTeam)
            throws RemoteException;

}
