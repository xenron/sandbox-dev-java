package hjapp.com.umeng.fb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class b
  implements Comparable
{
  public String a = b.class.getSimpleName();
  public b.a b = b.a.d;
  public String c;
  public a d;
  public a e;
  public List f = new ArrayList();

  public b(JSONArray paramJSONArray)
  {
    int i = 0;
    while (true)
      if (i < paramJSONArray.length())
        try
        {
          a locala = new a(paramJSONArray.getJSONObject(i));
          if (locala.g == a.a.b)
            this.b = b.a.c;
          this.f.add(locala);
          i++;
        }
        catch (JSONException localJSONException)
        {
          while (true)
            localJSONException.printStackTrace();
        }
    if (!this.f.isEmpty())
    {
      this.d = ((a)this.f.get(0));
      this.e = ((a)this.f.get(-1 + this.f.size()));
      this.c = this.d.c;
      if (this.f.size() == 1)
      {
        if (((a)this.f.get(0)).g != a.a.b)
          break label208;
        this.b = b.a.b;
      }
    }
    label208: 
    while (((a)this.f.get(0)).g != a.a.a)
      return;
    this.b = b.a.a;
  }

  public int a(b paramb)
  {
    Date localDate1 = this.e.e;
    Date localDate2 = paramb.e.e;
    if ((localDate2 == null) || (localDate1 == null) || (localDate1.equals(localDate2)))
      return 0;
    if (localDate1.after(localDate2))
      return -1;
    return 1;
  }

  public a a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > -1 + this.f.size()))
      return null;
    return (a)this.f.get(paramInt);
  }

  public void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > -1 + this.f.size()))
      return;
    this.f.remove(paramInt);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     b
 * JD-Core Version:    0.6.2
 */