package hjapp.com.hjclass_mobile.b;

import android.os.AsyncTask;
import hjapp.com.hjclass_mobile.d.b;
import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.SAXParserFactory;

public final class s extends AsyncTask
{
  public t a = null;
  private x b = null;

  public s(t paramt)
  {
    this.a = paramt;
  }

  private b a(String[] paramArrayOfString)
  {
    this.b = new x();
    try
    {
      b localb2;
      if (Boolean.parseBoolean(paramArrayOfString[1]))
      {
        String str = paramArrayOfString[0];
        localb2 = new z().a(str);
      }
      b localb1;
      for (localObject = localb2; ; localObject = localb1)
      {
        if ((!isCancelled()) && (this.a != null))
          this.a.b((b)localObject);
        return localObject;
        FileInputStream localFileInputStream = new FileInputStream(new File(paramArrayOfString[0]));
        y localy = new y();
        SAXParserFactory.newInstance().newSAXParser().parse(localFileInputStream, localy);
        localFileInputStream.close();
        localb1 = localy.a();
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     s
 * JD-Core Version:    0.6.2
 */