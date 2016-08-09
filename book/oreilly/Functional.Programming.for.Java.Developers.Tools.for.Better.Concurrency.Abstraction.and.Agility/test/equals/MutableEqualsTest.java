package equals;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Demonstrates problems created by using equals/hashCode for 
 * mutable objects.
 */
public class MutableEqualsTest {

  // A mutable class.
  public static class MutableName {
    private String name;
    public void setName(String name) {
      this.name = name;
    }
    public String getName() { return name; }
    
    public MutableName(String name) { this.name = name; }
    
    public boolean equals(Object o) {
      if (o == null || o.getClass() != MutableName.class)
        return false;
      return name.equals(((MutableName) o).name);
    }
    public int hashCode() {
      return 37 * name.hashCode();
    }
  }

  @Test
  public void mutableObjectsMakeBadHashKeys() {
    Map<MutableName,String> map = new HashMap<MutableName,String>();
    MutableName name = new MutableName("Dean");
    map.put(name, "dean");
    assertEquals("dean", map.get(name));
    name.setName("Bubba");
    // It's gone!!
    assertEquals(null, map.get(name)); 
  }
}