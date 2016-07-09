package hjapp.com.hjclass_mobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.d.q;

final class ct extends BaseAdapter
{
  private Context b = null;

  public ct(HJPersonIndexActivity paramHJPersonIndexActivity, Context paramContext)
  {
    this.b = paramContext;
  }

  public final int getCount()
  {
    return HJPersonIndexActivity.f(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return HJPersonIndexActivity.f(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    q localq;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903048, null);
      HJPersonIndexActivity.a(this.a, new cu(this.a, (byte)0));
      HJPersonIndexActivity.q(this.a).d = ((TextView)paramView.findViewById(2131361842));
      HJPersonIndexActivity.q(this.a).c = ((ProgressBar)paramView.findViewById(2131361840));
      HJPersonIndexActivity.q(this.a).b = ((TextView)paramView.findViewById(2131361841));
      HJPersonIndexActivity.q(this.a).a = ((TextView)paramView.findViewById(2131361838));
      HJPersonIndexActivity.q(this.a).e = ((ImageView)paramView.findViewById(2131361836));
      paramView.setTag(HJPersonIndexActivity.q(this.a));
      localq = (q)HJPersonIndexActivity.f(this.a).get(paramInt);
      HJPersonIndexActivity.q(this.a).d.setText("");
      if (localq.b() <= 0)
        break label523;
      HJPersonIndexActivity.q(this.a).c.setProgress((int)(100.0D * (localq.c() / (1.0D * localq.b()))));
    }
    Bitmap localBitmap;
    while (true)
    {
      HJPersonIndexActivity.q(this.a).b.setText(localq.c() + "/" + localq.b());
      HJPersonIndexActivity.q(this.a).a.setText(localq.f());
      HJPersonIndexActivity.q(this.a).d.setVisibility(8);
      if (!TextUtils.isEmpty(localq.d()))
      {
        HJPersonIndexActivity.q(this.a).d.setVisibility(0);
        HJPersonIndexActivity.q(this.a).d.setText(this.a.getString(2131492919) + localq.d());
      }
      localBitmap = (Bitmap)HJPersonIndexActivity.r(this.a).a(Integer.valueOf(localq.a()));
      if (localBitmap != null)
        break label540;
      HJPersonIndexActivity.q(this.a).e.setImageBitmap(HJPersonIndexActivity.s(this.a));
      h.u.b(HJPersonIndexActivity.s(this.a).getWidth() + "<=>" + HJPersonIndexActivity.s(this.a).getHeight());
      hjapp.com.hjclass_mobile.b.n localn = new b.n(this.a, HJPersonIndexActivity.q(this.a).e, localq.a());
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localq.j();
      localn.execute(arrayOfString);
      return paramView;
      HJPersonIndexActivity.a(this.a, (cu)paramView.getTag());
      break;
      label523: HJPersonIndexActivity.q(this.a).c.setProgress(0);
    }
    label540: HJPersonIndexActivity.q(this.a).e.setImageBitmap(localBitmap);
    return paramView;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ct
 * JD-Core Version:    0.6.2
 */