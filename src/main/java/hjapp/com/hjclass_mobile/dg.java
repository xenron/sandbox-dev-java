package hjapp.com.hjclass_mobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

final class dg extends BaseAdapter
{
  private Context b = null;

  public dg(HJStudyCardSubCourseActivity paramHJStudyCardSubCourseActivity, Context paramContext)
  {
    this.b = paramContext;
  }

  public final int getCount()
  {
    return HJStudyCardSubCourseActivity.a(this.a).size();
  }

  public final Object getItem(int paramInt)
  {
    return HJStudyCardSubCourseActivity.a(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    d.w localw;
    Bitmap localBitmap;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903050, null);
      HJStudyCardSubCourseActivity.a(this.a, new dh(this.a, (byte)0));
      HJStudyCardSubCourseActivity.g(this.a).d = ((ImageView)paramView.findViewById(2131361836));
      HJStudyCardSubCourseActivity.g(this.a).c = ((TextView)paramView.findViewById(2131361842));
      HJStudyCardSubCourseActivity.g(this.a).b = ((TextView)paramView.findViewById(2131361847));
      HJStudyCardSubCourseActivity.g(this.a).a = ((TextView)paramView.findViewById(2131361838));
      paramView.setTag(HJStudyCardSubCourseActivity.g(this.a));
      localw = (d.w)HJStudyCardSubCourseActivity.a(this.a).get(paramInt);
      localBitmap = (Bitmap)HJStudyCardSubCourseActivity.h(this.a).a(Integer.valueOf(Integer.parseInt(localw.a())));
      if (localBitmap != null)
        break label396;
      HJStudyCardSubCourseActivity.g(this.a).d.setImageBitmap(HJStudyCardSubCourseActivity.i(this.a));
      hjapp.com.hjclass_mobile.b.n localn = new b.n(this.a, HJStudyCardSubCourseActivity.g(this.a).d, Integer.parseInt(localw.a()));
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localw.c();
      localn.execute(arrayOfString);
    }
    while (true)
    {
      HJStudyCardSubCourseActivity.g(this.a).c.setVisibility(8);
      HJStudyCardSubCourseActivity.g(this.a).c.setText("");
      HJStudyCardSubCourseActivity.g(this.a).b.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(2130837694), null, null, null);
      HJStudyCardSubCourseActivity.g(this.a).b.setCompoundDrawablePadding(5);
      HJStudyCardSubCourseActivity.g(this.a).b.setText(Html.fromHtml("<font color='#ff6102'><b>" + localw.d() + "</b></font> <font color='#555555'>学币</font>"));
      HJStudyCardSubCourseActivity.g(this.a).a.setText(localw.b());
      return paramView;
      HJStudyCardSubCourseActivity.a(this.a, (dh)paramView.getTag());
      break;
      label396: HJStudyCardSubCourseActivity.g(this.a).d.setImageBitmap(localBitmap);
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     dg
 * JD-Core Version:    0.6.2
 */