package hjapp.com.hjclass_mobile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ImagePlayer extends FrameLayout
{
  int a = 0;
  int b = 0;
  private ImageView c;
  private int d = 0;
  private int e;
  private int f;
  private float g = 1.0F;
  private float h = 1.0F;
  private Context i = null;
  private int j = 0;
  private int k = 0;

  public ImagePlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.i = paramContext;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)this.i.getSystemService("window");
    if (localWindowManager != null)
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.e = localDisplayMetrics.widthPixels;
    this.f = localDisplayMetrics.heightPixels;
    this.c = ((ImageView)((LayoutInflater)this.i.getSystemService("layout_inflater")).inflate(2130903089, this).findViewById(2131361980));
    this.c.setLongClickable(true);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ImagePlayer
 * JD-Core Version:    0.6.2
 */