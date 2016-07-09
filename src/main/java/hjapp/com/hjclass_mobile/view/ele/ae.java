package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import hjapp.com.hjclass_mobile.b.a;
import hjapp.com.hjclass_mobile.c.k;

public final class ae extends RelativeLayout
  implements OnEditorActionListener, k
{
  private ImageView a = null;
  private ImageView b = null;
  private a c = null;
  private hjapp.com.hjclass_mobile.c.z d = null;
  private String e = null;
  private EditText f = null;

  public ae(Context paramContext, a parama)
  {
    super(paramContext);
    this.c = parama;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903062, null);
    addView(localView);
    this.b = ((ImageView)localView.findViewById(2131361906));
    this.a = ((ImageView)localView.findViewById(2131361905));
    this.f = ((EditText)localView.findViewById(2131361916));
    this.f.setOnEditorActionListener(this);
    this.f.setSingleLine(true);
    this.a.setVisibility(4);
    this.b.setVisibility(4);
  }

  public final void a()
  {
    this.f.setText("");
    this.a.setVisibility(4);
    this.b.setVisibility(4);
  }

  public final void a(hjapp.com.hjclass_mobile.d.z paramz)
  {
    if (paramz.b().equals(this.e))
    {
      a(true);
      return;
    }
    a(false);
  }

  public final void a(String paramString)
  {
    this.f.setText(paramString);
  }

  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      return;
    }
    this.a.setVisibility(0);
  }

  public final void b()
  {
  }

  public final void b(String paramString)
  {
    this.e = paramString;
  }

  public final void c()
  {
    removeAllViews();
    this.a.destroyDrawingCache();
    this.a = null;
    this.b.destroyDrawingCache();
    this.b = null;
    this.f.destroyDrawingCache();
    this.f = null;
  }

  public final String d()
  {
    return this.f.getText().toString();
  }

  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66))
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramTextView.getApplicationWindowToken(), 2);
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ae
 * JD-Core Version:    0.6.2
 */