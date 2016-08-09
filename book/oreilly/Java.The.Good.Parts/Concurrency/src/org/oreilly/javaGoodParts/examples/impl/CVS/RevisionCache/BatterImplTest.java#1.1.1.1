/**
 * 
 */
package org.oreilly.javaGoodParts.examples.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.oreilly.javaGoodParts.examples.statistics.NotEnoughAtBatsException;
import org.oreilly.javaGoodParts.examples.statistics.Batter.AtBatResult;

/**
 * @author waldo
 *
 */
public class BatterImplTest {
	private BatterImpl[] testBatters;
	private Random dataGen = new Random(1);

	/**
	 * Set up the test array testBatters. We will test on 100 {@link BatterImpl}
	 * objects. These will each be initialized in a separate routine.
	 */
	@Before
	public void setUp() {
		testBatters = new BatterImpl[100];
		for (int i = 0; i < 100; i++) {
			testBatters[i] = new BatterImpl();
			initBatter(testBatters[i]);
		}
		System.out.println("Test setup successfully complete");
	}

	/**
	 * Initialize the test cases that will be used for these tests. Each object
	 * will be given a random number of at-bats ranging from 0-100; if the
	 * number of at-bats is less than 10, we increment the number by 10 to
	 * insure that each test case has the minimum number of at-bats. Then each
	 * at-bat will be given a random result, which will be recorded by a call to
	 * the {@link BatterImpl.atBat()} method.
	 * 
	 * @param batterImpl
	 *            The batter object being initialized
	 */
	private void initBatter(BatterImpl batter) {
		int numbats;
		HashMap<Integer, AtBatResult> resultsTable 
			= new HashMap<Integer, AtBatResult>();

		resultsTable.put(0, AtBatResult.strikeOut);
		resultsTable.put(1, AtBatResult.fieldOut);
		resultsTable.put(2, AtBatResult.base1);
		resultsTable.put(3, AtBatResult.base2);
		resultsTable.put(4, AtBatResult.base3);
		resultsTable.put(5, AtBatResult.base4);
		resultsTable.put(6, AtBatResult.walk);
		resultsTable.put(7, AtBatResult.reachOnError);
		resultsTable.put(8, AtBatResult.sacrifice);

		numbats = dataGen.nextInt(100);
		if (numbats < 10)
			numbats++;
		for (int i = 0; i < numbats; i++) {
			batter.atBat(resultsTable.get(dataGen.nextInt(8)));
		}
	}
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.oreilly.javaGoodParts.examples.impl.BatterImpl#atBat(org.oreilly.javaGoodParts.examples.statistics.Batter.AtBatResult)}.
	 */
	@Test
	public void testAtBat() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.oreilly.javaGoodParts.examples.impl.BatterImpl#getAtBats()}.
	 */
	@Test
	public void testGetAtBats() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.oreilly.javaGoodParts.examples.impl.BatterImpl#getAverage()}.
	 */
	@Test
	public void testGetAverage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.oreilly.javaGoodParts.examples.impl.BatterImpl#getOBP()}.
	 */
	@Test
	public void testGetOBP() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.oreilly.javaGoodParts.examples.impl.BatterImpl#getSlugging()}.
	 * This method will take the array of Batter objects stored in the private
	 * variable testBatters and made sure that all of them are consistent with
	 * regards to the slugging percentage, the number of at-bats, and the total
	 * number of bases recorded.
	 */
	@Test
	public void testGetSlugging() {
		float testAvg, calcAvg;

		for (int i = 0; i < testBatters.length; i++) {
			try {
				testAvg = testBatters[i].getSlugging();
				calcAvg = testBatters[i].getTotalBases()
						/ testBatters[i].getAtBats();
				assertEquals("Slugging test", testAvg, calcAvg, .02);
			} catch (NotEnoughAtBatsException e) {
				assertEquals("Slugging exception", true,
						(10 == (e.getNeeded() + testBatters[i].getAtBats())));
			}
		}
	}

	/**
	 * Test method for {@link org.oreilly.javaGoodParts.examples.impl.BatterImpl#getTotalBases()}.
	 */
	@Test
	public void testGetTotalBases() {
		fail("Not yet implemented");
	}

}
