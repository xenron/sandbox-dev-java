/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.orielly.javaGoodParts.examples.impl;

/**
 *
 * @author waldo
 */

import org.orielly.javaGoodParts.examples.statistics.NotEnoughAtBatsException;
import org.orielly.javaGoodParts.examples.statistics.Batter;
import org.orielly.javaGoodParts.examples.statistics.Player;

public class Formatter {

    public static void Format(Batter toFormat) {
        System.out.print(toFormat.getPlayer().getName());
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
}
