package hjapp.com.hjclass_mobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import hjapp.com.hjclass_mobile.pkg_d.q;

final class dk extends BaseAdapter
  implements Filterable
{
  private Context b = null;

  public dk(HJSubCourseActivity paramHJSubCourseActivity, Context paramContext)
  {
    this.b = paramContext;
  }

  public final int getCount()
  {
    return HJSubCourseActivity.b(this.a).size();
  }

  public final Filter getFilter()
  {
    return new dl(this);
  }

  public final Object getItem(int paramInt)
  {
    return HJSubCourseActivity.b(this.a).get(paramInt);
  }

  public final long getItemId(int paramInt)
  {
    return paramInt;
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    q localq;
    Bitmap localBitmap;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903050, null);
      HJSubCourseActivity.a(this.a, new dm(this.a, (byte)0));
      HJSubCourseActivity.h(this.a).d = ((ImageView)paramView.findViewById(2131361836));
      HJSubCourseActivity.h(this.a).c = ((TextView)paramView.findViewById(2131361842));
      HJSubCourseActivity.h(this.a).b = ((TextView)paramView.findViewById(2131361847));
      HJSubCourseActivity.h(this.a).a = ((TextView)paramView.findViewById(2131361838));
      paramView.setTag(HJSubCourseActivity.h(this.a));
      localq = (q)HJSubCourseActivity.b(this.a).get(paramInt);
      localBitmap = (Bitmap)HJSubCourseActivity.i(this.a).a(Integer.valueOf(localq.a()));
      if (localBitmap != null)
        break label419;
      HJSubCourseActivity.h(this.a).d.setImageBitmap(HJSubCourseActivity.j(this.a));
      hjapp.com.hjclass_mobile.pkg_b.n localn = new pkg_b.n(this.a, HJSubCourseActivity.h(this.a).d, localq.a());
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localq.j();
      localn.execute(arrayOfString);
      label239: HJSubCourseActivity.h(this.a).c.setVisibility(8);
      HJSubCourseActivity.h(this.a).c.setText("");
      if (localq.o() != 1)
        break label437;
      HJSubCourseActivity.h(this.a).b.setCompoundDrawables(null, null, null, null);
      HJSubCourseActivity.h(this.a).b.setText(Html.fromHtml("<font size='12' color='#555555'>已开通</font>"));
    }
    while (true)
    {
      HJSubCourseActivity.h(this.a).a.setText(localq.f());
      if (!TextUtils.isEmpty(localq.d()))
      {
        HJSubCourseActivity.h(this.a).c.setVisibility(0);
        HJSubCourseActivity.h(this.a).c.setText(this.a.getString(2131492919) + localq.d());
      }
      return paramView;
      HJSubCourseActivity.a(this.a, (dm)paramView.getTag());
      break;
      label419: HJSubCourseActivity.h(this.a).d.setImageBitmap(localBitmap);
      break label239;
      label437: HJSubCourseActivity.h(this.a).b.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(2130837694), null, null, null);
      HJSubCourseActivity.h(this.a).b.setCompoundDrawablePadding(5);
      HJSubCourseActivity.h(this.a).b.setText(Html.fromHtml("<font color='#ff6102'><b>" + localq.n() + "</b></font> <font color='#555555'>学币</font>"));
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     dk
 * JD-Core Version:    0.6.2
 */