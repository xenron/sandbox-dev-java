package hjapp.com.hjclass_mobile.pkg_b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public final class u extends BaseAdapter
{
  private Context a;
  private List b;

  public u(Context paramContext, List paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }

  public final int getCount()
  {
    return this.b.size();
  }

  public final Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    v localv;
    if (paramView == null)
    {
      localv = new v(this, (byte)0);
      paramView = LayoutInflater.from(this.a).inflate(2130903097, null);
      localv.a = ((ImageView)paramView.findViewById(2131362004));
      localv.b = ((TextView)paramView.findViewById(2131362005));
      localv.c = ((TextView)paramView.findViewById(2131362006));
      paramView.setTag(localv);
    }
    while (true)
    {
      hjapp.com.hjclass_mobile.pkg_d.v localv1 = (hjapp.com.hjclass_mobile.pkg_d.v)this.b.get(paramInt);
      localv.a.setImageResource(localv1.b());
      localv.b.setText(localv1.a());
      if (!TextUtils.isEmpty(localv1.c()))
        localv.c.setText(localv1.c());
      return paramView;
      localv = (v)paramView.getTag();
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     u
 * JD-Core Version:    0.6.2
 */