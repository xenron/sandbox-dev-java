package org.orielly.javaGoodParts.examples.impl;
/**
 * A class that checks implementations of the Batter
 * interface. The class will be initialized with an array
 * of AtBatResults, will take a Batter object and feed in
 * those results, and then will check the statistics that
 * were generated. For simplicity sake, the current implementation
 * only checks the Slugging Average
 * @author waldo
 *
 */

import org.orielly.javaGoodParts.examples.statistics.NotEnoughAtBatsException;
import org.orielly.javaGoodParts.examples.statistics.Batter;

public class CheckBatter {
	private Batter.AtBatResult[] testData;
	
	public CheckBatter(Batter.AtBatResult[] data){
		testData = data;
	}

	public boolean SluggingTest(Batter toTest){
		for (Batter.AtBatResult r : testData){
			toTest.atBat(r);
		}
		try {
			if ((toTest.getTotalBases()/toTest.getAtBats()) 
					!= toTest.getSlugging()){
				return false;
				}		
			} catch (NotEnoughAtBatsException e){
				if ((e.getNeeded() + toTest.getAtBats()) != 10)
					return false;
			}
		return true;
	}
}
