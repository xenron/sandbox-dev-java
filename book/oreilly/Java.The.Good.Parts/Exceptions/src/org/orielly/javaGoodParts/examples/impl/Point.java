package org.orielly.javaGoodParts.examples.impl;

/**
 * The tried-and-true object-oriented example of a point.
 * This interface allows setting and getting the value of 
 * the X and Y coordinates of a point, without assuming that
 * we know the internal representation of the point.
 * @author waldo
 *
 */
public interface Point {
	/**
	 * Get the x-coordinate of the point
	 * @return the most recent value passed as
	 * an argument to setX()
	 */
	int getX();
	
	/**
	 * Get the y-coordinate of the point
	 * @return the most recent value passed as
	 * an argument to setY()
	 */
	int getY();
	/**
	 * Set the x coordinate to the supplied value
	 * @param newX an integer that will be returned
	 * by subsequent invocations of getX()
	 */
	void setX(int newX);
	/**
	 * Set the y coordinate to the supplied value
	 * @param 
	 * newY an integer that will be returned by subsequent
	 * invocations of getY()
	 */
	void setY(int newY);
}
