package hjapp.com.hjclass_mobile.pkg_h;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public final class v
{
  private final HashMap a;
  private final HashMap b = new HashMap();
  private ReferenceQueue c = new ReferenceQueue();

  public v(int paramInt)
  {
    this.a = new w(this, paramInt);
  }

  private void a()
  {
    for (x localx = (x)this.c.poll(); localx != null; localx = (x)this.c.poll())
      this.b.remove(localx.a);
  }

  public final Object a(Object paramObject)
  {
    try
    {
      a();
      Object localObject2 = this.a.get(paramObject);
      Object localObject3 = localObject2;
      if (localObject3 != null);
      while (true)
      {
        return localObject3;
        x localx = (x)this.b.get(paramObject);
        if (localx == null)
        {
          localObject3 = null;
        }
        else
        {
          Object localObject4 = localx.get();
          localObject3 = localObject4;
        }
      }
    }
    finally
    {
    }
  }

  public final Object a(Object paramObject1, Object paramObject2)
  {
    try
    {
      a();
      this.a.put(paramObject1, paramObject2);
      x localx = (x)this.b.put(paramObject1, new x(paramObject1, paramObject2, this.c));
      if (localx == null);
      Object localObject2;
      for (Object localObject3 = null; ; localObject3 = localObject2)
      {
        return localObject3;
        localObject2 = localx.get();
      }
    }
    finally
    {
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     v
 * JD-Core Version:    0.6.2
 */