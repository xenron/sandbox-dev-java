package org.oreilly.javaGoodParts.examples.impl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Set;
import org.oreilly.javaGoodParts.examples.statistics.BoxScore;
import org.oreilly.javaGoodParts.examples.statistics.Player;
import org.oreilly.javaGoodParts.examples.statistics.StatRecorder;

/**
 * A component to a client that can be used to report
 * the results of games to a {@link StatRecorder}. This
 * class will get the roster for a team from a given server,
 * and send a {@link BoxScore} to that server.
 */
public class StatReporterImpl {

    /**
     * Get a team roster from a {@link StatRecorder} running
     * on the indicated host. If no server is running on
     * the host, or if the host cannot be contacted, the
     * method will return null.
     * @param fromHost name of the host on which the
     * server is running
     * @param Team the {@link Team} whose roster
     * is desired
     * @return a set of {@link Player} objects that
     * make up the roster of the team, or {@code null}
     * if there is a problem contacting the server
     */
    public Set<Player> getPlayers(String fromHost, String Team) {
        try {
            StatRecorder recorder = getRecorder(fromHost);
            if (recorder != null) {
                return recorder.getRoster(Team);
            } else {
                return null;
            }
        } catch (RemoteException e) {
            System.out.println("Unable to find roster for team " + Team);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Send the results of a game to a {@link StatRecorder}
     * running on the indicated host. If there is a problem
     * contacting the host, print an error message on the
     * console
     * @param toHost name of the host on which the server
     * is running
     * @param score the {@link BoxScore} for the game
     * being reported
     */
    public void reportGame(String toHost, BoxScore score) {
        try {
            StatRecorder recorder = getRecorder(toHost);
            if (recorder != null) {
                recorder.recordGame(score);
            }
        } catch (Exception e) {
            System.out.println("Unable to report game");
            e.printStackTrace();
        }
    }

    /**
     * A private method that does the work of getting
     * a {@link Remote} reference to the {@link StatRecorder}.
     * If there is a problem with the communication, or if
     * no server is running, a {@code null} will be returned.
     * @param fromHost name of the host on which the
     * {@link StatRecorder} is running
     * @return a remote reference to the {@link StatRecorder},
     * or {@code null} if there is no such server or if it cannot
     * be contacted.
     */
    private StatRecorder getRecorder(String fromHost) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry useRegistry = LocateRegistry.getRegistry(fromHost);
            return ((StatRecorder) useRegistry.lookup("Recorder"));
        } catch (Exception e) {
            System.out.println("Unable to find StatRecorder");
            e.printStackTrace();
            return null;
        }
    }
}
