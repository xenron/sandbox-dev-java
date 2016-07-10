package hjapp.com.hjclass_mobile.view.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import hjapp.com.hjclass_mobile.pkg_d.a;
import java.util.ArrayList;
import java.util.List;

public final class k
{
  l a = null;
  private List b;
  private Context c;
  private PopupWindow d;
  private ListView e;

  public k(Context paramContext)
  {
    this.c = paramContext;
    this.b = new ArrayList(3);
    View localView = LayoutInflater.from(paramContext).inflate(2130903108, null);
    this.e = ((ListView)localView.findViewById(2131362030));
    this.a = new l(this, (byte)0);
    this.e.setAdapter(this.a);
    this.e.setFocusableInTouchMode(true);
    this.e.setFocusable(true);
    this.d = new PopupWindow(localView, paramContext.getResources().getDimensionPixelSize(2131296256), -2);
    this.d.setBackgroundDrawable(new BitmapDrawable());
  }

  public final List a()
  {
    return this.b;
  }

  public final void a(View paramView)
  {
    this.d.showAsDropDown(paramView, 0, this.c.getResources().getDimensionPixelSize(2131296257));
    this.d.setFocusable(true);
    this.d.setOutsideTouchable(true);
    this.d.update();
  }

  public final void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.e.setOnItemClickListener(paramOnItemClickListener);
  }

  public final void a(List paramList)
  {
    this.b = paramList;
  }

  public final void a(a[] paramArrayOfa)
  {
    int i = paramArrayOfa.length;
    for (int j = 0; j < i; j++)
    {
      a locala = paramArrayOfa[j];
      this.b.add(locala);
    }
  }

  public final void b()
  {
    this.a.notifyDataSetChanged();
  }

  public final void c()
  {
    this.d.dismiss();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     k
 * JD-Core Version:    0.6.2
 */