package hjapp.com.hjclass_mobile.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class StatusView extends RelativeLayout
{
  public StatusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setStrokeWidth(4.0F);
    localPaint.setColor(16711680);
    paramCanvas.drawLine(getMeasuredWidth(), 0.0F, getMeasuredHeight(), getMeasuredWidth(), localPaint);
    paramCanvas.drawLine(0.0F, getMeasuredHeight(), getMeasuredHeight(), 0.0F, localPaint);
    super.onDraw(paramCanvas);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     StatusView
 * JD-Core Version:    0.6.2
 */