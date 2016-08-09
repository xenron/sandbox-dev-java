package tuning.loop;

public class ExceptionDriven
{
  //Use a default size for the loop of 1 million iterations
  static int SIZE = 1000000;

public static void main(String args[])
{
  String argz[] = new String[args.length-1];
  if (args[0].equals("2nd"))
  {
    System.arraycopy(args,1,argz,0,argz.length);
    maintest(argz);
    maintest(argz);
  }
  else
  {
    maintest(args);
  }
}

public static void maintest(String args[])
{
  //Allow an argument to set the size of the loop.
  if (args.length != 0)
    SIZE = Integer.parseInt(args[0]);

  //Run the two tests twice each to ensure there were no initialization effects,
  //reversing the order on the second run to make sure one test does not affect the other.
  no_exception1(); with_exception1(); with_exception1(); no_exception1();
  
  //Execute the array assignment tests only if there is no second argument
  //to allow for large SIZE values on the first test which would give
  //out of memory errors in the second test.
  if (args.length > 1)
    return;
  no_exception2(); with_exception2(); with_exception2(); no_exception2();
  no_exception3(); with_exception3(); with_exception3(); no_exception3();  
}
public static void no_exception1()
{
  //Standard loop.
  int result = 0;
  long time = System.currentTimeMillis();
  for (int i = SIZE; i > 0 ; i--)
    result += SIZE/i;
  System.out.println("Division loop with no exceptions took " + 
    (System.currentTimeMillis()-time) + " milliseconds " + result);
}
public static void with_exception1()
{
  //Non-standard loop with no test for termination using the
  //ArithmeticException thrown at division by zero to terminate the loop.
  int result = 0;
  long time = System.currentTimeMillis();
  try
  {
  for (int i = SIZE; ; i--)
    result += SIZE/i;
  }
  catch (ArithmeticException e) {}
  System.out.println("Division loop with an exception took " + 
    (System.currentTimeMillis()-time) + " milliseconds " + result);
}
public static void no_exception2()
{
  //Create the array, get the time, and run the standard loop.
  int array[] = new int[SIZE];
  long time = System.currentTimeMillis();
  for (int i = 0; i < SIZE ; i++)
    array[i] = i;
  System.out.println("Assignment loop with no exceptions took " + 
    (System.currentTimeMillis()-time) + " milliseconds");

  //Garbage collect so that we don't run out of memory for the next test.
  //Set the array variable to null to allow the array instance to be garbage collected.
  array = null;
  System.gc();
  try{Thread.sleep(2000);}catch(InterruptedException e){}
  System.gc();
}
public static void with_exception2()
{
  //Create the array, get the time, and run a non-standard loop with no test for termination
  //using the ArrayIndexOutOfBoundsException to terminate the loop.
  int array[] = new int[SIZE];
  long time = System.currentTimeMillis();
  try
  {
  for (int i = 0; ; i++)
    array[i] = i;
  }
  catch (ArrayIndexOutOfBoundsException e) {}
  System.out.println("Assignment loop with an exception took " + 
    (System.currentTimeMillis()-time) + " milliseconds");

  //Garbage collect so that we don't run out of memory for the next test.
  //Set the array variable to null to allow the array instance to be garbage collected.
  array = null;
  System.gc();
  try{Thread.sleep(2000);}catch(InterruptedException e){}
  System.gc();
}
public static void no_exception3()
{
  //Create the Vector, get the time, and run the standard loop.
  java.util.Vector vector = new java.util.Vector(SIZE);
  vector.setSize(SIZE);
  java.util.Enumeration enum = vector.elements();
  Object nothing;
  long time = System.currentTimeMillis();
  for ( ; enum.hasMoreElements(); )
    nothing = enum.nextElement();
  System.out.println("Enumeration loop with no exceptions took " + 
    (System.currentTimeMillis()-time) + " milliseconds");

  //Garbage collect so that we don't run out of memory for the next test.
  //Need to set the variables to null to allow the instances to be garbage collectable.
  enum = null;
  vector = null;
  System.gc();
  try{Thread.sleep(2000);}catch(InterruptedException e){}
  System.gc();
}
public static void with_exception3()
{
  //Create the Vector, get the time, and run a non-standard loop with no termination test
  //using the java.util.NoSuchElementException to terminate the loop.
  java.util.Vector vector = new java.util.Vector(SIZE);
  vector.setSize(SIZE);
  java.util.Enumeration enum = vector.elements();
  Object nothing;
  long time = System.currentTimeMillis();
  try
  {
    for ( ; ; )
      nothing = enum.nextElement();
  }
  catch (java.util.NoSuchElementException e) {}
  System.out.println("Enumeration loop with an exception took " + 
    (System.currentTimeMillis()-time) + " milliseconds");

  //Garbage collect so that we don't run out of memory for the next test.
  //Need to set the variables to null to allow the instances to be garbage collectable.
  enum = null;
  vector = null;
  System.gc();
  try{Thread.sleep(2000);}catch(InterruptedException e){}
  System.gc();
}
}
