/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.orielly.javaGoodParts.examples.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;
import org.orielly.javaGoodParts.examples.statistics.Batter;
import org.orielly.javaGoodParts.examples.statistics.Player;
import org.orielly.javaGoodParts.examples.statistics.Team;

/**
 * A simple implementation of a {@link Player} object. This implementation
 * is {@link Serializeable}, and can store the data for the object in a file.
 */
public class PlayerImpl implements Player, Serializable {

    private static final long serialVersionUID = 1;
    private UUID id;
    private String name;
    private String filePrefix;
    private Team team;
    private Position pos = Position.Utility;
    private boolean changed = false;
    private BatterImpl battingStats;

    /**
     * Create a new {@code PlayerImpl} object, using the name specified.
     * The player will be created with a new UUID, and all other fields will
     * be in a default state.
     * @param playerName The name of the player being created
     */
    public PlayerImpl(String playerName) {
        name = playerName;
        id = UUID.randomUUID();
    }

    /**
     * Create a {@code Player} object using information stored in the file
     * system.
     * @param playerId the {@link UUID} for this player
     * @param prefix the prefix for the file that stores the players data
     */
    public PlayerImpl(UUID playerId, String prefix) {
        id = playerId;
        filePrefix = prefix;
        /**
         * This is an attempt to see what will happen to a Javadoc
         * comment when it is placed in the middle of a method.
         */
        try {
            ObjectInputStream readIn = new ObjectInputStream(
                    new FileInputStream(prefix + id.toString()));
            PlayerImpl copy = (PlayerImpl) readIn.readObject();
            readIn.close();
            name = copy.name;
            team = copy.team;
            pos = copy.pos;
        } catch (IOException e) {
            System.out.println("unable to open file for player, creating new player object");
            name = "unknown";
        } catch (ClassNotFoundException e) {
            System.out.println("unable to read file for player");
        }
    }

    /**
     * A utility function that writes the player data to the file system.
     */
    protected void writeState() {
        try {
            ObjectOutputStream writeOut =
                    new ObjectOutputStream(
                         new FileOutputStream(filePrefix + id.toString()));
            writeOut.writeObject(this);
            writeOut.close();
            changed = false;
        } catch (Exception e) {
            System.out.println("unable to write object");
        }
    }

    /**
     * A last-gasp check that will, if called, see if the player data needs to
     * be updated in the file system, and if so will write it out. This should
     * never do anything, since the player data should be written out when the
     * data is changed.
     */
    protected void finalize(){
        if (changed){
            writeState();
        }
    }

    /**
     * {@inheritDoc }
     * <p>
     * This implementation will generate a player
     * id by using the standard {@link UUID#randomUUID}
     * generator for UUIDs, which is a cryptographically
     * strong UUID. This should guarantee enough
     * uniqueness for this application
     * @return the UUID that is the player id
     */
    public UUID getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    public Team getTeam() {
        return team;
    }

    /**
     * {@inheritDoc}
     */
    public Position getPosition() {
        return pos;
    }

    /**
     * {@inheritDoc}
     */
    public void setPosition(Position playPosition) {
        if (playPosition != pos) {
            pos = playPosition;
            changed = true;
        }
    }

    /**
     * {@inheritDoc}
     */
    public Batter asBatter(){
        return battingStats;
    }
}
