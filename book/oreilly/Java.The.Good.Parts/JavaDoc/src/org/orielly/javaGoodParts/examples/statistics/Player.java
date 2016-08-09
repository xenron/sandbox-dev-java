package org.orielly.javaGoodParts.examples.statistics;

import java.util.UUID;

/**
 * Basic interface for a player object. An object implementing
 * this interface can be made part of a {@link Team}. Classes 
 * implementing this interface will also allow access to statistics
 * gathered for the player in the form of objects of type
 * {@link Batter}, {@link Fielder}, or {@link Catcher}. Which
 * of these roles will be had by a Player will in part be determined
 * by the {@link Position} of the Player.
 */
public interface Player {

	/**
	 * The position played by the player. The position can be used to determine
	 * what objects supporting other interfaces will be returned by an
	 * implementation of the object that also implements this interface. All
	 * objects that implement this interface that are not assigned a Position of
	 * <code> Pitcher</code> and are not on {@link Team} in the American League
	 * will return an object implementing the {@link Batter} interface. All
	 * objects that implement this interface will return an object implement the
	 * {@link Fielder} interface except for those that have a position of
	 * <code>DH</code>; only players on {@link Team} that are in the American
	 * League can be assigned that position. Only players assigned the position
	 * of <code> Catcher</code> will return an object implementing the
	 * {@link Catcher} interface.
	 */
    public enum Position {
        Pitcher, Catcher, FirstBase, SecondBase,
        ThirdBase, ShortStop, LeftField, CenterField,
        RightField, DH, Utility
    }

    /**
     * Return the identifier for the player. This is just
     * a {@link UUID}, generated when the player object is
     * first created, used to distinguish between players
     * that might have the same name. It is up to the
     * implementation of the method to insure that the
     * identifier is unique over the set of all players.
     *
     * @return A {@link UUID} that is unique for this player
     */
    public UUID getId();

    /**
     * Return the name of the player, as a {@link String}
     *
     * @return A {@link String} that is the name of this player
     */
    public String getName();

    /**
     * Return a {@link Team} object that represents
     * the team that this player is on.
     *
     * @return The {@link Team} for which this player plays
     */
    public Team getTeam();

    /**
     * Return the {@link Position} played by this player,
     * which can be used to determine the roles that
     * the player has.
     * @return the {@link Position} of this player
     */
    public Position getPosition();

    /**
     * Set the {@link Position} of the player
     *
     * @param pos the {@link Position} played
     * by this player
     */
    public void setPosition(Position pos);

    /**
     * Return a {@link Batter} object if this player has the role of a
     * Batter, otherwise returns null.
     * 
     * @return a {@link Batter} object containing the batting statistics
     * for this player.
     */
    public Batter asBatter();
}
