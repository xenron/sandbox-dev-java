package hjapp.com.hjclass_mobile.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;

public class LessonButton extends Button
{
  private Bitmap a = null;

  public LessonButton(Context paramContext)
  {
    super(paramContext);
  }

  public LessonButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public final void a(int paramInt)
  {
    this.a = BitmapFactory.decodeResource(getResources(), paramInt);
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a != null)
      paramCanvas.drawBitmap(this.a, getMeasuredWidth() - this.a.getWidth(), getMeasuredHeight() - this.a.getHeight(), null);
    super.onDraw(paramCanvas);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     LessonButton
 * JD-Core Version:    0.6.2
 */