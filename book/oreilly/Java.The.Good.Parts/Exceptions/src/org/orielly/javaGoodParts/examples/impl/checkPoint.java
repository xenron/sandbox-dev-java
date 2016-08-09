package org.orielly.javaGoodParts.examples.impl;

import org.orielly.javaGoodParts.examples.impl.Point;

/**
 * A simple class to test the invariants of the Point interface.
 * Tests to make sure that the value returned by get{X,Y}() is the
 * value that was last passed to the set{X,Y}() call.
 * 
 * @author waldo
 *
 */
public class checkPoint {
	private int[] testCases;
	
	/**
	 * Create an object that will check the invariants
	 * on a point object
	 * @param seed the set of integers that will be 
	 * used in the test
	 */
	public checkPoint(int[] seed){
		testCases = seed;
	}
	
	/**
	 * A simple check, running through our set of integers
	 * to insure that getting returns the last call to setting
	 * @param toCheck
	 * @return true if the invariants are not violated; false
	 * on the first violation of the invariants
	 */
	public boolean runCheck(Point toCheck){
		for (int i = 0; i < testCases.length; i++){
			toCheck.setX(testCases[i]);
			if (!(toCheck.getX() == testCases[i]))
				return false;
			toCheck.setY(testCases[(i+2)%testCases.length]);
			if (!(toCheck.getY() == testCases[i]))
				return false;
		}
		return true;
	}
}
