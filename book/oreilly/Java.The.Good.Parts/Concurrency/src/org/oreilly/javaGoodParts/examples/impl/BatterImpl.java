package org.oreilly.javaGoodParts.examples.impl;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import org.oreilly.javaGoodParts.examples.statistics.NotEnoughAtBatsException;
import org.oreilly.javaGoodParts.examples.statistics.Batter;

public class BatterImpl implements Batter, Serializable {
    private static final long serialVersionUID = 1L;

    private int atBats;
    private int hits;
    private int bases;
    private int baseOnBalls;
    private int sacrifices;
    private String playerName;

    public BatterImpl() {
        atBats = 0;
        hits = 0;;
        bases = 0;
        baseOnBalls = 0;
        sacrifices = 0;
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
        return ((float)hits/ (float)atBats);
    }

    @Override
    public float getOBP() throws NotEnoughAtBatsException {
        if ((atBats + sacrifices + baseOnBalls) < 10) {
            throw new NotEnoughAtBatsException("Insufficient plate appearances",
                    10 - atBats);
        }
        float obp = ((float)hits + (float)baseOnBalls)
                / ((float)atBats + (float)sacrifices + (float)baseOnBalls);
        return obp;
    }

    @Override
    public float getSlugging() throws NotEnoughAtBatsException {
        if (atBats < 10) {
            throw new NotEnoughAtBatsException("Insufficient plate appearances",
                    10 - atBats);
        }
        return ((float)bases / (float)atBats);
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
