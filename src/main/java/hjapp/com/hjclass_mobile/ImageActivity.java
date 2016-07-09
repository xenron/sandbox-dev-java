package hjapp.com.hjclass_mobile;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ZoomControls;
import hjapp.com.hjclass_mobile.zoom.ImageZoomView;
import hjapp.com.hjclass_mobile.zoom.b;

public class ImageActivity extends BaseActivity
{
  View.OnClickListener a = new dt(this);
  View.OnClickListener b = new du(this);
  View.OnClickListener c = new dv(this);
  private String d;
  private ProgressDialog e;
  private b f;
  private hjapp.com.hjclass_mobile.zoom.c g;
  private ImageZoomView h;
  private ZoomControls i;
  private Button j;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903090);
    hjapp.com.hjclass_mobile.h.z.a(this);
    this.e = hjapp.com.hjclass_mobile.h.z.a(this, getText(2131492895));
    setRequestedOrientation(2);
    this.j = ((Button)findViewById(2131361982));
    this.i = ((ZoomControls)findViewById(2131361985));
    this.j.setOnClickListener(this.c);
    this.i.setOnZoomInClickListener(this.a);
    this.i.setOnZoomOutClickListener(this.b);
    this.d = getIntent().getExtras().getString("imgUrl");
    dw localdw = new dw(this);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.d;
    localdw.execute(arrayOfString);
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ImageActivity
 * JD-Core Version:    0.6.2
 */