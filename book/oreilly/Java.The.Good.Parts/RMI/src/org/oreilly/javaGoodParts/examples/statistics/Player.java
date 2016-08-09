package org.oreilly.javaGoodParts.examples.statistics;

import java.util.UUID;

/**
 *Basic interface for a player object. A player
 * is identified by name, but since names can be
 * the same the player object also contains a
 * {@link java.util.UUID} that uniquely identifies
 * every player. Players also have a {@link Position},
 * and  a set of {@link Roles}. These roles will
 * determine which statistics will be gathered on
 * the player.
 */
public interface Player {

    /**
     * The roles that can be played by a player. These
     * roles determine which statistics will be gathered
     * about  the player.
     */
    public enum Roles {

        Batter, Fielder, Catcher, Pitcher
    }

    /**
     * The positions that can be played by a player.
     */
    public enum Position {

        Pitcher, Catcher, FirstBase, SecondBase,
        ThirdBase, ShortStop, LeftField, CenterField,
        RightField, DH, Utility
    }

    /**
     * Return the identifier for the player. This is just
     * an {@code int}, generated when the player object is
     * first created, used to distinguish between players
     * that might have the same name.
     * @return a {@link java.util.UUID} that will
     * be unique to this player
     */
    public UUID getId();

    /**
     * Return the name of the player, as a 
     * {@link java.lang.String}.
     * @return a {@link java.lang.String} that is the
     * name of the player
     */
    public String getName();

    /**
     * Return the {@link Team} object for which this
     * player plays
     * @return the player's {@link Team}
     */
    public Team getTeam();

    /**
     * Assign the player to a {@link Team}.
     * @param the {@link Team} the player is now
     * on
     */
    public void setTeam(Team newTeam);

    /**
     * Return the {@link Position} played by this player.
     * @return the {@link Position} of this player,
     * which will be used to determine the roles that the
     * player has
     */
    public Position getPosition();

    /**
     * Set the {@link Position} of the player.
     * @param pos the {@link Position} played
     * by this player
     */
    public void setPosition(Position pos);


    /**
     * Queries if the {@code Player} has the
     * indicated role. Returns {@code true} if the
     * player does have the role, and {@code false}
     * otherwise. Note that a player can have multiple
     * roles.
     * @param a role as defined in {@link Roles}
     * @return {@code true} if the player has the
     * role, and {@code false} otherwise
     */
    public boolean hasRole(Roles role);

    /**
     * Add a role to the set of roles for which
     * statistics are gathered by this player.
     * Adding a role multiple times has no effect
     * beyond the initial addition of the call. Roles
     * cannot be removed once assigned to a
     * player.
     * @param role the {@link Role} to be
     * added to the set of statistics for this
     * player
     */
    public void addRole(Roles role);

    /**
     * Return a {@link Batter} object if this player has
     * the role of a batter.  Otherwise, return
     * {@code null}.
     * @return A {@link Batter} object containing
     * the hitting statistics of this player if the player's
     * {@link Roles} contains the role of batter; otherwise
     * {@code null}
     */
    public Batter asBatter();

    /**
     * Return a {@link Fielder} object representing the
     * Fielding statistics for this player, if the player
     * has any such statistics. Otherwise, return null.
     * @return A {@link Fielder} object containing
     * the fielding statistics for this player if the player's
     * {@link Roles} contains the role of Fielder, otherwise
     * {@code null}
     */
    public Fielder asFielder();

    /**
     * Return a {@link Catcher} object representing
     * the catching statistics of this player, if the
     * player is a catcher, otherwise return null.
     * @return a {@link Catcher} object containing the
     * catching statistics for this player if the player's
     * {@link Roles} contains the role of catcher, otherwise
     * {@code null}
     */
    public Catcher asCatcher();
}

