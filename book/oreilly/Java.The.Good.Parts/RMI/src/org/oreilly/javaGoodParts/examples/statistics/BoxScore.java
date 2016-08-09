
package org.oreilly.javaGoodParts.examples.statistics;

import java.util.List;
import java.util.UUID;

/**
 * An interface that will allow passing all of the
 * statistics from a single game to a {@link StatRecorder},
 * which will record the statistics for that game.
 */
public interface BoxScore {
    /**
     * Get a {@link List} of the names of the teams that played
     * the game. Unless something is very strange,
     * there should be exactly two teams in the List
     * @return A {@link List} of {@link String} that are the names
     * containing the two teams that played the game
     */
    List<String> getTeams();

    /**
     * Get a {@link List} of the ids of the players who were
     * in the game for the indicated team
     * @param forTeam The {@link String} name of
     * the team for which
     * the list of players returned plays
     * @return a {@link List} of {@link UUID} identifying
     * who played for the team in the game
     * being reported
     */
    List <UUID> getPlayers(String forTeam);

    /**
     * Get the position played by the particular
     * player today.
     * @param forPlayer The {@link UUID} which
     * is the player id of the player whose
     * position for the game is being reported
     * @return the {@link Player.Position} played
     * by the player in this game
     * @throws DidNotPlayException if the player
     * did not play in the game being reported
     */
    Player.Position getPosition(UUID forPlayer)
            throws DidNotPlayException;

    /**
     * Gets a list of the at-bat results for a player
     * @param playerID the {@link UUID} for
     * the player whose batting is being reported
     * @return a list of {@link Batter.AtBatResults} for
     * the player in the particular game. If the player
     * did not bat in the game, or if the player did not
     * play in the game, the list will be empty
     */
    List<Batter.AtBatResult> getBatting(UUID playerID);

    /**
     * Gets a list of the fielding results for the indicated
     * player in this game.
     * @param forPlayer the {@link UUID} player id
     * for the player whose fielding results are being reported
     * @return a list of {@link Fielder.AttemptResult} for
     * the player in the particular game. If the player made
     * no plays in the field, or did not play, the list will be
     * empty
     */
    List<Fielder.AttemptResult> getFielding(UUID forPlayer);

    /**
     * Gets the number of passed balls being reported
     * for a particlar player in this game. Note that this
     * should only be called if the player had the {@link Player.Position}
     * of catcher sometime during the game
     * @param forPlayer The {@link UUID} player id
     * for the player whose passed ball count is being reported
     * @return the number of passed balls recorded
     * for the player during the game. If there were no
     * passed balls for the player, or if the player was
     * not catching during the game, or if the player did
     * not play, the returned value will be 0
     */
    int getPassedBalls(UUID forPlayer);
}
