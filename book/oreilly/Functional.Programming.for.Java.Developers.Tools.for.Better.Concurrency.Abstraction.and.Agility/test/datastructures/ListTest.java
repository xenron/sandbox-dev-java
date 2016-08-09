package datastructures;
import org.junit.*;
import java.util.Map;
import java.util.HashMap;
import static org.junit.Assert.*;
import static datastructures.ListModule.*;

public class ListTest {

  List<String> EMPTYLS = emptyList();
  List<Long>   EMPTYLL = emptyList();

  @Test
  public void emptyListsOfCollectionsAreSupported() {
    List<List<Long>> emptyLLL = emptyList();
    assertEquals(emptyLLL, EMPTYLL);
    List<? extends Map<String,Long>> emptyLMSL = emptyList();
    assertEquals(emptyLMSL, EMPTYLL);
  }

  @Test(expected = EmptyListHasNoHead.class)
  public void callingHeadOnAnEmptyListRaises() {
    EMPTYLS.head();
  }

  @Test(expected = EmptyListHasNoTail.class)
  public void callingTailOnAnEmptyListRaises() {
    EMPTYLS.tail();
  }

  @Test
  public void callingTailOnAOneElementListReturnsAnEmptyList() {
    List<String> tail = list("one", EMPTYLS).tail();
    assertEquals(emptyList(), tail);
  }

  @Test
  public void callingTailOnAListWithMultiplElementsReturnsANonEmptyList() {
    List<String> tail = list("one", list("two", list("three", EMPTYLS))).tail();
    assertEquals(list("two", list("three", EMPTYLS)), tail);
  }

  @Test
  public void callingHeadOnANonEmptyListReturnsTheHead() {
    String head = list("one", EMPTYLS).head();
    assertEquals("one", head);
  }

  @Test
  public void AllEmptyListsAreEqual() {
    assertEquals(EMPTYLS, EMPTYLL);
  }

  @Test
  public void AnEmptyListAndNonEmptyListAreNeverEqual() {
    List<String> list1 = list("one", EMPTYLS);
    assertFalse(list1.equals(EMPTYLS));
  }

  @Test
  public void TwoNonEmptyListsAreEqualIfTheirHeadsAndTailsAreEqual() {
    List<String> list1 = list("one", list("two", list("three", EMPTYLS)));
    List<String> list2 = list("one", list("two", list("three", EMPTYLS)));
    List<Long> list3 = list(1L, list(2L, list(3L, EMPTYLL)));
    assertEquals(list1, list2);
    assertFalse(list1.equals(list3));
  }

  @Test
  public void TwoNonEmptyListsAreNotEqualIfTheirSizesAreDifferent() {
    List<String> list1 = list("one", EMPTYLS);
    List<String> list2 = list("one", list("two", EMPTYLS));
    assertFalse(list1.equals(list2));
  }

  @Test
  public void ListsAreRecursiveStructures() {
    List<String> list1 = list("one", list("two", list("three", EMPTYLS)));
    assertEquals("(one, (two, (three, ())))", list1.toString());
  }
}