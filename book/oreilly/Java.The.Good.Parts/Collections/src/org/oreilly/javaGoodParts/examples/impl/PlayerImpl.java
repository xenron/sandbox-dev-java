/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.oreilly.javaGoodParts.examples.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.UUID;
import org.oreilly.javaGoodParts.examples.statistics.Batter;
import org.oreilly.javaGoodParts.examples.statistics.Catcher;
import org.oreilly.javaGoodParts.examples.statistics.Fielder;
import org.oreilly.javaGoodParts.examples.statistics.Player;
import org.oreilly.javaGoodParts.examples.statistics.Team;

/**
 *
 */
public class PlayerImpl implements Player, Serializable {

    private static final long serialVersionUID = 1;
    private UUID id;
    private String name;
    private Team team;
    private Position pos = Position.Utility;
    private EnumSet<Roles> roles;
    private boolean changed = false;

    private BatterImpl batterStats;
    private FielderImpl fielderStats;
    private CatcherImpl catcherStats;

    public PlayerImpl(String playerName) {
        name = playerName;
        id = UUID.randomUUID();
        batterStats = null;
        fielderStats = null;
        catcherStats = null;
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
            PlayerImpl copy = (PlayerImpl) readIn.readObject();
            readIn.close();
            id = playerId;
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

    public void setTeam(Team newTeam){
        team = newTeam;
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

    public boolean hasRole(Roles role){
        return roles.contains(role);
    }

    public void addRole(Roles role){
        if (roles.contains(role))
            return;
        switch (role){
            case Batter:
                batterStats = new BatterImpl(this);
                break;
            case Fielder:
                fielderStats = new FielderImpl();
                break;
            case Catcher:
                if (roles.contains(Roles.Fielder)){
                    catcherStats = new CatcherImpl(fielderStats);
                    fielderStats = catcherStats;
                } else {
                    catcherStats = new CatcherImpl();
                    roles.add(Roles.Fielder);
                }
                break;
        }
        roles.add(role);
    }

    public Batter asBatter(){
        return batterStats;
    }

    public Fielder asFielder(){
        return fielderStats;
    }

    public Catcher asCatcher(){
        return catcherStats;
    }
}
