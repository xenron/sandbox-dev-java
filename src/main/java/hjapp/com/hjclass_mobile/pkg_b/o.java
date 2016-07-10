package hjapp.com.hjclass_mobile.pkg_b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.pkg_d.n;

import java.util.Date;
import java.util.List;

public final class o extends BaseAdapter
{
  private Context a;
  private List b;
  private Bitmap c;
  private Bitmap d;

  public o(Context paramContext, List paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = BitmapFactory.decodeResource(paramContext.getResources(), 2130837774);
    this.d = BitmapFactory.decodeResource(paramContext.getResources(), 2130837598);
  }

  public final int getCount()
  {
    List localList = this.b;
    if ((localList == null) || (localList.size() == 0));
    for (int i = 1; i != 0; i = 0)
      return 0;
    return this.b.size();
  }

  public final Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return Integer.parseInt(((n)this.b.get(paramInt)).a());
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    p localp2;
    n localn;
    Date localDate;
    long l;
    String str;
    if (paramView == null)
    {
      p localp1 = new p(this, (byte)0);
      paramView = LayoutInflater.from(this.a).inflate(2130903083, null);
      localp1.a = ((ImageView)paramView.findViewById(2131361954));
      localp1.b = ((TextView)paramView.findViewById(2131361939));
      localp1.c = ((TextView)paramView.findViewById(2131361957));
      localp1.d = ((ImageView)paramView.findViewById(2131361956));
      localp1.f = ((TextView)paramView.findViewById(2131361958));
      localp1.e = ((ImageView)paramView.findViewById(2131361959));
      localp1.g = ((TextView)paramView.findViewById(2131361960));
      paramView.setTag(localp1);
      localp2 = localp1;
      localn = (n)this.b.get(paramInt);
      if (localn != null)
      {
        localp2.a.setImageResource(2130837598);
        new h().a(((n)this.b.get(paramInt)).g(), localp2.a, this.d);
        localp2.b.setText(localn.i());
        TextView localTextView = localp2.c;
        localDate = a.a(localn.b(), "yyyy/MM/dd HH:mm:ss");
        l = new Date().getTime() - localDate.getTime();
        if ((l >= 3600000L) || (l <= 60000L))
          break label436;
        str = l / 1000L / 60L + "分钟前";
        label300: localTextView.setText(str);
        if (hjapp.com.hjclass_mobile.pkg_h.y.c(localn.f()))
          break label519;
        localp2.e.setVisibility(0);
        localp2.d.setVisibility(0);
        new h().a(((n)this.b.get(paramInt)).f(), localp2.e, this.c);
      }
    }
    while (true)
    {
      localp2.f.setText(localn.c());
      localp2.g.setText(this.a.getText(2131492941) + localn.e());
      return paramView;
      localp2 = (p)paramView.getTag();
      break;
      label436: if ((l >= 3600000L) && (l < 86400000L))
      {
        str = l / 1000L / 60L / 60L + "小时前";
        break label300;
      }
      if (l <= 60000L)
      {
        str = "刚刚";
        break label300;
      }
      str = a.a(localDate, "MM-dd HH:mm");
      break label300;
      label519: localp2.e.setVisibility(8);
      localp2.d.setVisibility(8);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     o
 * JD-Core Version:    0.6.2
 */