
package org.oreilly.javaGoodParts.examples.impl;

/**
 * A set of examples using the classes to print out
 * information kept in the statistics package
 * 
 */

import java.util.Iterator;
import java.util.TreeSet;
import org.oreilly.javaGoodParts.examples.statistics.NotEnoughAtBatsException;
import org.oreilly.javaGoodParts.examples.statistics.Batter;
import org.oreilly.javaGoodParts.examples.statistics.Player;
import org.oreilly.javaGoodParts.examples.statistics.Player.Roles;
import org.oreilly.javaGoodParts.examples.statistics.Team;

public class Formatter {

    public static void Format(Batter toFormat) {
        System.out.print("\t");
        try {
            System.out.print(toFormat.getAverage());
            System.out.print("\t" + toFormat.getOBP());
            System.out.print("\t" + toFormat.getSlugging());
            System.out.print("\t" + toFormat.getAtBats());
            System.out.println("\t" + toFormat.getTotalBases());
        } catch (NotEnoughAtBatsException e) {
            System.out.println("\t" + "Not enough at-bats to be significant");
        }
    }

    public static void FormatRoster(Team toFormat){
        System.out.println(toFormat.getName());
        Iterator<Player> e = toFormat.getRoster().iterator();
        while (e.hasNext()){
            System.out.println("\t" + e.next().getName());
        }
    }

    public static void FormatRoster2(Team toFormat){
        System.out.println(toFormat.getName());
        for (Player i : toFormat.getRoster()){
            System.out.println("\t" + i.getName());
        }
    }
    
    public static void FormatBattingAvg(Team toFormat){
        TreeSet<Player> battingSort =
                new TreeSet<Player>(new BattingComparitor());

        battingSort.addAll(toFormat.getRoster());
        float avg = 0.0f;
        for (Player p : battingSort){
            System.out.print(p.getName() + "\t");
            if (p.hasRole(Roles.Batter)){
                try {
                    avg = p.asBatter().getAverage();
                } catch (NotEnoughAtBatsException e) {
                    avg = 0.0f;
                }
            }
            else
                avg = 0.0f;
            System.out.println(avg);
        }
    }

    public static void FormatBADescending(Team toFormat){
        TreeSet<Player> battingSort =
                new TreeSet<Player>(new BattingComparitor());

        battingSort.addAll(toFormat.getRoster());
        float avg = 0.0f;
        for (Player p = battingSort.last();
                null != p;
                battingSort.remove(p)){
            if (!p.hasRole(Roles.Batter))
                return;
            try {
                avg = p.asBatter().getAverage();
                if (avg == 0.0)
                        return;
            } catch (NotEnoughAtBatsException e){
                return;
            }
            System.out.println(p.getName() + "\t"
                    + avg);
        }
    }
}
