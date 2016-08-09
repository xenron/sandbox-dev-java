package math;
import org.junit.Test;

import datastructures2.ListModule.List;
import static org.junit.Assert.*;
import static math.NaturalNumbers.*;
import static datastructures2.ListModule.*;

public class NaturalNumbersTest {
  private static final List<Integer> EMPTYLI = emptyList();

	@Test
  public void theFirstNaturalNumberIsONE() {
    assertEquals (1, next(ZERO));
  }

  @Test
  public void nextReturnsTheNextNaturalNumber() {
    assertEquals (2, next(next(ZERO))); 
    assertEquals (3, next(next(next(ZERO)))); 
    assertEquals (4, next(next(next(next(ZERO))))); 
  }

  @Test
  public void takeReturnsAnNElementListStartingWithOne() {
    List<Integer> expected = list(1, list(2, list(3, list(4, EMPTYLI))));
    assertEquals (expected, take(4)); 
  }
}
