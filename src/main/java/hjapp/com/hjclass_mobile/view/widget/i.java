package hjapp.com.hjclass_mobile.view.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public final class i extends AlertDialog
  implements DialogInterface
{
  private HuzAlertController a = new HuzAlertController(paramContext, this, getWindow());

  protected i(Context paramContext)
  {
    this(paramContext, (byte)0);
  }

  private i(Context paramContext, byte paramByte)
  {
    super(paramContext, 2131558414);
  }

  public final Button getButton(int paramInt)
  {
    return this.a.b(paramInt);
  }

  public final ListView getListView()
  {
    return this.a.b();
  }

  protected final void onCreate(Bundle paramBundle)
  {
    this.a.a();
  }

  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.a(paramKeyEvent))
      return true;
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.b(paramKeyEvent))
      return true;
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  public final void setButton(int paramInt, CharSequence paramCharSequence, OnClickListener paramOnClickListener)
  {
    this.a.a(paramInt, paramCharSequence, paramOnClickListener, null);
  }

  public final void setButton(int paramInt, CharSequence paramCharSequence, Message paramMessage)
  {
    this.a.a(paramInt, paramCharSequence, null, paramMessage);
  }

  public final void setButton(CharSequence paramCharSequence, OnClickListener paramOnClickListener)
  {
    setButton(-1, paramCharSequence, paramOnClickListener);
  }

  public final void setButton(CharSequence paramCharSequence, Message paramMessage)
  {
    setButton(-1, paramCharSequence, paramMessage);
  }

  public final void setButton2(CharSequence paramCharSequence, OnClickListener paramOnClickListener)
  {
    setButton(-2, paramCharSequence, paramOnClickListener);
  }

  public final void setButton2(CharSequence paramCharSequence, Message paramMessage)
  {
    setButton(-2, paramCharSequence, paramMessage);
  }

  public final void setButton3(CharSequence paramCharSequence, OnClickListener paramOnClickListener)
  {
    setButton(-3, paramCharSequence, paramOnClickListener);
  }

  public final void setButton3(CharSequence paramCharSequence, Message paramMessage)
  {
    setButton(-3, paramCharSequence, paramMessage);
  }

  public final void setCustomTitle(View paramView)
  {
    this.a.a(paramView);
  }

  public final void setIcon(int paramInt)
  {
    this.a.a(paramInt);
  }

  public final void setIcon(Drawable paramDrawable)
  {
    this.a.a(paramDrawable);
  }

  public final void setInverseBackgroundForced(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }

  public final void setMessage(CharSequence paramCharSequence)
  {
    this.a.b(paramCharSequence);
  }

  public final void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.a.a(paramCharSequence);
  }

  public final void setView(View paramView)
  {
    this.a.b(paramView);
  }

  public final void setView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     i
 * JD-Core Version:    0.6.2
 */