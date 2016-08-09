package org.orielly.javaGoodParts.examples.statistics;

/**
 * Exception thrown when a batter has not had enough attempts to make
 * the batting statistics valid. The exception contains both a string
 * indicating the reason for the exception, and the number of additional
 * at-bats a player needs before the particular statistic is considered
 * valid.
 * 
 * @author waldo
 *
 */
public class NotEnoughAtBatsException extends Exception {
	static final long serialVersionUID = 1;
	private int atBatsNeeded;

	/**
	 * Basic constructor, taking the reason and the number of 
	 * additional at-bats needed for a statistic to be valid
	 * @param message
	 * @param needed
	 */
	public NotEnoughAtBatsException(String message, int needed) {
		super(message);
		atBatsNeeded = needed;
	}
	
	/**
	 * Returns the number of at-bats needed for this exception to
	 * not be thrown for this batter.
	 * @return an integer showing the number of additional at-bats
	 * needed
	 */
	public int getNeeded(){
		return atBatsNeeded;
	}
}
