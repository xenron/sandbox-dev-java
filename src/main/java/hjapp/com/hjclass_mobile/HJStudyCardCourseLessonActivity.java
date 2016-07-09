package hjapp.com.hjclass_mobile;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class HJStudyCardCourseLessonActivity extends BaseActivity
  implements OnClickListener, hjapp.com.hjclass_mobile.c.o
{
  private boolean a = false;
  private LinearLayout b = null;
  private int c;
  private TextView d = null;
  private Button e = null;
  private TableLayout f;
  private TableLayout g;
  private LayoutParams h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private ImageView n;
  private View o;
  private ProgressDialog p;
  private Button q = null;

  public final void a(Bitmap paramBitmap, int paramInt, ImageView paramImageView)
  {
    if (paramBitmap != null)
      paramImageView.setImageBitmap(paramBitmap);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131361816:
      finish();
      return;
    case 2131361857:
    }
    String str = this.m.getText().toString();
    Builder localBuilder = new Builder(this);
    localBuilder.setMessage(hjapp.com.hjclass_mobile.h.y.a(getString(2131493121) + getString(2131493136), new Object[] { str }));
    localBuilder.setPositiveButton(getString(2131493112), new dc(this));
    localBuilder.setNeutralButton(getString(2131493094), new dd(this));
    localBuilder.create().show();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903051);
    hjapp.com.hjclass_mobile.h.z.a(this);
    if ((hjapp.com.hjclass_mobile.h.z.h) && (!hjapp.com.hjclass_mobile.h.z.i))
      Toast.makeText(this, getString(2131492940), 1).show();
    this.e = ((Button)findViewById(2131361816));
    this.e.setOnClickListener(this);
    Button localButton = (Button)findViewById(2131361850);
    localButton.setOnClickListener(this);
    localButton.setVisibility(4);
    this.q = ((Button)findViewById(2131361857));
    this.q.setOnClickListener(this);
    this.d = ((TextView)findViewById(2131361849));
    this.i = ((TextView)findViewById(2131361831));
    this.j = ((TextView)findViewById(2131361833));
    this.k = ((TextView)findViewById(2131361834));
    this.l = ((TextView)findViewById(2131361835));
    this.m = ((TextView)findViewById(2131361854));
    this.n = ((ImageView)findViewById(2131361836));
    this.o = findViewById(2131361853);
    this.o.setVisibility(0);
    Bundle localBundle = getIntent().getExtras();
    this.b = ((LinearLayout)findViewById(2131361852));
    this.b.setVisibility(8);
    this.f = ((TableLayout)findViewById(2131361855));
    this.g = ((TableLayout)findViewById(2131361856));
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.h = new LayoutParams(-1, -2);
    this.g.setShrinkAllColumns(true);
    this.f.setShrinkAllColumns(true);
    this.h.gravity = 17;
    if (localBundle != null)
    {
      this.a = true;
      this.c = Integer.parseInt(localBundle.getString("classid"));
      this.d.setText(getString(2131492931));
      this.i.setText(localBundle.getString("classXB"));
      this.j.setText(localBundle.getString("teacher"));
      this.k.setText(localBundle.getString("opentime").replace("0:00:00", ""));
      this.l.setText(getString(2131492935) + "\n" + localBundle.getString("des"));
      String str = localBundle.getString("iconUrl");
      new b.n(this, this.n, this.c).execute(new String[] { str });
      this.m.setText(localBundle.getString("classname"));
      this.a = false;
    }
  }

  protected void onDestroy()
  {
    hjapp.com.hjclass_mobile.h.z.b(this);
    super.onDestroy();
  }

  protected void onResume()
  {
    super.onResume();
  }

  protected void onStart()
  {
    super.onStart();
  }

  protected void onStop()
  {
    super.onStop();
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJStudyCardCourseLessonActivity
 * JD-Core Version:    0.6.2
 */