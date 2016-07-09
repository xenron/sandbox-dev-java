package hjapp.com.hjclass_mobile;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;
import android.widget.Toast;

public class HJSettingActivity extends PreferenceActivity
  implements OnClickListener, OnPreferenceClickListener
{
  private static SharedPreferences b;
  private Handler a = null;
  private AlertDialog c;
  private AlertDialog d;
  private hjapp.com.hjclass_mobile.b.b e = null;

  public static int a(Context paramContext)
  {
    return Integer.parseInt(c(paramContext).getString("line_select", "2"));
  }

  public static int b(Context paramContext)
  {
    return Integer.parseInt(c(paramContext).getString("orientation_select", "1"));
  }

  private static SharedPreferences c(Context paramContext)
  {
    if (b == null)
      b = PreferenceManager.getDefaultSharedPreferences(paramContext);
    return b;
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (c.b() <= 0)
      return;
    if ((paramDialogInterface == this.c) && (paramInt == -1))
    {
      Log.i("HJSettingActivity", "delete_complete");
      cw localcw = new cw(this);
      this.a.post(localcw);
    }
    if ((paramDialogInterface == this.d) && (paramInt == -1))
    {
      cx localcx = new cx(this);
      this.a.post(localcx);
      Log.i("HJSettingActivity", "delete_fail");
    }
    Toast.makeText(this, getString(2131492985), 0).show();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!h.z.j)
    {
      Toast.makeText(this, getString(2131492939), 0).show();
      finish();
    }
    addPreferencesFromResource(2131034112);
    PreferenceScreen localPreferenceScreen = getPreferenceScreen();
    localPreferenceScreen.findPreference("delete_complete").setOnPreferenceClickListener(this);
    localPreferenceScreen.findPreference("line_select").setOnPreferenceClickListener(this);
    localPreferenceScreen.findPreference("delete_fail").setOnPreferenceClickListener(this);
    localPreferenceScreen.findPreference("orientation_select").setOnPreferenceClickListener(this);
    this.e = new hjapp.com.hjclass_mobile.b.b(this);
    this.a = new Handler();
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    AlertDialog localAlertDialog = new Builder(this).setTitle(2131492969).setMessage(2131492980).setPositiveButton(2131492981, this).setNegativeButton(2131492982, null).create();
    switch (paramInt)
    {
    default:
      return localAlertDialog;
    case 101:
      this.c = ((AlertDialog)localAlertDialog);
      return localAlertDialog;
    case 102:
    }
    this.d = ((AlertDialog)localAlertDialog);
    return localAlertDialog;
  }

  public boolean onPreferenceClick(Preference paramPreference)
  {
    if (paramPreference.getKey().equals("delete_fail"))
    {
      showDialog(102);
      return true;
    }
    if (paramPreference.getKey().equals("delete_complete"))
    {
      showDialog(101);
      return true;
    }
    return false;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJSettingActivity
 * JD-Core Version:    0.6.2
 */