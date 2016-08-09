package tuning.reuse;

import java.util.Vector;

public class VectorPoolManager
{

  Vector[] pool;
  boolean[] inUse;
  public VectorPoolManager(int initialPoolSize)
  {
    pool = new Vector[initialPoolSize];
    inUse = new boolean[initialPoolSize];
    for (int i = pool.length-1; i>=0; i--)
    {
      pool[i] = new Vector();
      inUse[i] = false;
    }
  }

  public synchronized Vector getVector()
  {
    for (int i = inUse.length-1; i >= 0; i--)
      if (!inUse[i])
      {
        inUse[i] = true;
        return pool[i];
      }

    //If we got here, then all the Vectors are in use. We will increase the number in our
    //pool by 10 (arbitrary value for illustration purposes).
    boolean[] old_inUse = inUse;
    inUse = new boolean[old_inUse.length+10];
    System.arraycopy(old_inUse, 0, inUse, 0, old_inUse.length);

    Vector[] old_pool = pool;
    pool = new Vector[old_pool.length+10];
    System.arraycopy(old_pool, 0, pool, 0, old_pool.length);

    for (int i = old_pool.length; i < pool.length; i++)
    {
      pool[i] = new Vector();
      inUse[i] = false;
    }
    inUse[pool.length-1] = true;
    return pool[pool.length-1];
  }

  public synchronized void returnVector(Vector v)
  {
    for (int i = inUse.length-1; i >= 0; i--)
      if (pool[i] == v)
      {
        inUse[i] = false;
	v.setSize(0);
        return;
      }
    throw new RuntimeException("Vector was not obtained from the pool: " + v);
  }
}
