package math;
import static datastructures2.ListModule.*;
import datastructures2.ListModule.List;

public class NaturalNumbers {
  public static final int ZERO = 0;
	private static final List<Integer> EMPTYLI = emptyList();
 
  public static int next(int previous) { return previous + 1; } 
 
  public static List<Integer> take(int count) {
    return doTake(EMPTYLI, count);
  }

  private static List<Integer> doTake(List<Integer> accumulator, int count) {
    if (count == ZERO)
      return accumulator;
    else
      return doTake(list(next(count - 1), accumulator), count - 1);
  }
}
