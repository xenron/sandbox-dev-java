package tuning.string;

import tuning.dict.Dict;

public class Compare
{
  public static void main(String[] args)
  {
    try
    {
      Dict.initialize(true);
      int REPEAT = 1000;
      int count = 0;

      for(int i = Dict.DICT.length-1; i >= 0; i--)
        if (Dict.DICT[i].equals("outfox"))
            count=i;

      String[] ODICT = new String[Dict.DICT.length];
      String[] ODICT2 = new String[Dict.DICT.length];
      String[] ODICT3 = new String[Dict.DICT.length];
      String[] ODICT4 = new String[Dict.DICT.length];
      String[] ODICT5 = Dict.DICT;
      String[] ODICT6 = new String[Dict.DICT.length];
      String[] ODICT7 = new String[Dict.DICT.length];
      String[] ODICT8 = new String[Dict.DICT.length];
      for(int i = Dict.DICT.length-1; i >= 0; i--)
      {
        ODICT[i] = Dict.DICT[count];
        ODICT2[i] = "outfo";
        ODICT3[i] = "outfox";
        ODICT4[i] = "butfox";
        ODICT6[i] = "outfoy";
        ODICT7[i] = Dict.DICT[i];
	ODICT8[i] = i + "ello";
      }

      long time = System.currentTimeMillis();
      for(int j = 100; j > 0; j--)
        for(int i = Dict.DICT.length-1; i >= 0; i--)
          if (Dict.DICT[i].equals("outfox"))
            count=i;
      time = System.currentTimeMillis() - time;
      System.out.println("time (millis) = " + time);

      count = 0;
      for(int i = Dict.DICT.length-1; i >= 0; i--)
        if (Dict.DICT[i].length() != 6)
          count++;
      System.out.println( (count*100/Dict.DICT.length) + "% of words with a different length");
      count = 0;
      for(int i = Dict.DICT.length-1; i >= 0; i--)
        if ( (Dict.DICT[i].length() == 6) && (Dict.DICT[i].charAt(0) != 'o'))
          count++;
      System.out.println( (count*100/Dict.DICT.length) + "% of words with a same length but different first char");
      count = 0;
      for(int i = Dict.DICT.length-1; i >= 0; i--)
        if ( (Dict.DICT[i].length() == 6) && (Dict.DICT[i].charAt(0) == 'o'))
          count++;
      System.out.println( (count*100/Dict.DICT.length) + "% of words with a same length and same first char");

      System.out.println("Finished initializing");

      test(ODICT3, REPEAT, " (identity " + (ODICT3[0]=="outfox") + ")");
      test(ODICT2, REPEAT, " (all different sized strings)");
      test(ODICT4, REPEAT, " (same sized strings, different first char)");
      test(ODICT6, REPEAT, " (same sized strings, different last char)");
      test(ODICT5, REPEAT, " (all different words)");
      test(ODICT, REPEAT, " (same string, not identical)");
      test(Dict.DICT, REPEAT, " (all different words)");
      test(ODICT7, REPEAT, " (all different words)");
      test(ODICT8, REPEAT, " (all different generated words)");

    }
    catch(Exception e){e.printStackTrace();}
  }

  public static int test(String[] dict, int repeat, String s)
  {
      long time = System.currentTimeMillis();
      int count = 0;
      for(int j = repeat; j > 0; j--)
        for(int i = dict.length-1; i >= 0; i--)
          if ("outfox".equals(dict[i]))
            count++;
      time = System.currentTimeMillis() - time;
      System.out.println("time (millis) = " + time + s);

      time = System.currentTimeMillis();
      count = 0;
      for(int j = repeat; j > 0; j--)
        for(int i = dict.length-1; i >= 0; i--)
          if (dict[i].equals("outfox"))
            count++;
      time = System.currentTimeMillis() - time;
      System.out.println("time (millis) = " + time + s);

      return count;
  }

}