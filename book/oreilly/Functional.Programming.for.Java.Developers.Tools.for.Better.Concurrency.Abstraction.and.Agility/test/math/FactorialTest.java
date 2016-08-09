package math;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactorialTest {

  @Test
  public void checkImperativeFactorial() {
    assertEquals (3628800, Factorial.imperativeFactorial(10));
  }

  @Test
  public void checkDeclarativeFactorial() {
    assertEquals (3628800, Factorial.declarativeFactorial(10));
  }

  @Test(expected = AssertionError.class)
  public void declarativeFactorialThrowsIfNIsZero() {
    assertEquals (3628800, Factorial.declarativeFactorial(0));
  }

  @Test(expected = AssertionError.class)
  public void declarativeFactorialThrowsIfNIsNegative() {
    assertEquals (3628800, Factorial.declarativeFactorial(-1));
  }

  @Test(expected = AssertionError.class)
  public void imperativeFactorialThrowsIfNIsZero() {
    assertEquals (3628800, Factorial.imperativeFactorial(0));
  }

  @Test(expected = AssertionError.class)
  public void imperativeFactorialThrowsIfNIsNegative() {
    assertEquals (3628800, Factorial.imperativeFactorial(-1));
  }
}
