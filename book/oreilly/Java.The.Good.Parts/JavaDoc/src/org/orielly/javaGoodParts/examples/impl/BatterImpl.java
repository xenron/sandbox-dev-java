package org.orielly.javaGoodParts.examples.impl;

import java.io.Serializable;
import org.orielly.javaGoodParts.examples.statistics.NotEnoughAtBatsException;
import org.orielly.javaGoodParts.examples.statistics.Batter;
import org.orielly.javaGoodParts.examples.statistics.Player;

public class BatterImpl implements Batter, Serializable {

    private static final long serialVersionUUID = 1L;
    private int atBats;
    private int hits;
    private int bases;
    private int baseOnBalls;
    private int sacrifices;
    private Player forPlayer;

    public BatterImpl(Player player) {
        forPlayer = player;
        atBats = hits = bases = baseOnBalls = sacrifices = 0;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAtBats() {
        return atBats;
    }

    /**
     * {@inheritDoc}</p>
     * In this implementation, the batting average
     * is returned as a fraction; it is not adjusted
     * to move the decimal place. </p>
     * The minimum number
     * of at bats to establish an average is 10.
     * Players with fewer than 10 at bats
     * will not have an average. Instead, a call to
     * this function will throw a {@ link NotEnoughAtBatsException}
     *
     * @return the batting average, in decimal form
     * @throws NotEnoughAtBatsException if the
     * number of at-bats is less than 10
     */
    @Override
    public float getAverage() throws NotEnoughAtBatsException {
        if (atBats < 10) {
            throw new NotEnoughAtBatsException("Insufficient at bats",
                    10 - atBats);
        }
        return (hits / atBats);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float getOBP() throws NotEnoughAtBatsException {
        if ((atBats + sacrifices + baseOnBalls) < 10) {
            throw new NotEnoughAtBatsException("Insufficient plate appearances",
                    10 - atBats);
        }
        float obp = (hits + baseOnBalls) / (atBats + sacrifices + baseOnBalls);
        return obp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float getSlugging() throws NotEnoughAtBatsException {
        if (atBats < 10) {
            throw new NotEnoughAtBatsException("Insufficient plate appearances",
                    10 - atBats);
        }
        return (bases / atBats);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTotalBases() throws NotEnoughAtBatsException {
        if (atBats < 10) {
            throw new NotEnoughAtBatsException("Insufficient at bats",
                    10 - atBats);
        }
        return bases;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getPlayer() {
        return forPlayer;
    }
}

