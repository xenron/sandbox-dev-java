/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author heffel
 */
@Stateless
@LocalBean
public class WeightUnitConversion {

    public double kilosToPounds(double kilos) {
        return kilos * 2.205;
    }

    public double poundsToKilos(double pounds) {
        return pounds / 2.205;
    }
}
