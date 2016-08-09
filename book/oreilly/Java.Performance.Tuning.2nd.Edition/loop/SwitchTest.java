package tuning.loop;

public class SwitchTest
{
  //Use a default size for the loop of 1 million iterations
  static int SIZE = 10000000;
  final static int[] RETURNS = {
    99, 55, -1, 6, 8, 12, 15, 29,
    11111, 12345, 6666, 9876, 12
  };


public static void main(String args[])
{
  //Allow an argument to set the size of the loop.
  if (args.length != 0)
    SIZE = Integer.parseInt(args[0]);
  main(SIZE);
  main(SIZE);
}

public static void main(int SIZE)
{

  int result = 0;
  //run test looking for default
  long time = System.currentTimeMillis();
  for (int i = SIZE; i >=0 ; i--)
    result += switch1(i);
  System.out.println("Switch1 took " + 
    (System.currentTimeMillis()-time) + " millis to get " + result);

  result = 0;
  time = System.currentTimeMillis();
  for (int i = SIZE; i >=0 ; i--)
    result += switch2(i);
  System.out.println("Switch2 took " + 
    (System.currentTimeMillis()-time) + " millis to get " + result);

  result = 0;
  time = System.currentTimeMillis();
  for (int i = SIZE; i >=0 ; i--)
    result += switch3(i);
  System.out.println("Switch3 took " + 
    (System.currentTimeMillis()-time) + " millis to get " + result);

  result = 0;
  time = System.currentTimeMillis();
  for (int i = SIZE; i >=0 ; i--)
    result += switch4(i);
  System.out.println("Switch4 took " + 
    (System.currentTimeMillis()-time) + " millis to get " + result);

  result = 0;
  time = System.currentTimeMillis();
  for (int i = SIZE; i >=0 ; i--)
    result += switch1(i%2==0 ? 7 : 8);
  System.out.println("Switch1 took " + 
    (System.currentTimeMillis()-time) + " millis to get " + result);

  result = 0;
  time = System.currentTimeMillis();
  for (int i = SIZE; i >=0 ; i--)
    result += switch2(i%2==0 ? 7 : 8);
  System.out.println("Switch2 took " + 
    (System.currentTimeMillis()-time) + " millis to get " + result);

  result = 0;
  time = System.currentTimeMillis();
  for (int i = SIZE; i >=0 ; i--)
    result += switch3(i%2==0 ? 7 : 8);
  System.out.println("Switch3 took " + 
    (System.currentTimeMillis()-time) + " millis to get " + result);

  result = 0;
  time = System.currentTimeMillis();
  for (int i = SIZE; i >=0 ; i--)
    result += switch4(i%2==0 ? 7 : 8);
  System.out.println("Switch4 took " + 
    (System.currentTimeMillis()-time) + " millis to get " + result);
}

public static int switch1(int i)
{
  switch(i)
  {
    case 318: return 99;
    case 320: return 55;
    case 323: return -1;
    case 14: return 6;
    case 5: return 8;
    case 123456: return 12;
    case 7: return 15;
    case 8: return 29;
    case 9: return 11111;
    case 123457: return 12345;
    case 112233: return 6666;
    case 112235: return 9876;
    case 112237: return 12;
    default: return -1;
  }
}
public static int switch4(int i)
{
  if (i < 1 || i > 13)
    return -1;
  else
    return RETURNS[i-1];
}
public static int switch2(int i)
{
  switch(i)
  {
    case 1: return 99;
    case 2: return 55;
    case 3: return -1;
    case 4: return 6;
    case 5: return 8;
    case 6: return 12;
    case 7: return 15;
    case 8: return 29;
    case 9: return 11111;
    case 10: return 12345;
    case 11: return 6666;
    case 12: return 9876;
    case 13: return 12;
    default: return -1;
  }
}
public static int switch3(int i)
{
  switch(i)
  {
    case 318: return 99;
    case 319: break;
    case 320: return 55;
    case 321: break;
    case 322: break;
    case 323: return -1;
  }
  switch(i)
  {
    case 5: return 8;
    case 6: break;
    case 7: return 15;
    case 8: return 29;
    case 9: return 11111;
    case 10: break;
    case 11: break;
    case 12: break;
    case 13: break;
    case 14: return 6;
  }
  switch(i)
  {
    case 112233: return 6666;
    case 112234: break;
    case 112235: return 9876;
    case 112236: break;
    case 112237: return 12;
  }
  switch(i)
  {
    case 123456: return 12;
    case 123457: return 12345;
    default: return -1;
  }
}
}
