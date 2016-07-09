package hjapp.com.hjclass_mobile;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.io.FileInputStream;

public class TestActivity extends BaseActivity
{
  private Spinner a = null;
  private MediaPlayer b = null;
  private FileInputStream c = null;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903130);
    this.a = ((Spinner)findViewById(2131362093));
    ArrayAdapter localArrayAdapter = ArrayAdapter.createFromResource(this, 2131165190, 17367048);
    localArrayAdapter.setDropDownViewResource(17367049);
    this.a.setAdapter(localArrayAdapter);
    this.a.setPrompt("下拉菜单");
    this.a.setOnItemSelectedListener(new ea());
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     TestActivity
 * JD-Core Version:    0.6.2
 */