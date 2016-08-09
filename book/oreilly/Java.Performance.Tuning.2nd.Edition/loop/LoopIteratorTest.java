package tuning.loop;

public class LoopIteratorTest
{
public static void arrayAccessTest(int Repeat)
{
	double count = 0.0;
	double[] countArr = {0.0};
	long time = System.currentTimeMillis();
	for(int i = 0; i < Repeat; i++)
	{
		//System.out.println(i);
		countArr[0]+=10;
	}
	System.out.println("Time taken for array element:      " + (System.currentTimeMillis() - time) + " for count " + countArr[0]);

	countArr[0] = 0.0;
	count = countArr[0];
	time = System.currentTimeMillis();
	for(int i = 0; i < Repeat; i++)
	{
		//System.out.println(i);
		count+=10;
	}
	countArr[0]=count;
	System.out.println("Time taken for temporary variable: " + (System.currentTimeMillis() - time) + " for count " + countArr[0]);
}
public static void intTest(int Repeat)
{
	double count = 0.0;
	long time = System.currentTimeMillis();
	for(int i = 0; i < Repeat; i++)
	{
		count+=10;
	}
	System.out.println("Time taken for int    loop variable: " + (System.currentTimeMillis() - time) + " for count " + count);

	count = 0.0;
	time = System.currentTimeMillis();
	for(long i = 0; i < Repeat; i++)
	{
		count+=10;
	}
	System.out.println("Time taken for long   loop variable: " + (System.currentTimeMillis() - time) + " for count " + count);

	count = 0.0;
	time = System.currentTimeMillis();
	for(double i = 0; i < Repeat; i++)
	{
		count+=10;
	}
	System.out.println("Time taken for double loop variable: " + (System.currentTimeMillis() - time) + " for count " + count);
}
public static void iteratorTest(int Repeat)
{
	double count = 0.0;
	long time = System.currentTimeMillis();
	for(int i = Repeat-1; i >= 0; i--)
	{
		//System.out.println(i);
		count+=10;
	}
	System.out.println("Time taken for 'for(int i = Repeat-1; i >= 0; i--)': " + (System.currentTimeMillis() - time) + " for count " + count);

	count = 0;
	time = System.currentTimeMillis();
	for(int i = Repeat; --i >= 0 ; )
	{
		//System.out.println(i);
		count+=10;
	}
	System.out.println("Time taken for 'for(int i = Repeat; --i >= 0 ; )':   " + (System.currentTimeMillis() - time) + " for count " + count);

	count = 0;
	time = System.currentTimeMillis();
	for(int i = 0; i < Repeat; i++)
	{
		//System.out.println(i);
		count+=10;
	}
	System.out.println("Time taken for 'for(int i = 0; i < Repeat; i++)':    " + (System.currentTimeMillis() - time) + " for count " + count);

	count = 0;
	time = System.currentTimeMillis();
	for(int i = 0; i < Repeat; i++)
	{
		//System.out.println(i);
		count+=10;
	}
	System.out.println("Time taken for 'for(int i = 0; i < Repeat; i++)':    " + (System.currentTimeMillis() - time) + " for count " + count);

	count = 0;
	time = System.currentTimeMillis();
	for(int i = Repeat-1; i >= 0; i--)
	{
		//System.out.println(i);
		count+=10;
	}
	System.out.println("Time taken for 'for(int i = Repeat-1; i >= 0; i--)': " + (System.currentTimeMillis() - time) + " for count " + count);

	count = 0;
	time = System.currentTimeMillis();
	for(int i = Repeat; --i >= 0 ; )
	{
		//System.out.println(i);
		count+=10;
	}
	System.out.println("Time taken for 'for(int i = Repeat; --i >= 0 ; )':   " + (System.currentTimeMillis() - time) + " for count " + count);
}
public static void main(String args[])
{
	int Repeat = 100000000;
        if (args.length == 1)
          Repeat = Integer.parseInt(args[0]);
	iteratorTest(Repeat);
	arrayAccessTest(Repeat);
	intTest(Repeat);
}
}