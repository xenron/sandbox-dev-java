package hjapp.com.hjclass_mobile;

import android.text.TextUtils;
import android.widget.Filter;
import hjapp.com.hjclass_mobile.pkg_d.q;
import java.util.ArrayList;
import java.util.List;

final class dl extends Filter
{
  dl(dk paramdk)
  {
  }

  protected final FilterResults performFiltering(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
      return null;
    HJSubCourseActivity.b(this.a.a).clear();
    int i = HJSubCourseActivity.k(this.a.a).size();
    ArrayList localArrayList = new ArrayList();
    for (int j = 0; j < i; j++)
    {
      q localq = (q)HJSubCourseActivity.k(this.a.a).get(j);
      String str = paramCharSequence.toString().toLowerCase();
      boolean bool1 = localq.q().toLowerCase().equals(str);
      boolean bool2 = localq.f().toLowerCase().contains(str);
      if (((bool1) && (str.length() == 1)) || (bool2))
        localArrayList.add(localq);
    }
    if (localArrayList.size() > 0)
    {
      HJSubCourseActivity.b(this.a.a).clear();
      HJSubCourseActivity.b(this.a.a, localArrayList);
    }
    FilterResults localFilterResults = new FilterResults();
    localFilterResults.values = HJSubCourseActivity.b(this.a.a);
    localFilterResults.count = HJSubCourseActivity.b(this.a.a).size();
    return localFilterResults;
  }

  protected final void publishResults(CharSequence paramCharSequence, FilterResults paramFilterResults)
  {
    if (paramFilterResults != null)
      HJSubCourseActivity.b(this.a.a, (List)paramFilterResults.values);
    while (true)
    {
      this.a.notifyDataSetChanged();
      return;
      HJSubCourseActivity.b(this.a.a).clear();
      HJSubCourseActivity.b(this.a.a).addAll(HJSubCourseActivity.k(this.a.a));
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     dl
 * JD-Core Version:    0.6.2
 */