package datastructures2;

import org.junit.*;
import static org.junit.Assert.*;
import static datastructures2.ListModule.*;
import functions.*;

/**
 * Test our functional-style linked list.
 */
public class ListTest {

  List<String> EMPTYLS = emptyList();
  List<Float>  EMPTYLF = emptyList();

  // filter tests.
  @Test
  public void filterOnEmptyListReturnsEmptyList() {
    List<String> list2 = EMPTYLS.filter(new Function1<String,Boolean>() {
      public Boolean apply(String s) { return s.equals("two") ? false : true; }
    });
    assertEquals(EMPTYLS, list2);
  }
  
  @Test
  public void filterReturnsNewListWithTheDesiredElements() {
    List<String> list1 = list("one", list("two", list("three", EMPTYLS)));
    List<String> list2 = list1.filter(new Function1<String,Boolean>() {
      public Boolean apply(String s) { return true; }
    });
    assertEquals(list1, list2);

    List<String> list3 = list1.filter(new Function1<String,Boolean>() {
      public Boolean apply(String s) { return s.equals("two") ? false : true; }
    });
    assertEquals(list("one", list("three", EMPTYLS)), list3);
  }
  
  // map tests.
  @Test
  public void mapOnEmptyListReturnsEmptyList() {
    List<Float>  list2 = EMPTYLS.map(new Function1<String, Float>() {
      public Float apply(String s)  { return Float.valueOf(s); }
    });
    assertEquals(EMPTYLS, list2);
  }

  @Test
  public void mapReturnsNewListWithTransformedElements() {
    List<String> list1 = list("1.1", list("2.2", list("3.3", EMPTYLS)));
    List<Float>  list2 = list1.map(new Function1<String, Float>() {
      public Float apply(String s)  { return Float.valueOf(s); }
    });
    List<Float> expected = list(1.1F, list(2.2F, list(3.3F, EMPTYLF)));
    assertEquals(expected, list2);
  }

  // foldTests
  @Test
  public void foldLeftOnEmptyListReturnsTheSeed() {
    float sum = EMPTYLF.foldLeft(10.0F, new Function2<Float, Float, Float>() {
      public Float apply(Float seed, Float item) { return seed + item; }
    });
    assertEquals(10.0F, sum, 0.01);
  }

  @Test
  public void foldRightOnEmptyListReturnsTheSeed() {
    float sum = EMPTYLF.foldRight(10.0F, new Function2<Float, Float, Float>() {
      public Float apply(Float seed, Float item) { return seed + item; }
    });
    assertEquals(10.0F, sum, 0.01);
  }

  Function2<String, String, String> stringFolder = new Function2<String, String, String>() {
    public String apply(String seed, String item) { 
      return "(" + seed + "+" + item + ")"; 
    }
  };
 
  @Test
  public void foldLeftReturnsResultOfFoldingElementsFromTheLeft() {
    List<String> list1 = list("A", list("B", list("C", EMPTYLS)));
    String str = list1.foldLeft("seed", stringFolder);
    assertEquals("(((seed+A)+B)+C)", str);
  }

  @Test
  public void foldRightReturnsResultOfFoldingElementsFromTheRight() {
    List<String> list1 = list("A", list("B", list("C", EMPTYLS)));
    String str = list1.foldRight("seed", stringFolder);
    assertEquals("(A+(B+(C+seed)))", str);
  }

  @Test
  public void forCommutativeOpsFoldLeftEqualsFoldRight() {
    List<Float> list1 = list(1.1F, list(2.2F, list(3.3F, EMPTYLF)));
    float sum1 = list1.foldLeft(0.0F, new Function2<Float, Float, Float>() {
      public Float apply(Float seed, Float item) { return seed + item; }
    });
    float sum2 = list1.foldRight(0.0F, new Function2<Float, Float, Float>() {
      public Float apply(Float seed, Float item) { return seed + item; }
    });
    assertEquals(6.6F, sum1, 0.01);
    assertEquals(sum2, sum1, 0.01);
  }

  // foreach tests
  @Test
  public void foreachOnEmptyListDoesNothing() {
    EMPTYLF.foreach(new Function1Void<Float>() {
      public void apply(Float item) { fail(); }
    });
  }

  @Test
  public void foreachOnAListAppliesSideEffectingFuncToEachElement() {
    List<Float> listF = list(2.2F, list(2.2F, EMPTYLF));
    listF.foreach(new Function1Void<Float>() {
      public void apply(Float item) { assertEquals(2.2F, item, 0.01); }
    });
  }
}