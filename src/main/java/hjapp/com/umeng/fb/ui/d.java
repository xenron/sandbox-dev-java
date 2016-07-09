package hjapp.com.umeng.fb.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import hjapp.com.umeng.fb.a.b;

import java.util.Collections;
import java.util.List;

import org.json.JSONArray;

public class d extends BaseAdapter
{
  LayoutInflater a;
  Context b;
  List c;
  JSONArray d;
  String[] e;
  String f = "";
  String g = "FeedbackListAdapter";

  public d(Context paramContext, List paramList)
  {
    this.b = paramContext;
    this.a = LayoutInflater.from(paramContext);
    Collections.sort(paramList);
    this.c = paramList;
  }

  private String a(hjapp.com.umeng.fb.b paramb)
  {
    return paramb.d.a();
  }

  private String b(hjapp.com.umeng.fb.b paramb)
  {
    if (paramb.b == b.a.d)
      for (int i = -1 + paramb.f.size(); i >= 0; i--)
      {
        a.a locala = paramb.a(i).g;
        if (locala == a.a.a)
          return this.b.getString(e.g(this.b));
        if (locala == a.a.b)
          return this.b.getString(e.h(this.b));
        if (locala == a.a.d)
          return this.b.getString(e.i(this.b));
      }
    if (paramb.b == b.a.b)
      return this.b.getString(e.j(this.b));
    if (paramb.b == b.a.a)
      return this.b.getString(e.g(this.b));
    return "";
  }

  private String c(hjapp.com.umeng.fb.b paramb)
  {
    if ((paramb.f.size() != 1) && (paramb.e.f == a.b.c))
      return paramb.e.a();
    return null;
  }

  private String d(hjapp.com.umeng.fb.b paramb)
  {
    return hjapp.com.umeng.fb.util.a.a(paramb.e.e, this.b);
  }

  public b.a a(int paramInt)
  {
    return ((hjapp.com.umeng.fb.b)this.c.get(paramInt)).b;
  }

  public void a(List paramList)
  {
    Collections.sort(paramList);
    this.c = paramList;
  }

  public hjapp.com.umeng.fb.b b(int paramInt)
  {
    return (hjapp.com.umeng.fb.b)this.c.get(paramInt);
  }

  public int getCount()
  {
    return this.c.size();
  }

  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    d.a locala;
    hjapp.com.umeng.fb.b localb;
    String str2;
    String str3;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.a.inflate(hjapp.com.umeng.fb.b.d.b(this.b), null);
      locala = new d.a(this);
      locala.a = ((ImageView)paramView.findViewById(hjapp.com.umeng.fb.b.c.g(this.b)));
      locala.b = ((TextView)paramView.findViewById(hjapp.com.umeng.fb.b.c.h(this.b)));
      locala.c = ((TextView)paramView.findViewById(hjapp.com.umeng.fb.b.c.i(this.b)));
      locala.d = ((TextView)paramView.findViewById(hjapp.com.umeng.fb.b.c.j(this.b)));
      paramView.setTag(locala);
      localb = (hjapp.com.umeng.fb.b)this.c.get(paramInt);
      String str1 = a(localb);
      str2 = c(localb);
      str3 = b(localb);
      String str4 = d(localb);
      locala.b.setText(str1);
      if (str2 != null)
        break label259;
      locala.c.setVisibility(8);
      label191: if (!hjapp.com.umeng.common.b.b.c(str3))
        break label281;
      locala.d.setText(str4);
    }
    while (true)
    {
      if (!hjapp.com.umeng.fb.util.c.a(this.b, localb))
        break label294;
      locala.a.setVisibility(0);
      locala.a.setBackgroundResource(hjapp.com.umeng.fb.b.b.a(this.b));
      return paramView;
      locala = (d.a)paramView.getTag();
      break;
      label259: locala.c.setVisibility(0);
      locala.c.setText(str2);
      break label191;
      label281: locala.d.setText(str3);
    }
    label294: locala.a.setVisibility(4);
    return paramView;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     d
 * JD-Core Version:    0.6.2
 */