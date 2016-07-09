package hjapp.com.hjclass_mobile.view.ele;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class af extends LinearLayout
{
  private TextView a;
  private TextView b;
  private TextView c;
  private String d;
  private int e;
  private int f;
  private String g = null;

  public af(Context paramContext)
  {
    super(paramContext);
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903066, null);
    addView(localView);
    this.a = ((TextView)localView.findViewById(2131361911));
    this.a.setEnabled(false);
    this.b = ((TextView)localView.findViewById(2131361903));
    this.b.setEnabled(false);
    this.c = ((TextView)localView.findViewById(2131361923));
  }

  private static boolean a(String paramString1, String paramString2)
  {
    String[] arrayOfString = paramString2.split("\\/+");
    int i = arrayOfString.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (arrayOfString[j].trim().equals(paramString1.trim()))
          bool = true;
      }
      else
        return bool;
    }
  }

  public final String a()
  {
    return this.d;
  }

  public final void a(int paramInt)
  {
    this.e = paramInt;
  }

  public final void a(String paramString)
  {
    if (paramString != null)
      this.a.setText(c.a(paramString));
  }

  public final void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int i = 0;
    this.d = paramString1;
    this.g = paramString2;
    if (paramString1 == null);
    label70: String str;
    label185: 
    do
    {
      return;
      String[] arrayOfString1 = paramString1.split("\\|");
      int j = arrayOfString1.length;
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramBoolean)
      {
        String[] arrayOfString2 = paramString2.split("\\|");
        String[] arrayOfString3;
        if (paramString3 != null)
        {
          arrayOfString3 = paramString3.split("\\|");
          int i1 = arrayOfString2.length;
          if (i >= i1)
            break label413;
          if (!a(arrayOfString3[i], arrayOfString2[i]))
            break label185;
          localStringBuilder.append("正确答案：<font color=\"#339a18\">" + arrayOfString2[i].replaceAll("\\/+", " 或者 ") + " <br/>您的答案：" + arrayOfString3[i] + "</font><br/>");
        }
        while (true)
        {
          i++;
          break label70;
          int m = arrayOfString2.length;
          arrayOfString3 = new String[m];
          for (int n = 0; n < m; n++)
            arrayOfString3[n] = " ";
          break;
          localStringBuilder.append("正确答案：<font color=\"#339a18\">" + arrayOfString2[i].replaceAll("\\/+", " 或者 ") + "</font><br/><font color='#ff0000'>您的答案：" + arrayOfString3[i] + "</font><br/>");
        }
      }
      else
      {
        int k = 0;
        if (k < j)
        {
          if (k == -1 + Integer.parseInt(paramString2))
            localStringBuilder.append("<font color='#339a18' >选项" + (k + 1) + "：" + arrayOfString1[k] + " (正确答案)</font><br/>");
          while (true)
          {
            k++;
            break;
            if (arrayOfString1[k].equals(paramString3))
              localStringBuilder.append("<font color='#ff0000'>选项" + (k + 1) + "：" + arrayOfString1[k] + " (您的答案)</font> <br/>");
            else
              localStringBuilder.append("选项" + (k + 1) + "：" + arrayOfString1[k] + "<br/>");
          }
        }
      }
      str = localStringBuilder.toString();
    }
    while (str == null);
    label413: this.b.setText(c.a(str));
  }

  public final int b()
  {
    return this.e;
  }

  public final void b(int paramInt)
  {
    this.f = paramInt;
  }

  public final void b(String paramString)
  {
    if (paramString != null)
      this.c.setText(c.a("<B>习题解析：</B>" + paramString));
  }

  public final int c()
  {
    return this.f;
  }

  public final String d()
  {
    return this.g;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     af
 * JD-Core Version:    0.6.2
 */