package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import hjapp.com.hjclass_mobile.HJApplication;
import hjapp.com.hjclass_mobile.c.b;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import hjapp.com.hjclass_mobile.d.z;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public final class q extends LinearLayout
  implements b, hjapp.com.hjclass_mobile.c.l
{
  private hjapp.com.hjclass_mobile.d.h a = null;
  private LinearLayout b = null;
  private Hashtable c = null;
  private Boolean d = Boolean.valueOf(false);
  private String e = null;
  private float f;
  private float g;
  private float h;

  public q(Context paramContext)
  {
    super(paramContext);
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903065, null);
    addView(localView);
    this.b = ((LinearLayout)localView.findViewById(2131361922));
  }

  public final void a()
  {
    removeAllViews();
  }

  public final void a(hjapp.com.hjclass_mobile.d.l paraml)
  {
    if (paraml.j() != null)
    {
      this.a = paraml.j();
      List localList = paraml.j().a();
      if (localList != null)
      {
        int i = localList.size();
        int j = 0;
        if (j < i)
        {
          hjapp.com.hjclass_mobile.d.g localg = (hjapp.com.hjclass_mobile.d.g)localList.get(j);
          af localaf = new af(getContext());
          localaf.a(localg.b());
          localaf.b(Integer.parseInt(localg.c()));
          StringBuilder localStringBuilder = new StringBuilder();
          if (localg.d() != null)
            localStringBuilder.append(j + 1 + "、" + hjapp.com.hjclass_mobile.h.z.e(localg.d()) + "\n");
          if (localg.e() != null)
            localStringBuilder.append(localg.e());
          localaf.a(localStringBuilder.toString());
          if (localg.g() != null)
            localaf.a(localg.g(), localg.a(), localg.a(), false);
          while (true)
          {
            if (localg.f() != null)
              localaf.b(localg.f());
            this.b.addView(localaf);
            j++;
            break;
            if (localg.h() == null)
              localaf.a(localg.a(), localg.a(), null, true);
          }
        }
      }
    }
  }

  public final void b()
  {
    if (this.c == null)
      this.c = ((HJApplication)getContext().getApplicationContext()).d();
    int i = this.b.getChildCount();
    int j = 0;
    if (j < i)
    {
      af localaf = (af)this.b.getChildAt(j);
      z localz2;
      if (localaf != null)
      {
        Enumeration localEnumeration = this.c.keys();
        while (localEnumeration.hasMoreElements())
        {
          Integer localInteger = (Integer)localEnumeration.nextElement();
          localz2 = (z)this.c.get(localInteger);
          if ((localz2 != null) && (localz2.a() == localaf.b()))
          {
            if ((localaf.c() != Integer.parseInt("3")) && (localaf.c() != Integer.parseInt("1")))
              break label181;
            if (localaf.a() != null)
              localaf.a(localaf.a(), localaf.d(), localz2.b(), false);
          }
        }
      }
      while (true)
      {
        j++;
        break;
        label181: if (localaf.c() == Integer.parseInt("2"))
          localaf.a(localaf.d(), localaf.d(), localz2.b(), true);
      }
    }
    Toast.makeText(getContext(), getContext().getString(2131493157), 0).show();
    Document localDocument = DocumentHelper.createDocument();
    Element localElement1 = localDocument.addElement("result");
    Set localSet = this.c.keySet();
    Boolean localBoolean1 = Boolean.valueOf(false);
    Iterator localIterator = localSet.iterator();
    Boolean localBoolean2 = localBoolean1;
    while (localIterator.hasNext())
    {
      z localz1 = (z)this.c.get(localIterator.next());
      if (!localz1.f().booleanValue())
        localBoolean2 = Boolean.valueOf(true);
      Element localElement2 = localElement1.addElement("exam");
      localElement2.addAttribute("p", String.valueOf(localz1.d()));
      localElement2.addAttribute("st", String.valueOf(localz1.c()));
      localElement2.addAttribute("id", String.valueOf(localz1.a()));
      localElement2.addAttribute("score", String.valueOf(localz1.e()));
      localElement2.addElement("ans").addCDATA(localz1.b());
    }
    if (localBoolean2.booleanValue());
    for (String str = localDocument.asXML(); ; str = null)
    {
      this.e = str;
      this.d = Boolean.valueOf(true);
      return;
    }
  }

  public final String c()
  {
    if (this.d.booleanValue())
      return this.e;
    return null;
  }

  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    do
    {
      while (true)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.f = 0.0F;
        this.g = paramMotionEvent.getRawY();
        continue;
        this.h = paramMotionEvent.getRawY();
      }
      this.f = Math.abs(this.h - this.g);
    }
    while (this.f >= 5.0F);
    Intent localIntent = new Intent("show_cmd");
    getContext().sendBroadcast(localIntent);
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     q
 * JD-Core Version:    0.6.2
 */