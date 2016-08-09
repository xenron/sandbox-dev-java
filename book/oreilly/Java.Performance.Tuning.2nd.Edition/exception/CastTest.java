package tuning.exception;

public class CastTest
{
    public static void main(String[] args)
    {

        Integer i = new Integer(3);
	Integer q = (Integer) i;
        System.out.println(q);

        int REPEAT = (args.length == 0) ? 500000000 : Integer.parseInt(args[0]);
	Integer res;
        long time = System.currentTimeMillis();
        for (int j = REPEAT; j > 0 ; j--)
            res = test1(i);
        time = System.currentTimeMillis() - time;
        System.out.println("test1(i) took " + time);

        time = System.currentTimeMillis();
        for (int j = REPEAT; j > 0 ; j--)
            res = test2(i);
        time = System.currentTimeMillis() - time;
        System.out.println("test2(i) took " + time);

        time = System.currentTimeMillis();
        for (int j = REPEAT; j > 0 ; j--)
            res = test2(i);
        time = System.currentTimeMillis() - time;
        System.out.println("test2(i) took " + time);

        time = System.currentTimeMillis();
        for (int j = REPEAT; j > 0 ; j--)
            res = test1(i);
        time = System.currentTimeMillis() - time;
        System.out.println("test1(i) took " + time);
    }

    public static Integer test1(Object o)
    {
        Integer i = (Integer) o;
        return i;
    }

    public static Integer test2(Integer o)
    {
        Integer i = (Integer) o;
        return i;
    }
}
