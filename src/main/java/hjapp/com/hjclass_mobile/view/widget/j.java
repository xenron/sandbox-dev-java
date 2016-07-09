package hjapp.com.hjclass_mobile.view.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public final class j extends Builder
{
  private final b a;

  public j(Context paramContext)
  {
    super(paramContext);
    this.a = new b(paramContext);
  }

  public final j a(CharSequence paramCharSequence)
  {
    this.a.g = paramCharSequence;
    return this;
  }

  public final j a(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.a.h = paramCharSequence;
    this.a.i = paramOnClickListener;
    return this;
  }

  public final j b(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.a.l = paramCharSequence;
    this.a.m = paramOnClickListener;
    return this;
  }

  public final AlertDialog create()
  {
    i locali = new i(this.a.a);
    b localb = this.a;
    HuzAlertController localHuzAlertController = i.a(locali);
    HuzAlertController.RecycleListView localRecycleListView;
    Object localObject;
    if (localb.f != null)
    {
      localHuzAlertController.a(localb.f);
      if (localb.g != null)
        localHuzAlertController.b(localb.g);
      if (localb.h != null)
        localHuzAlertController.a(-1, localb.h, localb.i, null);
      if (localb.j != null)
        localHuzAlertController.a(-2, localb.j, localb.k, null);
      if (localb.l != null)
        localHuzAlertController.a(-3, localb.l, localb.m, null);
      if (localb.H)
        localHuzAlertController.a(true);
      if ((localb.q != null) || (localb.E != null) || (localb.r != null))
      {
        localRecycleListView = (HuzAlertController.RecycleListView)localb.b.inflate(2130903085, null);
        if (!localb.A)
          break label450;
        if (localb.E != null)
          break label427;
        localObject = new c(localb, localb.a, localb.q, localRecycleListView);
        label202: if (localb.J != null);
        HuzAlertController.a(localHuzAlertController, (ListAdapter)localObject);
        HuzAlertController.a(localHuzAlertController, localb.C);
        if (localb.s == null)
          break label569;
        localRecycleListView.setOnItemClickListener(new e(localb, localHuzAlertController));
        label251: if (localb.I != null)
          localRecycleListView.setOnItemSelectedListener(localb.I);
        if (!localb.B)
          break label595;
        localRecycleListView.setChoiceMode(1);
        label280: localRecycleListView.a = localb.K;
        HuzAlertController.a(localHuzAlertController, localRecycleListView);
      }
      if (localb.t != null)
      {
        if (!localb.y)
          break label611;
        localHuzAlertController.a(localb.t, localb.u, localb.v, localb.w, localb.x);
      }
    }
    while (true)
    {
      locali.setCancelable(this.a.n);
      locali.setOnCancelListener(this.a.o);
      if (this.a.p != null)
        locali.setOnKeyListener(this.a.p);
      return locali;
      if (localb.e != null)
        localHuzAlertController.a(localb.e);
      if (localb.d != null)
        localHuzAlertController.a(localb.d);
      if (localb.c < 0)
        break;
      localHuzAlertController.a(localb.c);
      break;
      label427: localObject = new d(localb, localb.a, localb.E, localRecycleListView);
      break label202;
      label450: int i;
      if (localb.B)
        i = 2130903088;
      while (true)
        if (localb.E == null)
        {
          if (localb.r != null)
          {
            localObject = localb.r;
            break;
            i = 2130903086;
            continue;
          }
          localObject = new ArrayAdapter(localb.a, i, 16908308, localb.q);
          break;
        }
      Context localContext = localb.a;
      Cursor localCursor = localb.E;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localb.F;
      localObject = new SimpleCursorAdapter(localContext, i, localCursor, arrayOfString, new int[] { 16908308 });
      break label202;
      label569: if (localb.D == null)
        break label251;
      localRecycleListView.setOnItemClickListener(new f(localb, localRecycleListView, localHuzAlertController));
      break label251;
      label595: if (!localb.A)
        break label280;
      localRecycleListView.setChoiceMode(2);
      break label280;
      label611: localHuzAlertController.b(localb.t);
    }
  }

  public final AlertDialog show()
  {
    AlertDialog localAlertDialog = create();
    localAlertDialog.show();
    return localAlertDialog;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     j
 * JD-Core Version:    0.6.2
 */