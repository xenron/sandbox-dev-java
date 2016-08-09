package tuning.hash;

import tuning.dict.Dict;
import java.util.HashMap;

public class HashsizeTest {
  public static void main(String[] args)
    throws Exception
  {
    Dict.initialize(true);
    for (int i = 5; i > 0 ; i--)
    {
      test(89);
      test(101);
      test(101);
      test(89);
    }
  }
  public static void test(int size)
  {
    long time = System.currentTimeMillis();
    for (int i = 10; i > 0 ; i--)
      test1(size);
    time = System.currentTimeMillis() - time;
    System.out.println(size + " size, time: " + time);
  }
  public static void test1(int size)
  {
    HashMap h = new HashMap(size);
    for (int i = Dict.DICT.length-1; i >=0 ; i--)
      h.put(Dict.DICT[i], Boolean.TRUE);
    Object o;
    for (int i = Dict.DICT.length-1; i >=0 ; i--)
      o = h.get(Dict.DICT[i]);
  }
}
