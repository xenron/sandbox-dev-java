package  option;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class OptionTest {
  private List<Option<String>> names = null;

  @Before
  public void setup() {
    names = new ArrayList<Option<String>>();
    names.add(new Some<String>("Dean"));
    names.add(new None<String>());
    names.add(new Some<String>("Wampler"));
  }

  @Test
  public void getOrElseUsesValueForSomeAndAlternativeForNone() {
    String[] expected = { "Dean", "Unknown!", "Wampler"};;

    System.out.println("*** Using getOrElse:");
    for (int i = 0; i < names.size(); i++) {
      Option<String> name = names.get(i);
      String value = name.getOrElse("Unknown!");
      System.out.println(name + ": " + value);
      assertEquals(expected[i], value);
    }
  }

  @Test
  public void hasNextWithGetUsesOnlyValuesForSomes() {
    String[] expected = { "Dean", null, "Wampler"};;

    System.out.println("*** Using hasValue:");
    for (int i = 0; i < names.size(); i++) {
      Option<String> name = names.get(i);
      if (name.hasValue()) {
        String value = name.get();
        System.out.println(name + ": " + value);
        assertEquals(expected[i], value);
      }
    }
  }

  static Option<String> wrap(String s) {
    if (s == null)
      return new None<String>();
    else
      return new Some<String>(s);
  }
 
  @Test
  public void exampleMethodReturningOption() {
    System.out.println("*** Method that Returns an Option:");
    Option<String> opt1 = wrap("hello!"); 
    System.out.println("hello! -> "+opt1);
    assertEquals(Some.class, opt1.getClass());
    assertEquals("hello!", opt1.get());

    Option<String> opt2 = wrap(null); 
    System.out.println("null -> "+opt2);
    assertEquals(None.class, opt2.getClass());
    assertEquals("str", opt2.getOrElse("str"));
  }
}