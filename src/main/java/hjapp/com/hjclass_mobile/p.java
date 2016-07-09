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

final class p extends BaseAdapter
{
  private Context b = null;

  public p(HJClassExpiredListActivity paramHJClassExpiredListActivity, Context paramContext)
  {
    this.b = paramContext;
  }

  public final int getCount()
  {
    return HJClassExpiredListActivity.d(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return HJClassExpiredListActivity.d(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    d.q localq;
    label200: Bitmap localBitmap;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903048, null);
      HJClassExpiredListActivity.a(this.a, new q(this.a, (byte)0));
      HJClassExpiredListActivity.h(this.a).e = ((ImageView)paramView.findViewById(2131361836));
      HJClassExpiredListActivity.h(this.a).d = ((TextView)paramView.findViewById(2131361842));
      HJClassExpiredListActivity.h(this.a).c = ((ProgressBar)paramView.findViewById(2131361840));
      HJClassExpiredListActivity.h(this.a).b = ((TextView)paramView.findViewById(2131361841));
      HJClassExpiredListActivity.h(this.a).a = ((TextView)paramView.findViewById(2131361838));
      paramView.setTag(HJClassExpiredListActivity.h(this.a));
      localq = (d.q)HJClassExpiredListActivity.d(this.a).get(paramInt);
      if (localq.b() <= 0)
        break label479;
      HJClassExpiredListActivity.h(this.a).c.setProgress((int)(100.0D * (localq.c() / (1.0D * localq.b()))));
      localBitmap = (Bitmap)HJClassExpiredListActivity.i(this.a).a(Integer.valueOf(localq.a()));
      if (localBitmap != null)
        break label496;
      HJClassExpiredListActivity.h(this.a).e.setImageBitmap(HJClassExpiredListActivity.j(this.a));
      hjapp.com.hjclass_mobile.b.n localn = new b.n(this.a, HJClassExpiredListActivity.h(this.a).e, localq.a());
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localq.j();
      localn.execute(arrayOfString);
    }
    while (true)
    {
      HJClassExpiredListActivity.h(this.a).d.setVisibility(8);
      HJClassExpiredListActivity.h(this.a).d.setText("");
      HJClassExpiredListActivity.h(this.a).b.setText(localq.c() + "/" + localq.b());
      HJClassExpiredListActivity.h(this.a).a.setText(localq.f());
      if (!TextUtils.isEmpty(localq.d()))
      {
        HJClassExpiredListActivity.h(this.a).d.setVisibility(0);
        HJClassExpiredListActivity.h(this.a).d.setText(this.a.getString(2131492919) + localq.d());
      }
      return paramView;
      HJClassExpiredListActivity.a(this.a, (q)paramView.getTag());
      break;
      label479: HJClassExpiredListActivity.h(this.a).c.setProgress(0);
      break label200;
      label496: HJClassExpiredListActivity.h(this.a).e.setImageBitmap(localBitmap);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     p
 * JD-Core Version:    0.6.2
 */