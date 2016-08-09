package org.oreilly.javaGoodParts.examples.statistics;

/**
 * A basic interface that allows gathering statistics for a catcher. A catcher
 * is a type of fielder who can also be charged with a passed ball.
 */
public interface Catcher extends Fielder {
	/**
	 * Record a passed ball
	 */
	void PassedBall();

	/**
	 * Get how many passed balls this catcher has allowed
	 * 
	 * @return an integer count of the number of passed balls charged to this
	 *         catcher
	 */
	int getPassedBalls();
}
