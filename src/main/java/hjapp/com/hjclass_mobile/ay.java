package hjapp.com.hjclass_mobile;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.d.s;

final class ay extends BaseAdapter
{
  private Context b = null;

  public ay(HJDownloadActivity paramHJDownloadActivity, Context paramContext)
  {
    this.b = paramContext;
  }

  public final int getCount()
  {
    return HJDownloadActivity.d(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return HJDownloadActivity.d(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label160: s locals;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903055, null);
      HJDownloadActivity.a(this.a, new az(this.a, (byte)0));
      HJDownloadActivity.g(this.a).a = ((TextView)paramView.findViewById(2131361886));
      HJDownloadActivity.g(this.a).b = ((ProgressBar)paramView.findViewById(2131361888));
      HJDownloadActivity.g(this.a).c = ((TextView)paramView.findViewById(2131361889));
      HJDownloadActivity.g(this.a).d = ((TextView)paramView.findViewById(2131361891));
      HJDownloadActivity.g(this.a).e = ((ImageView)paramView.findViewById(2131361893));
      HJDownloadActivity.g(this.a).f = ((TextView)paramView.findViewById(2131361892));
      paramView.setTag(HJDownloadActivity.g(this.a));
      locals = (s)HJDownloadActivity.d(this.a).get(paramInt);
      HJDownloadActivity.g(this.a).b.setProgress(locals.g());
      HJDownloadActivity.g(this.a).c.setText(locals.g() + "%");
      float f = (float)(locals.n() / 1024.0D);
      HJDownloadActivity.g(this.a).f.setText("");
      if ((locals.l() <= 0L) || (locals.g() >= 100))
        break label444;
      HJDownloadActivity.g(this.a).f.setText(h.z.a(f) + " / " + h.z.a((float)locals.l()));
    }
    while (true)
    {
      HJDownloadActivity.g(this.a).a.setText(locals.b());
      HJDownloadActivity.g(this.a).e.setBackgroundResource(2130837616);
      HJDownloadActivity.g(this.a).d.setText(this.a.getString(2131492910));
      switch (locals.e())
      {
      default:
        return paramView;
        HJDownloadActivity.a(this.a, (az)paramView.getTag());
        break label160;
        label444: HJDownloadActivity.g(this.a).f.setText("");
      case 2:
      case 3:
      case 6:
      case 5:
      case 4:
      case 1:
      }
    }
    HJDownloadActivity.g(this.a).e.setBackgroundResource(2130837614);
    HJDownloadActivity.g(this.a).d.setText(this.a.getString(2131492905));
    return paramView;
    HJDownloadActivity.g(this.a).e.setBackgroundResource(2130837615);
    HJDownloadActivity.g(this.a).d.setText(this.a.getString(2131492907));
    return paramView;
    HJDownloadActivity.g(this.a).e.setBackgroundResource(2130837525);
    HJDownloadActivity.g(this.a).d.setText(this.a.getString(2131492911));
    return paramView;
    HJDownloadActivity.g(this.a).b.setVisibility(0);
    HJDownloadActivity.g(this.a).e.setBackgroundResource(2130837616);
    HJDownloadActivity.g(this.a).d.setText(this.a.getString(2131492910));
    return paramView;
    HJDownloadActivity.g(this.a).b.setVisibility(0);
    HJDownloadActivity.g(this.a).e.setBackgroundResource(2130837613);
    if (locals.n() > 0.0D)
    {
      if (locals.g() == 100)
      {
        HJDownloadActivity.g(this.a).d.setText(this.a.getString(2131492916));
        return paramView;
      }
      HJDownloadActivity.g(this.a).d.setText(this.a.getString(2131492908));
      return paramView;
    }
    if (locals.g() == 100)
    {
      HJDownloadActivity.g(this.a).d.setText(this.a.getString(2131492916));
      return paramView;
    }
    HJDownloadActivity.g(this.a).d.setText(this.a.getString(2131493035));
    return paramView;
    HJDownloadActivity.g(this.a).b.setVisibility(0);
    HJDownloadActivity.g(this.a).e.setBackgroundResource(2130837617);
    HJDownloadActivity.g(this.a).d.setText(this.a.getString(2131492909));
    return paramView;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ay
 * JD-Core Version:    0.6.2
 */