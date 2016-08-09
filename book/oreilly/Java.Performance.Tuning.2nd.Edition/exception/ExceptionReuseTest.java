package tuning.exception;

public class ExceptionReuseTest
{
    static Exception REUSED = new Exception();
    public static void main(String[] args)
    {
        boolean res;

        REUSED.printStackTrace();;

        int REPEAT = (args.length == 0) ? 500000 : Integer.parseInt(args[0]);
        long time = System.currentTimeMillis();
        for (int j = REPEAT; j > 0 ; j--)
            res = test1();
        time = System.currentTimeMillis() - time;
        System.out.println("test1() took " + time);

        time = System.currentTimeMillis();
        for (int j = REPEAT; j > 0 ; j--)
            res = test2();
        time = System.currentTimeMillis() - time;
        System.out.println("test2() took " + time);

        REUSED.printStackTrace();;
    }

    public static boolean test1()
    {
        try
        {
            throw new Exception();
        }
        catch (Exception e)
        {
            return true;
        }
    }

    public static boolean test2()
    {
        try
        {
            throw REUSED;
        }
        catch (Exception e)
        {
            return true;
        }
    }

}
