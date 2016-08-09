/*
 *A basic implementation of the Catcher interface
 */

package org.oreilly.javaGoodParts.examples.impl;

import org.oreilly.javaGoodParts.examples.statistics.Catcher;
import org.oreilly.javaGoodParts.examples.statistics.Fielder;

/**
 * A basic implementation of the Catcher
 */
public class CatcherImpl extends FielderImpl
        implements Catcher{
    private static long serialVersionUID = 1;

    private int passedBalls;

    public CatcherImpl(){
        super();
        passedBalls = 0;
    }

    public CatcherImpl(Fielder oldStats){
        attempts = oldStats.getAttempts();
        putOuts = oldStats.getPutOuts();
        assists = oldStats.getAssists();
        errors = oldStats.getErrors();
        passedBalls = 0;
    }

    public void PassedBall(){
        passedBalls++;
    }

    public int getPassedBalls(){
        return passedBalls;
    }
}
