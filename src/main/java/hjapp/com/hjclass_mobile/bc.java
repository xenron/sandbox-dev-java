package hjapp.com.hjclass_mobile;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.d.t;

final class bc extends BaseAdapter
{
  private Context b = null;

  public bc(HJDownloadCompleteListActivity paramHJDownloadCompleteListActivity, Context paramContext)
  {
    this.b = paramContext;
  }

  public final int getCount()
  {
    return HJDownloadCompleteListActivity.a(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return HJDownloadCompleteListActivity.a(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label157: t localt;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903091, null);
      HJDownloadCompleteListActivity.a(this.a, new bd(this.a, (byte)0));
      HJDownloadCompleteListActivity.b(this.a).a = ((TextView)paramView.findViewById(2131361886));
      HJDownloadCompleteListActivity.b(this.a).b = ((TextView)paramView.findViewById(2131361891));
      HJDownloadCompleteListActivity.b(this.a).c = ((TextView)paramView.findViewById(2131361842));
      HJDownloadCompleteListActivity.b(this.a).d = ((ImageView)paramView.findViewById(2131361893));
      HJDownloadCompleteListActivity.b(this.a).e = ((TextView)paramView.findViewById(2131361987));
      HJDownloadCompleteListActivity.b(this.a).f = paramView.findViewById(2131361986);
      paramView.setTag(HJDownloadCompleteListActivity.b(this.a));
      localt = (t)HJDownloadCompleteListActivity.a(this.a).get(paramInt);
      HJDownloadCompleteListActivity.b(this.a).a.setText(localt.g());
      HJDownloadCompleteListActivity.b(this.a).b.setText(this.a.getString(2131492911));
      HJDownloadCompleteListActivity.b(this.a).c.setTextColor(-6710887);
      HJDownloadCompleteListActivity.b(this.a).e.setText("");
      if (localt.s() <= 0)
        break label457;
      HJDownloadCompleteListActivity.b(this.a).f.setVisibility(0);
      if (localt.s() >= 60000)
        break label408;
      HJDownloadCompleteListActivity.b(this.a).e.setText(this.a.getString(2131493033));
      label299: if (localt.j() <= 0)
        break label475;
      HJDownloadCompleteListActivity.b(this.a).d.setBackgroundResource(2130837525);
      HJDownloadCompleteListActivity.b(this.a).c.setText(this.b.getString(2131492926));
    }
    while (true)
      switch (localt.b())
      {
      default:
        return paramView;
        HJDownloadCompleteListActivity.a(this.a, (bd)paramView.getTag());
        break label157;
        label408: HJDownloadCompleteListActivity.b(this.a).e.setText(this.a.getString(2131493032) + h.z.b(localt.s()));
        break label299;
        label457: HJDownloadCompleteListActivity.b(this.a).f.setVisibility(8);
        break label299;
        label475: HJDownloadCompleteListActivity.b(this.a).c.setText(this.b.getString(2131492925));
        if (localt.t())
          HJDownloadCompleteListActivity.b(this.a).d.setBackgroundResource(2130837742);
        else
          HJDownloadCompleteListActivity.b(this.a).d.setBackgroundResource(2130837525);
        break;
      case 2:
      case 3:
      case 6:
      case 1:
      case 4:
      case 5:
      }
    HJDownloadCompleteListActivity.b(this.a).b.setText(this.a.getString(2131492905));
    return paramView;
    HJDownloadCompleteListActivity.b(this.a).b.setText(this.a.getString(2131492907));
    return paramView;
    HJDownloadCompleteListActivity.b(this.a).b.setText(this.a.getString(2131492911));
    return paramView;
    HJDownloadCompleteListActivity.b(this.a).b.setText(this.a.getString(2131492908));
    return paramView;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     bc
 * JD-Core Version:    0.6.2
 */