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

final class v extends BaseAdapter
{
  private Context b = null;

  public v(HJClassListActivity paramHJClassListActivity, Context paramContext)
  {
    this.b = paramContext;
  }

  public final int getCount()
  {
    return HJClassListActivity.d(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return HJClassListActivity.d(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    q localq;
    label200: Bitmap localBitmap;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903048, null);
      HJClassListActivity.a(this.a, new w(this.a, (byte)0));
      HJClassListActivity.h(this.a).e = ((ImageView)paramView.findViewById(2131361836));
      HJClassListActivity.h(this.a).d = ((TextView)paramView.findViewById(2131361842));
      HJClassListActivity.h(this.a).c = ((ProgressBar)paramView.findViewById(2131361840));
      HJClassListActivity.h(this.a).b = ((TextView)paramView.findViewById(2131361841));
      HJClassListActivity.h(this.a).a = ((TextView)paramView.findViewById(2131361838));
      paramView.setTag(HJClassListActivity.h(this.a));
      localq = (q)HJClassListActivity.d(this.a).get(paramInt);
      if (localq.b() <= 0)
        break label479;
      HJClassListActivity.h(this.a).c.setProgress((int)(100.0D * (localq.c() / (1.0D * localq.b()))));
      localBitmap = (Bitmap)HJClassListActivity.i(this.a).a(Integer.valueOf(localq.a()));
      if (localBitmap != null)
        break label496;
      HJClassListActivity.h(this.a).e.setImageBitmap(HJClassListActivity.j(this.a));
      hjapp.com.hjclass_mobile.b.n localn = new b.n(this.a, HJClassListActivity.h(this.a).e, localq.a());
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localq.j();
      localn.execute(arrayOfString);
    }
    while (true)
    {
      HJClassListActivity.h(this.a).d.setVisibility(8);
      HJClassListActivity.h(this.a).d.setText("");
      HJClassListActivity.h(this.a).b.setText(localq.c() + "/" + localq.b());
      HJClassListActivity.h(this.a).a.setText(localq.f());
      if (!TextUtils.isEmpty(localq.d()))
      {
        HJClassListActivity.h(this.a).d.setVisibility(0);
        HJClassListActivity.h(this.a).d.setText(this.a.getString(2131492919) + localq.d());
      }
      return paramView;
      HJClassListActivity.a(this.a, (w)paramView.getTag());
      break;
      label479: HJClassListActivity.h(this.a).c.setProgress(0);
      break label200;
      label496: HJClassListActivity.h(this.a).e.setImageBitmap(localBitmap);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     v
 * JD-Core Version:    0.6.2
 */