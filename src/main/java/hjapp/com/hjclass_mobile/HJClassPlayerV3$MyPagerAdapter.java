package hjapp.com.hjclass_mobile;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import hjapp.com.hjclass_mobile.view.page.HJPage;

import java.util.List;

public class HJClassPlayerV3$MyPagerAdapter extends PagerAdapter
{
  public List a;

  public HJClassPlayerV3$MyPagerAdapter(HJClassPlayerV3 paramHJClassPlayerV3, List paramList)
  {
    this.a = paramList;
  }

  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)this.a.get(paramInt));
  }

  public void finishUpdate(View paramView)
  {
  }

  public int getCount()
  {
    return this.a.size();
  }

  public Object instantiateItem(View paramView, int paramInt)
  {
    ((ViewPager)paramView).addView((View)this.a.get(paramInt), 0);
    HJPage localHJPage = (HJPage)this.a.get(paramInt);
    localHJPage.e();
    return localHJPage;
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }

  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
  }

  public Parcelable saveState()
  {
    return null;
  }

  public void startUpdate(View paramView)
  {
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJClassPlayerV3.MyPagerAdapter
 * JD-Core Version:    0.6.2
 */