package org.oreilly.javaGoodParts.examples.statistics;

/**
 * An interface that defines the notion of a fielder in a baseball statistics
 * package. A fielder will have attempts, which will be recorded along with the
 * results of that attempt. Running statistics for the fielder are then
 * available.
 */
public interface Fielder {
	/**
	 * enumeration of the possible results of a fielding try. Results are either
	 * an out, and error, or an assist.
	 */
	enum AttemptResult {
		putOut, error, assist
	}

	/**
	 * Record a fielding try, supplying the result
	 * 
	 * @param what
	 *            The result of the try
	 */
	void fieldTry(AttemptResult what);

	/**
	 * Record that an inning has been played by the fielder.
	 */
	void playInning();

	/**
	 * Return the fielding average, defined as (trys - errors)/trys
	 * 
	 * @return A float that is the player's fielding average
	 */
	float getFieldAverage();

	/**
	 * Return the player's fielding range, defined as ((putouts +
	 * assists)/attempts) * 9
	 * 
	 * @return a float that is the fielder's range
	 */
	float getRange();

	/**
	 * The number of outs credited to this fielder
	 * 
	 * @return an integer of the number of outs
	 */
	int getPutOuts();

	/**
	 * The number of assists (total) for this player
	 * 
	 * @return the assists, as an integer
	 */
	int getAssists();

	/**
	 * The number of fielding attempts by this player
	 * 
	 * @return The attempts, as an integeter
	 */
	int getAttempts();

	/**
	 * The number of errors committed by this player
	 * 
	 * @return the number of errors, as an integer
	 */
	int getErrors();
}
