/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.oreilly.javaGoodParts.examples.impl;

import java.io.Serializable;
import org.oreilly.javaGoodParts.examples.statistics.Fielder;

/**
 *
 * @author waldo
 */
public class FielderImpl implements Fielder, Serializable {
    private static long serialVersionUID = 1;

    protected int attempts;
    protected int putOuts;
    protected int assists;
    protected int errors;

    public FielderImpl(){
        attempts = putOuts = assists = errors = 0;
    }

    @Override
    public void fieldTry(AttemptResult what) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void playInning() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float getFieldAverage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float getRange() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getAssists() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getAttempts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getErrors() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getPutOuts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
