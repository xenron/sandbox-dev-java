package tuning.exception;

public class VariableTest
{
static	byte b;
static	short s;
static	char c;
static	int i;
static	long l;
static	float f;
static	double d;
static	boolean bool;
static	Object o;
static	int[] arr = new int[50];

    public static void main(String[] args)
    {
        int REPEAT = 50000000;

byte b1 = 3;
byte b2 = 5;
byte b3 = b1 + b2;


	VariableTest[] t = {new VariableTest()};
        test1(t, REPEAT, (byte) 33);
        test2(t, REPEAT, (short) 33);
        test3(t, REPEAT, (char) 33);
        test4(t, REPEAT, (int) 33);
        test5(t, REPEAT, (long) 33);
        test6(t, REPEAT, (float) 33);
        test7(t, REPEAT, (double) 33);
        test8(t, REPEAT, true);
        test9(t, REPEAT, new Object());
        testa(t, REPEAT, 33);

    }

    public static void test1(VariableTest[] t, int repeat, byte arg)
    {
        long time = System.currentTimeMillis();
	byte n;
	for (int i = repeat; i > 0; i--)
	  t[0].b = arg;
        time = System.currentTimeMillis() - time;
        System.out.println("byte took " + time);
    }

    public static void test2(VariableTest[] t, int repeat, short arg)
    {
        long time = System.currentTimeMillis();
	short n;
	for (int i = repeat; i > 0; i--)
	  t[0].s = arg;
        time = System.currentTimeMillis() - time;
        System.out.println("short took " + time);
    }

    public static void test3(VariableTest[] t, int repeat, char arg)
    {
        long time = System.currentTimeMillis();
	char n;
	for (int i = repeat; i > 0; i--)
	  t[0].c = arg;
        time = System.currentTimeMillis() - time;
        System.out.println("char took " + time);
    }

    public static void test4(VariableTest[] t, int repeat, int arg)
    {
        long time = System.currentTimeMillis();
	int n;
	for (int i = repeat; i > 0; i--)
	  t[0].i = arg;
        time = System.currentTimeMillis() - time;
        System.out.println("int took " + time);
    }

    public static void test5(VariableTest[] t, int repeat, long arg)
    {
        long time = System.currentTimeMillis();
	long n;
	for (int i = repeat; i > 0; i--)
	  t[0].l = arg;
        time = System.currentTimeMillis() - time;
        System.out.println("long took " + time);
    }

    public static void test6(VariableTest[] t, int repeat, float arg)
    {
        long time = System.currentTimeMillis();
	float n;
	for (int i = repeat; i > 0; i--)
	  t[0].f = arg;
        time = System.currentTimeMillis() - time;
        System.out.println("float took " + time);
    }

    public static void test7(VariableTest[] t, int repeat, double arg)
    {
        long time = System.currentTimeMillis();
	double n;
	for (int i = repeat; i > 0; i--)
	  t[0].d = arg;
        time = System.currentTimeMillis() - time;
        System.out.println("double took " + time);
    }

    public static void test8(VariableTest[] t, int repeat, boolean arg)
    {
        long time = System.currentTimeMillis();
	boolean n;
	for (int i = repeat; i > 0; i--)
	  t[0].bool = arg;
        time = System.currentTimeMillis() - time;
        System.out.println("boolean took " + time);
    }

    public static void test9(VariableTest[] t, int repeat, Object arg)
    {
        long time = System.currentTimeMillis();
	boolean n;
	for (int i = repeat; i > 0; i--)
	  t[0].o = arg;
        time = System.currentTimeMillis() - time;
        System.out.println("Object took " + time);
    }

    public static void testa(VariableTest[] t, int repeat, int arg)
    {
        long time = System.currentTimeMillis();
	boolean n;
	int j;
	for (int i = repeat/50; i > 0; i--)
	 for (j = 49; j >= 0; j--)
	  t[0].arr[j] = arg;
        time = System.currentTimeMillis() - time;
        System.out.println("array took " + time);
    }

}
