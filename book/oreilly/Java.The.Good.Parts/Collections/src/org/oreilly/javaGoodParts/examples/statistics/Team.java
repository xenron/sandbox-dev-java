package org.oreilly.javaGoodParts.examples.statistics;

import java.util.Set;
import java.util.UUID;

/**
 * The {@code Team} interface, which defines the notion of a team for our
 * statistics package. A team is, at first incarnation, simply a collection of
 * players. All teams have a name.
 */
public interface Team {

	/**
	 * Return a {@code String} that is the name of this team
	 */
	String getName();

	/**
	 * Return the players that are on this team. The set returned is a set of
	 * player objects.
	 */
	Set<Player> getRoster();

	/**
	 * Add a player to the team
	 */
	void addPlayer(Player toAdd);

	/**
	 * Remove a player from the team
	 */
	void removePlayer(Player toRemove);

	/**
	 * Return a list of players who are on this team who have the supplied name.
	 * In general, the returned list will either be empty (which will be the
	 * case if there are no players on the team with the name) or a singleton
	 * list. However, if there are multiple players on the team with the same
	 * name, it will be up to the caller to decide which of the players in the
	 * list is wanted
	 * 
	 * @param name
	 *            {@link String} containing the name of the player whose object
	 *            is wanted
	 * @return a {@link List} of {@link Player} objects whose names match the
	 *         supplied {@link String}. If there are no players with a matching
	 *         name, the list is empty
	 */
	Set<Player> getPlayer(String name);

	/**
	 * Return the player on the team with the indicated player id. If no player
	 * has the supplied id, return {@code null}.
	 * 
	 * @param playerId
	 *            The {@link UUID} of the player whose record is desired
	 * @return The {@link Player} object for the player with the indicated
	 *         playerId, or {@code null} if there is no player on the team with
	 *         that id.
	 */
	Player getPlayer(UUID playerId);
}
