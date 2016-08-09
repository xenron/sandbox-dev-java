/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.orielly.javaGoodParts.examples.impl;

import java.io.File;
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

    private static long serialVersionUID = 1;
    private UUID id;
    private String name;
    private Team team;
    private Position pos = Position.Utility;
    private boolean changed = false;

    public PlayerImpl(String playerName) {
        name = playerName;
        id = UUID.randomUUID();
    }

    private String getFileRoot(){
        String fileRoot = System.getProperty("Statistics.fileRoot");
        if (fileRoot == null){
            fileRoot = System.getProperty("user.dir");
        }
        fileRoot = fileRoot + System.getProperty("file.separator");
        return fileRoot;
    }

    public PlayerImpl(UUID playerId, String teamName) {
        id = playerId;
        try {
            ObjectInputStream readIn =
                    new ObjectInputStream(new FileInputStream(
                    getFileRoot() +  teamName +
                    System.getProperty("file.separator") + id.toString()));
            PlayerImpl fromDisk = (PlayerImpl) readIn.readObject();
            readIn.close();
            id = playerId;
            name = fromDisk.name;
            team = fromDisk.team;
            pos = fromDisk.pos;
        } catch (IOException e) {
            System.out.println("unable to open file for player, creating new player object");
            name = "unknown";
            if (readIn.
        } catch (ClassNotFoundException e) {
            System.out.println("unable to read file for player");
        }
    }

    protected void writeState() {
        try {
            ObjectOutputStream writeOut =
                    new ObjectOutputStream(new FileOutputStream(
                    getFileRoot() + team.getName() +
                    System.getProperty("file.separator") + id.toString()));
            writeOut.writeObject(this);
            writeOut.close();
            changed = false;
        } catch (Exception e) {
            System.out.println("unable to write object");
        }
    }

    protected void finalize(){
        if (changed){
            writeState();
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
