// Decompiled by JAD v1.5.5.1. Copyright 1997-98 Pavel Kouznetsov.
// JAD Home Page:      http://web.unicom.com.cy/~kpd/jad.html
// Decompiler options: packimports(100) fieldsfirst 
// Source File Name:   B.java

package tuning.compile;

import java.io.PrintStream;

// Referenced classes of package tuning.compile:
//            A

public class B
{

    public static final String VALUE1 = "hi: 90";
    static int VALUE2 = 33;

    public B()
    {
    }

    static int foo2()
    {
        return A.foo1();
    }

    static int foo3()
    {
        return 55;
    }

}
