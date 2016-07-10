package hjapp.com.hjclass_mobile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import hjapp.com.hjclass_mobile.pkg_d.p;

import java.util.List;

public class HJAppActivity extends BaseActivity
  implements OnClickListener, OnItemClickListener, hjapp.com.hjclass_mobile.pkg_c.o
{
  private List a;
  private m b = null;
  private hjapp.com.hjclass_mobile.pkg_h.v c = null;
  private Bitmap d = null;
  private ListView e = null;
  private n f = null;
  private View g = null;
  private View h = null;

  public final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
  {
    if (paramBitmap != null)
    {
      this.c.a(Integer.valueOf(paramInt), paramBitmap);
      paramImageView.setImageBitmap(paramBitmap);
    }
  }

  public void onClick(View paramView)
  {
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903044);
    hjapp.com.hjclass_mobile.h.z.a(this);
    ((Button)findViewById(2131361816)).setOnClickListener(this);
    this.d = BitmapFactory.decodeResource(getResources(), 2130837649);
    this.g = findViewById(2131361817);
    this.h = findViewById(2131361818);
    this.e = ((ListView)findViewById(2131361819));
    this.e.setCacheColorHint(0);
    this.e.setOnItemClickListener(this);
    this.c = new pkg_h.v(20);
    this.f = new n(this, (byte)0);
    this.f.execute(new String[] { "android_hjclass_mobile" });
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String[] arrayOfString;
    if ((this.a != null) && (this.a.size() > 0))
      arrayOfString = ((p)this.a.get(paramInt)).d().split("\\|");
    try
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(arrayOfString[0])));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(arrayOfString[1])));
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJAppActivity
 * JD-Core Version:    0.6.2
 */