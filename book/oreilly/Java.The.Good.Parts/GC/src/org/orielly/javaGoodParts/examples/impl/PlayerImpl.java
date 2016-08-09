
package org.orielly.javaGoodParts.examples.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;
import org.orielly.javaGoodParts.examples.statistics.Player;
import org.orielly.javaGoodParts.examples.statistics.Team;

/**
 *
 */
public class PlayerImpl implements Player, Serializable {

    private static final long serialVersionUID = 1;
    private UUID id;
    private String name;
    private String filePrefix;
    private Team team;
    private Position pos = Position.Utility;
    private boolean changed = false;

    public PlayerImpl(String playerName) {
        name = playerName;
        id = UUID.randomUUID();
    }

    public PlayerImpl(UUID playerId, String prefix) {
        id = playerId;
        filePrefix = prefix;
        try {
            ObjectInputStream readIn = new ObjectInputStream(
                    new FileInputStream(prefix + id.toString()));
            PlayerImpl copy = (PlayerImpl) readIn.readObject();
            readIn.close();
            id = playerId;
            name = copy.name;
            team = copy.team;
            pos = copy.pos;
        } catch (IOException e) {
            System.out.println(
                    "unable to open file for player, creating new player object");
            name = "unknown";
        } catch (ClassNotFoundException e) {
            System.out.println("unable to read file for player");
        }
    }

    protected void writeState() {
        try {
            ObjectOutputStream writeOut =
                    new ObjectOutputStream(new FileOutputStream(
                    filePrefix + id.toString()));
            writeOut.writeObject(this);
            writeOut.close();
            changed = false;
        } catch (Exception e) {
            System.out.println("unable to write object");
            e.printStackTrace();
        }
    }

    protected void finalize(){
        if (changed){
            writeState();
            System.out.println("writing state in finalizer");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    public Position getPosition() {
        return pos;
    }

    public void setPosition(Position playPosition) {
        if (playPosition != pos) {
            pos = playPosition;
            changed = true;
        }
    }
}
