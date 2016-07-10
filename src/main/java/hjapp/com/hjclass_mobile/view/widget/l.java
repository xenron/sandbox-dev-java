package hjapp.com.hjclass_mobile.view.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

final class l extends BaseAdapter
{
  private l(k paramk)
  {
  }

  public final int getCount()
  {
    return k.a(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return k.a(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    m localm;
    hjapp.com.hjclass_mobile.pkg_d.a locala;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(k.b(this.a)).inflate(2130903107, null);
      localm = new m(this, (byte)0);
      localm.a = ((TextView)paramView.findViewById(2131362028));
      paramView.setTag(localm);
      locala = (hjapp.com.hjclass_mobile.pkg_d.a)k.a(this.a).get(paramInt);
      if (!locala.c())
        break label124;
      localm.a.setTextColor(-1);
      localm.a.setBackgroundResource(2130837592);
    }
    while (true)
    {
      localm.a.setText(locala.b());
      return paramView;
      localm = (m)paramView.getTag();
      break;
      label124: localm.a.setTextColor(-16777216);
      localm.a.setBackgroundResource(2130837528);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     l
 * JD-Core Version:    0.6.2
 */