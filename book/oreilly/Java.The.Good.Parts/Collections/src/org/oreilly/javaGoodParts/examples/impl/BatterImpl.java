package org.oreilly.javaGoodParts.examples.impl;

import org.oreilly.javaGoodParts.examples.statistics.NotEnoughAtBatsException;
import org.oreilly.javaGoodParts.examples.statistics.Batter;
import org.oreilly.javaGoodParts.examples.statistics.Player;

public class BatterImpl implements Batter {

	private Player forPlayer;
    private int atBats;
    private int hits;
    private int bases;
    private int baseOnBalls;
    private int sacrifices;
    private String playerName;

    public BatterImpl(Player player) {
    	forPlayer = player;
        atBats = hits = bases = baseOnBalls = sacrifices = 0;
    }

    public Player getPlayer() {
    		return forPlayer;
    }
    
    @Override
    public void atBat(AtBatResult what) {
        switch (what) {
            case strikeOut:
                break;
            case fieldOut:
                break;
            case base1:
                hits++;
                bases++;
                break;
            case base2:
                hits++;
                bases += 2;
                break;
            case base3:
                hits++;
                bases += 3;
            case base4:
                hits++;
                bases += 4;
            case sacrifice:
                sacrifices++;
                return;
            case walk:
                baseOnBalls++;
                return;
        }
        atBats++;
    }

    @Override
    public int getAtBats() {
        return atBats;
    }

    @Override
    public float getAverage() throws NotEnoughAtBatsException {
        if (atBats < 10) {
            throw new NotEnoughAtBatsException("Insufficient at bats",
                    10 - atBats);
        }
        return (hits / atBats);
    }

    @Override
    public float getOBP() throws NotEnoughAtBatsException {
        if ((atBats + sacrifices + baseOnBalls) < 10) {
            throw new NotEnoughAtBatsException("Insufficient plate appearances",
                    10 - atBats);
        }
        float obp = (hits + baseOnBalls) / (atBats + sacrifices + baseOnBalls);
        return obp;
    }

    @Override
    public float getSlugging() throws NotEnoughAtBatsException {
        if (atBats < 10) {
            throw new NotEnoughAtBatsException("Insufficient plate appearances",
                    10 - atBats);
        }
        return (bases / atBats);
    }

    @Override
    public int getTotalBases() throws NotEnoughAtBatsException {
        if (atBats < 10) {
            throw new NotEnoughAtBatsException("Insufficient at bats",
                    10 - atBats);
        }
        return bases;
    }
}
