package datastructures2;
import org.junit.Test;

import datastructures2.ListModule.List;
import static org.junit.Assert.*;
import functions.*;
import static datastructures2.ListModule.*;

public class FunctionCombinatorTest {
  private static final List<Integer> EMPTYLI = emptyList();

	@Test
  public void higherOrderFunctionCombinatorExample() {
	
    List<Integer> listI =
      list(1, list(2, list(3, list(4, list(5, list(6, EMPTYLI))))));
    Integer sum = listI.filter(new Function1<Integer,Boolean>() {
      public Boolean apply(Integer i) { return i % 2 == 0; }
    })
    .map(new Function1<Integer, Integer>() {
      public Integer apply(Integer i) { return i * 2; }
    })
    .foldLeft(0, new Function2<Integer, Integer, Integer>() {
       public Integer apply(Integer seed, Integer item) { return seed + item; }
    });
    assertEquals(new Integer(24), sum);
  }
}
