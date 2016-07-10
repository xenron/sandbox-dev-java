package hjapp.com.hjclass_mobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import hjapp.com.hjclass_mobile.pkg_d.t;

public final class bq extends BaseAdapter
{
  private Context b;

  public bq(HJFreeLessonListActivity paramHJFreeLessonListActivity, Context paramContext)
  {
    this.b = paramContext;
  }

  public final int getCount()
  {
    return HJFreeLessonListActivity.b(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    if (HJFreeLessonListActivity.b(this.a).size() == 0)
      return 0L;
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    br localbr1;
    if (paramView == null)
    {
      localbr1 = new br(this.a);
      paramView = LayoutInflater.from(this.b).inflate(2130903041, null);
      localbr1.a = ((ImageView)paramView.findViewById(2131361798));
      localbr1.b = ((Button)paramView.findViewById(2131361799));
      localbr1.b.setOnClickListener(this.a);
      paramView.setTag(localbr1);
    }
    for (br localbr2 = localbr1; HJFreeLessonListActivity.b(this.a).size() == 0; localbr2 = (br)paramView.getTag())
      return paramView;
    t localt = (t)HJFreeLessonListActivity.b(this.a).get(paramInt);
    Bitmap localBitmap = (Bitmap)HJFreeLessonListActivity.b().a(Integer.valueOf(localt.c()));
    if (localBitmap == null)
    {
      localbr2.a.setImageBitmap(HJFreeLessonListActivity.h(this.a));
      hjapp.com.hjclass_mobile.pkg_b.n localn = new pkg_b.n(this.a, localbr2.a, localt.c());
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localt.o();
      localn.execute(arrayOfString);
    }
    while (true)
    {
      localbr2.b.setText(this.a.getString(2131493034));
      switch (localt.b())
      {
      default:
        return paramView;
      case 1:
      case 4:
      case 5:
      case 6:
        localbr2.b.setText(this.a.getString(2131493034));
        return paramView;
        localbr2.a.setImageBitmap(localBitmap);
      case 2:
      case 3:
      }
    }
    localbr2.b.setText(this.a.getString(2131492905));
    return paramView;
    localbr2.b.setText(this.a.getString(2131493031));
    return paramView;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bq
 * JD-Core Version:    0.6.2
 */