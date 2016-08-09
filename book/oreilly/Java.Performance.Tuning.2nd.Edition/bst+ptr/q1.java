import java.util.Random;

public class q1
{

public static void main(String[] args)
  throws Exception
{
  main2(args);
  main2(args);
}

public static void main2(String[] args)
{
  int REPEAT_1 = 1000000;
  int REPEAT_2 = 10;
  boolean[] b = new boolean[arr.length*REPEAT_2];

  if (args[0].equals("1"))
    test1();
  else if (args[0].equals("2"))
    test2(REPEAT_1);
  else if (args[0].equals("3"))
    test3(REPEAT_1);
  else if (args[0].equals("4"))
    test4(REPEAT_2, b);
  else if (args[0].equals("5"))
    test5(REPEAT_2, b);
  else if (args[0].equals("6"))
    test6(REPEAT_2, b);
  else if (args[0].equals("7"))
    test7(REPEAT_2, b);
  else if (args[0].equals("8"))
    test8(REPEAT_2, b);
  else if (args[0].equals("9"))
    test9(REPEAT_2, b);
  else if (args[0].equals("10"))
    test10(REPEAT_2, b);
  else if (args[0].equals("11"))
    test11(REPEAT_2, b);
  else if (args[0].equals("12"))
    test12(REPEAT_2, b);
  else if (args[0].equals("13"))
    test13(REPEAT_2, b);
  else if (args[0].equals("14"))
    test14(REPEAT_2, b);
  else if (args[0].equals("15"))
    test15(REPEAT_2, b);
  else if (args[0].equals("16"))
    test16(REPEAT_2, b);
  else if (args[0].equals("17"))
    test17(REPEAT_2, b);
  else if (args[0].equals("18"))
    test18(REPEAT_2, b);
  else if (args[0].equals("19"))
    test19(REPEAT_2, b);
  else if (args[0].equals("20"))
    test20(REPEAT_2, b);
  else if (args[0].equals("21"))
    test21(REPEAT_2, b);
  else if (args[0].equals("22"))
    test22(REPEAT_2, b);
  else if (args[0].equals("23"))
    test23(REPEAT_2, b);
  else if (args[0].equals("24"))
    test24(REPEAT_2, b);
  else if (args[0].equals("25"))
    test25(REPEAT_2, b);
  else if (args[0].equals("26"))
    test26(REPEAT_2, b);
  else if (args[0].equals("27"))
    test27(REPEAT_2, b);
}


public static void test1()
{
  long time = System.currentTimeMillis();
  checkInteger("34567");
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger once " + time);
}

public static void test2(int repeat)
{
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
    checkInteger("1");
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger(\"1\") " + repeat + " times " + time);
}

public static void test3(int repeat)
{
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
    checkInteger("30298");
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger(\"30298\") " + repeat + " times " + time);
}

public static void test4(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset1();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger(arr[i]);
//      if (!b[i+offset]) System.out.println(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger0 " + time);
}

public static void test5(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset2();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger(arr[i]);
//      if (!b[i+offset]) System.out.println(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger0 " + time);
}

public static void test6(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset3();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger(arr[i]);
//      if (!b[i+offset]) System.out.println(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger0 " + time);
}


public static boolean checkInteger(String testInteger)
{
  try
  {
    Integer theInteger = new Integer(testInteger);//fails if not  a vaild number/integer
    return
      (theInteger.toString() != "") && //not empty
      (theInteger.intValue() > 10) && //greater than ten
      ((theInteger.intValue() >= 2) && (theInteger.intValue() <= 100000)) && //2>=X<=100000
      (theInteger.toString().charAt(0) == '3'); //first digit = 3               
  }
  catch (NumberFormatException err)
  {
    return false;
  }     
}

static Random R = new Random(12345);
public static void initRand()
{
  R = new Random(12345);
}

public static String genNonnumber()
{
  return "X" + R.nextInt(10000);
}

public static String genInvalid()
{
  return "-" + R.nextInt(10000);
}

public static String genValid()
{
  while(true)
  {
    String s = Integer.toString(R.nextInt(100000-10)+11);
    if (s.charAt(0) == '3')
      return s;
  }
}

static String[] arr = new String[100002];
public static void generateDataset1()
{
  initRand();
  for (int i = 0; i < arr.length; i++)
    arr[i] = genValid();
}

public static void generateDataset2()
{
  initRand();
  for (int i = 0; i < arr.length; i+=2)
  {
    arr[i] = genValid();
    arr[i+1] = genInvalid();
  }
}

public static void generateDataset3()
{
  initRand();
  for (int i = 0; i < arr.length; i+=3)
  {
    arr[i] = genValid();
    arr[i+1] = genInvalid();
    arr[i+2] = genNonnumber();
  }
}

public static boolean checkInteger2(String testInteger)
{
  for (int i = 0; i < testInteger.length(); i++)
    if (!Character.isDigit(testInteger.charAt(i)))
      return false;
  try
  {
    Integer theInteger = new Integer(testInteger);//fails if not  a vaild number/integer
    return
      (theInteger.toString() != "") && //not empty
      (theInteger.intValue() > 10) && //greater than ten
      ((theInteger.intValue() >= 2) && (theInteger.intValue() <= 100000)) && //2>=X<=100000
      (theInteger.toString().charAt(0) == '3'); //first digit = 3               
  }
  catch (NumberFormatException err)
  {
    return false;
  }     
}

public static void test7(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset1();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger2(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger2 " + time);
}

public static void test8(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset2();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger2(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger2 " + time);
}

public static void test9(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset3();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger2(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger2 " + time);
}

public static boolean checkInteger3(String testInteger)
{
  try
  {
    if (testInteger.equals("")) return false;
    if (testInteger.charAt(0) != '3') return false;
    Integer theInteger = new Integer(testInteger);//fails if not  a number
    return
      (theInteger.intValue() > 29) &&
      (theInteger.intValue() <= 40000);
  }
  catch (NumberFormatException err)
  {
    return false;
  }     
}

public static void test10(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset1();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger3(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger3 " + time);
}

public static void test11(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset2();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger3(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger3 " + time);
}

public static void test12(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset3();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger3(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger3 " + time);
}

public static boolean checkInteger4(String testInteger)
{
  for (int i = 0; i < testInteger.length(); i++)
    if (!Character.isDigit(testInteger.charAt(i)))
      return false;
  try
  {
    Integer theInteger = new Integer(testInteger);//fails if not  a number
    return
      (testInteger != "") && //not empty
      (theInteger.intValue() > 10) && //greater than ten
      ((theInteger.intValue() >= 2) && 
           (theInteger.intValue() <= 100000)) && //2>=X<=100000
      (testInteger.charAt(0) == '3'); //first digit is 3               
  }
  catch (NumberFormatException err)
  {
    return false;
  }     
}

public static void test13(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset1();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger4(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger4 " + time);
}

public static void test14(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset2();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger4(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger4 " + time);
}

public static void test15(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset3();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger4(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger4 " + time);
}

public static boolean checkInteger5(String testInteger)
{
  if (testInteger.equals("")) return false;
  if (testInteger.charAt(0) != '3') return false;
  for (int i = 1; i < testInteger.length(); i++)
    if (!Character.isDigit(testInteger.charAt(i)))
      return false;
  try
  {
    Integer theInteger = new Integer(testInteger);//fails if not  a number
    return
      (theInteger.intValue() > 29) &&
      (theInteger.intValue() <= 40000);
  }
  catch (NumberFormatException err)
  {
    return false;
  }     
}

public static void test16(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset1();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger5(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger5 " + time);
}

public static void test17(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset2();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger5(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger0 " + time);
}

public static void test18(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset3();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger5(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger5 " + time);
}

public static boolean checkInteger6(String testInteger)
{
  if (testInteger.equals("")) return false;
  if (testInteger.charAt(0) != '3') return false;
  //The character for digit 0 is (char) 48, etc.
  int val = testInteger.charAt(0) - 48;
  for (int i = 1; i < testInteger.length(); i++)
    if (Character.isDigit(testInteger.charAt(i)))
      val = (val*10) + testInteger.charAt(i) - 48;
    else
      return false;
  try
  {
    Integer theInteger = new Integer(val);//fails if not  a number
    return
      (theInteger.intValue() > 29) &&
      (theInteger.intValue() <= 40000);
  }
  catch (NumberFormatException err)
  {
    return false;
  }     
}

public static void test19(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset1();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger6(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger6 " + time);
}

public static void test20(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset2();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger6(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger6 " + time);
}

public static void test21(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset3();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger6(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger6 " + time);
}

public static boolean checkInteger7(String testInteger)
{
  if (testInteger.length() == 0) return false;
  if (testInteger.charAt(0) != '3') return false;
  //The character for digit 0 is (char) 48, etc.
  int val = testInteger.charAt(0) - 48;
  for (int i = 1; i < testInteger.length(); i++)
    if (Character.isDigit(testInteger.charAt(i)))
      val = (val*10) + testInteger.charAt(i) - 48;
    else
      return false;
  return
      (val > 29) &&
      (val <= 40000);
}

public static void test22(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset1();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger7(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger7 " + time);
}

public static void test23(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset2();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger7(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger7 " + time);
}

public static void test24(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset3();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger7(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger7 " + time);
}

public static boolean checkInteger8(String testInteger)
{
  int length;
  //integer between 30 and 39999, so string length
  //must be 2 to 5 digits
  if ( ( (length = testInteger.length()) < 2) ||
       (  length > 5) )
    return false;

  //first digit must be '3'
  if (testInteger.charAt(0) != '3') return false;

  //Now we know it is valid if all chars are digits
  switch(length)
  {
    case 5:
     if (!Character.isDigit(testInteger.charAt(4))) return false;
    case 4:
     if (!Character.isDigit(testInteger.charAt(3))) return false;
    case 3:
     if (!Character.isDigit(testInteger.charAt(2))) return false;
    case 2:
     if (!Character.isDigit(testInteger.charAt(1))) return false;
  }
  return true;
}

public static void test25(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset1();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger8(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger8 " + time);
}

public static void test26(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset2();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger8(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger8 " + time);
}

public static void test27(int repeat, boolean[] b)
{
  System.out.println("Generating");
  generateDataset3();
  System.out.println("Timing");
  long time = System.currentTimeMillis();
  for (int j = 0; j < repeat; j++)
  {
    int offset = j*arr.length;
    for (int i = 0; i < arr.length; i++)
    {
      b[i+offset] = checkInteger8(arr[i]);
    }
  }
  time = System.currentTimeMillis() - time;
  System.out.println("checkInteger8 " + time);
}

}
