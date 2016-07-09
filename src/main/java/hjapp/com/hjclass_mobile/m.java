package hjapp.com.hjclass_mobile;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.d.p;

final class m extends BaseAdapter
{
  private m(HJAppActivity paramHJAppActivity)
  {
  }

  public final int getCount()
  {
    return HJAppActivity.c(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return HJAppActivity.c(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    l locall1;
    if (paramView == null)
    {
      locall1 = new l(this.a, (byte)0);
      paramView = LayoutInflater.from(this.a).inflate(2130903045, null);
      locall1.a = ((ImageView)paramView.findViewById(2131361820));
      locall1.b = ((TextView)paramView.findViewById(2131361821));
      locall1.c = ((TextView)paramView.findViewById(2131361822));
      paramView.setTag(locall1);
    }
    Bitmap localBitmap;
    for (l locall2 = locall1; ; locall2 = (l)paramView.getTag())
    {
      p localp = (p)HJAppActivity.c(this.a).get(paramInt);
      locall2.b.setText(localp.a());
      locall2.c.setText(localp.c());
      localBitmap = (Bitmap)HJAppActivity.f(this.a).a(Integer.valueOf(9888888 + paramInt));
      if (localBitmap != null)
        break;
      locall2.a.setImageBitmap(HJAppActivity.g(this.a));
      b.n localn = new b.n(this.a, locall2.a, 9888888 + paramInt);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localp.b();
      localn.execute(arrayOfString);
      return paramView;
    }
    locall2.a.setImageBitmap(localBitmap);
    return paramView;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     m
 * JD-Core Version:    0.6.2
 */