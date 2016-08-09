package tuning.reuse;

import java.util.*;
import java.lang.ref.*;

public class Test
{
  public static void main(String[] args)
  {
    try
    {
      Integer ic = null;
      int REPEAT = args.length > 0 ? Integer.parseInt(args[0]) : 10000000;

      //Hang on to the Integer objects from 3 to 7
      //so that they cannot be garbage collected
      Integer i3 = getCanonicalInteger(3);
      Integer i4 = getCanonicalInteger(4);
      Integer i5 = getCanonicalInteger(5);
      Integer i6 = getCanonicalInteger(6);
      Integer i7 = getCanonicalInteger(7);

      //Loop through getting canonical integers until there is not
      //enough space, and the garbage collector reclaims some.
      for (int i = 0; i < REPEAT; i++)
        ic = getCanonicalInteger(i);

      //Now just re-access the first 10 integers (0 to 9) and
      //the 0, 1, 2, 8, and 9 integers will need to be reset in
      //the access method since they will have been reclaimed
      for (int i = 0; i < 10; i++)
        ic = getCanonicalInteger(i);
      System.out.println(ic);
    }
    catch(Exception e){e.printStackTrace();}
  }

  private static Vector canonicalIntegers = new Vector();
  public static Integer getCanonicalInteger(int i)
  {
    //First make sure our collection is big enough
    if (i >= canonicalIntegers.size())
      canonicalIntegers.setSize(i+1);

    //Now access the canonical value.
    //This element contains null if the the value has never been set
    //or a weak reference that may have been garbage collected
    WeakReference ref = (WeakReference) canonicalIntegers.elementAt(i);
    Integer canonical_i;

    if (ref == null)
    {
      //never been set, so create and set it now
      canonical_i = new Integer(i);
      canonicalIntegers.setElementAt(new WeakReference(canonical_i), i);
    }
    else if( (canonical_i = (Integer) ref.get()) == null)
    {
      //has been set, but was garbage collected, so recreate and set it now
      //Include a print to see that we are resetting the Integer
      System.out.println("Resetting integer " + i);
      canonical_i = new Integer(i);
      canonicalIntegers.setElementAt(new WeakReference(canonical_i), i);
    }
    //else clause not needed, since the alternative is that the weak ref was
    //present and not garbage collected, so we now have our canonical integer

    return canonical_i;
  }
}
