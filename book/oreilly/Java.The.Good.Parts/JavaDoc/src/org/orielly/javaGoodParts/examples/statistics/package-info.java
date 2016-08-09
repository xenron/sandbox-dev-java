/**
 * Provides the interfaces needed to build a system
 * that tracks the statistics fo a group of baseball
 * players.<p>
 *
 * The statistics for individuals are tracked through
 * an object that implements the {@link 
 * org.orielly.javaGoodParts.examples.statistics.Player}
 * interface. A player will have a {@link
 * org.orielly.javaGoodParts.examples.statistics.Player.Position},
 * and based on that position will implement the
 * interfaces that track statistics for the various
 * roles that player may have. Players are
 * grouped together in objects that implement the
 * {@link org.orielly.javaGoodParts.examples.statistics.Team}
 * interface.<p>
 *
 * Objects that implement the {@link
 * org.orielly.javaGoodParts.examples.statistics.Player}
 * interface will implement calls that return the statistics
 * interfaces, such as the {@link
 * org.orielly.javaGoodParts.examples.statistics.Batter}
 * interface. The current Player interface only reflects the
 * ability to return a {@link org.orielly.javaGoodParts.examples.statistics.Batter}
 * interface, but the ability to return other statistical interfaces will
 * be added later in the development of this example.
 * <p>
 *
 * Only players that have the position <code>Catcher</code>
 * will return an object that implements the {@link
 * org.orielly.javaGoodParts.examples.statistics.Catcher}
 * interface, as this allows tracking statistics that are
 * unique to that position.<p>
 *
 * At this time there is no interface that can be
 * used to track pitching statistics, as this is an
 * example system and pitching statistics get arbitrarily
 * complex. However, it should be clear from the
 * various other interfaces what such a <code>
 * Pitcher</code> interface would look like.
 */
package org.orielly.javaGoodParts.examples.statistics;

