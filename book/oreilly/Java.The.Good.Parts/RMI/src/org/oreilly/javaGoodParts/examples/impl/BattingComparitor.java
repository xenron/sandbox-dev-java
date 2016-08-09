

package org.oreilly.javaGoodParts.examples.impl;

import java.util.Comparator;
import org.oreilly.javaGoodParts.examples.statistics.NotEnoughAtBatsException;
import org.oreilly.javaGoodParts.examples.statistics.Player;

/**
 * A comparitor that will rank players depending on
 * their batting average. If both players have a
 * batting average, the one with the higher average
 * is compared as greater than the other. Players with
 * insufficient at bats or who don't bat at all are
 * dealt with as if their batting average is 0. If two
 * players have the same batting average, they will
 * be compared based on their player ids, which are
 * guaranteed to be unique.
 *
 * This comparison will give a well-ordering to any
 * collection of players, based on their batting average.
 * Ties are broken by using the Id field of the player, which
 * is also used to determine equality
 */
public class BattingComparitor implements Comparator<Player>{

    @Override
    public int compare(Player o1, Player o2) {
        float o1A, o2A;
        int retVal;
        
        if (o1.getId() == o2.getId())
            return 0;
        if (o1.hasRole(Player.Roles.Batter)){
            try {
                o1A = o1.asBatter().getAverage();
            } catch (NotEnoughAtBatsException e){
                o1A = (float) 0.0;
            }
        } else
            o1A = 0.0f;

        if (o2.hasRole(Player.Roles.Batter)){
            try {
                o2A = o2.asBatter().getAverage();
            } catch (NotEnoughAtBatsException e){
                o2A = (float) 0.0;
            }
        } else
            o2A =  0.0f;

        if (o1A < o2A)
            retVal = -1;
        else if (o2A < o1A)
            retVal = 1;
        else 
            retVal = o1.getId().compareTo(o2.getId());


        return retVal;
    }

    public boolean equals(Player o1, Player o2){
        return (o1.getId()== o2.getId());
    }

}
