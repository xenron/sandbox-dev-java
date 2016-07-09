package hjapp.com.hjclass_mobile.b;

import hjapp.com.hjclass_mobile.d.ad;
import hjapp.com.hjclass_mobile.d.ae;
import hjapp.com.hjclass_mobile.d.b;
import hjapp.com.hjclass_mobile.d.c;
import hjapp.com.hjclass_mobile.d.d;
import hjapp.com.hjclass_mobile.d.e;
import hjapp.com.hjclass_mobile.d.f;
import hjapp.com.hjclass_mobile.d.g;
import hjapp.com.hjclass_mobile.d.h;
import hjapp.com.hjclass_mobile.d.j;
import hjapp.com.hjclass_mobile.d.k;
import hjapp.com.hjclass_mobile.d.l;
import hjapp.com.hjclass_mobile.d.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hjapp.com.hjclass_mobile.d.y;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public final class z
{
  private static int a(Element paramElement, String paramString)
  {
    String str = paramElement.attributeValue(paramString);
    if (str == null)
      return 0;
    return (int)Float.parseFloat(str);
  }

  private static List a(Document paramDocument)
  {
    Element localElement1 = paramDocument.getRootElement();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localElement1.elementIterator("page");
    while (localIterator.hasNext())
    {
      y localy = new y();
      Element localElement2 = (Element)localIterator.next();
      localy.a(b(localElement2, "backgroundUrl"));
      localy.a(Integer.valueOf(Integer.parseInt(b(localElement2, "pageIndex"))));
      localy.b(b(localElement2, "pageType"));
      localy.b(Integer.valueOf(hjapp.com.hjclass_mobile.h.z.a(localElement2.attributeValue("timeStamp"))));
      localy.a(a(localElement2));
      localArrayList.add(localy);
    }
    return localArrayList;
  }

  private static List a(Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramElement.elements("ele").iterator();
    if (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      l locall = new l();
      locall.a(localElement.attributeValue("type"));
      if (locall.a().endsWith("swf"))
      {
        hjapp.com.hjclass_mobile.d.i locali = new hjapp.com.hjclass_mobile.d.i();
        locali.a(a(localElement, "x"));
        locali.b(a(localElement, "y"));
        locali.c(a(localElement, "width"));
        locali.d(a(localElement, "height"));
        locali.e(a(localElement, "step"));
        locali.a(b(localElement, "step"));
        locali.b(b(localElement, "step"));
        locall.a(locali);
      }
      while (true)
      {
        localArrayList.add(locall);
        break;
        if (locall.a().endsWith("pic"))
        {
          d locald = new d();
          locald.a(a(localElement, "x"));
          locald.b(a(localElement, "y"));
          locald.c(a(localElement, "width"));
          locald.d(a(localElement, "height"));
          locald.a(c(localElement, "effFlag").booleanValue());
          locald.b(b(localElement, "endEffName"));
          locald.f(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "endEffTime")));
          locald.a(b(localElement, "startEffName"));
          locald.e(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "startEffTime")));
          locald.a(Float.parseFloat(localElement.attributeValue("rotation")));
          locald.c(localElement.elementTextTrim("url"));
          locald.b(c(localElement, "strokeFlag").booleanValue());
          locald.c(c(localElement, "shadowFlag").booleanValue());
          locald.d(b(localElement, "strokeFilter"));
          locall.a(locald);
        }
        else if ((locall.a().endsWith("txt")) || (locall.a().endsWith("textarea")))
        {
          hjapp.com.hjclass_mobile.d.j localj = new j();
          localj.a(a(localElement, "x"));
          localj.b(a(localElement, "y"));
          localj.c(a(localElement, "width"));
          localj.d(a(localElement, "height"));
          localj.a(c(localElement, "effFlag").booleanValue());
          localj.c(b(localElement, "endEffName"));
          localj.f(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "endEffTime")));
          localj.b(b(localElement, "startEffName"));
          localj.e(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "startEffTime")));
          localj.a(localElement.elementTextTrim("content"));
          locall.a(localj);
        }
        else if (locall.a().endsWith("timer"))
        {
          k localk = new k();
          localk.a(a(localElement, "x"));
          localk.b(a(localElement, "y"));
          localk.c(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "delay")));
          localk.d(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "stop")));
          locall.a(localk);
        }
        else if (locall.a().endsWith("videomark"))
        {
          f localf = new f();
          localf.a(a(localElement, "x"));
          localf.b(a(localElement, "y"));
          localf.c(a(localElement, "width"));
          localf.d(a(localElement, "height"));
          localf.a(b(localElement, "videoShowType"));
          locall.a(localf);
        }
        else if (locall.a().endsWith("wordart"))
        {
          hjapp.com.hjclass_mobile.d.m localm = new m();
          localm.a(a(localElement, "x"));
          localm.b(a(localElement, "y"));
          localm.c(a(localElement, "width"));
          localm.d(a(localElement, "height"));
          localm.a(c(localElement, "effFlag").booleanValue());
          localm.b(b(localElement, "endEffName"));
          localm.f(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "endEffTime")));
          localm.a(b(localElement, "startEffName"));
          localm.e(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "startEffTime")));
          localm.c(localElement.elementTextTrim("releaseUrl"));
          locall.a(localm);
        }
        else
        {
          if (locall.a().endsWith("audio"))
          {
            hjapp.com.hjclass_mobile.d.c localc = new c();
            localc.a(a(localElement, "x"));
            localc.b(a(localElement, "y"));
            localc.a(c(localElement, "effFlag").booleanValue());
            localc.c(b(localElement, "endEffName"));
            localc.d(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "endEffTime")));
            localc.b(b(localElement, "startEffName"));
            localc.c(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "startEffTime")));
            String str1 = localElement.elementTextTrim("url");
            if (str1 == null)
              str1 = b(localElement, "url");
            localc.a(str1);
            String str2 = b(localElement, "mode");
            if (str2 == null)
              localc.d("TYPE_LONG");
            while (true)
            {
              locall.a(localc);
              break;
              localc.d(str2);
            }
          }
          if (locall.a().endsWith("video"))
          {
            e locale = new e();
            locale.a(a(localElement, "x"));
            locale.b(a(localElement, "y"));
            locale.e(a(localElement, "width"));
            locale.f(a(localElement, "height"));
            locale.a(c(localElement, "effFlag").booleanValue());
            locale.c(b(localElement, "endEffName"));
            locale.d(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "endEffTime")));
            locale.b(b(localElement, "startEffName"));
            locale.c(hjapp.com.hjclass_mobile.h.z.a(b(localElement, "startEffTime")));
            locale.a(localElement.elementTextTrim("url"));
            locall.a(locale);
          }
          else if ((locall.a().endsWith("3")) || (locall.a().endsWith("1")) || (locall.a().endsWith("2")))
          {
            locall.a(b(localElement));
          }
          else if (locall.a().endsWith("summaryQestion"))
          {
            hjapp.com.hjclass_mobile.d.h localh = new h();
            localh.a(b(localElement, "type"));
            localh.a(c(localElement));
            locall.a(localh);
          }
          else if (locall.a().endsWith("summaryPage"))
          {
            ae localae = new ae();
            localae.a(b(localElement, "type"));
            localae.a(a(localElement, "summaryType"));
            locall.a(localae);
          }
        }
      }
    }
    return localArrayList;
  }

  private static ad b(Element paramElement)
  {
    ad localad = new ad();
    localad.f(b(paramElement, "answer"));
    localad.b(a(paramElement, "type"));
    localad.a(c(paramElement, "isRandom"));
    localad.a(b(paramElement, "langs"));
    localad.a(a(paramElement, "questionID"));
    localad.j();
    Iterator localIterator = paramElement.elements("ele").iterator();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      String str4 = b(localElement, "type");
      if ((str4.equals("questionTxtArea")) || (str4.equals("questionTxt")))
        localad.b(localElement.elementTextTrim("content"));
      else if (str4.equals("QuestionTxtTitle"))
        localad.j(localElement.elementTextTrim("content"));
      else if (str4.equals("questionPic"))
        localad.c(localElement.elementTextTrim("url"));
      else if (str4.equals("questionAudio"))
        localad.h(localElement.elementTextTrim("url"));
      else if (str4.equals("questionAudioOption"))
        str1 = str1 + localElement.elementTextTrim("url") + "|";
      else if (str4.equals("questionTxtOption"))
        str3 = str3 + hjapp.com.hjclass_mobile.h.z.d(localElement.elementTextTrim("content")) + "|";
      else if (str4.equals("questionPicOption"))
        str2 = str2 + localElement.elementTextTrim("url") + "|";
      else if (str4.equals("questionSolution"))
        localad.g(localElement.elementTextTrim("content"));
    }
    if (str1 != "")
      localad.i(str1.substring(0, -1 + str1.length()));
    if (str2 != "")
      localad.e(str2.substring(0, -1 + str2.length()));
    if (str3 != "")
      localad.d(str3.substring(0, -1 + str3.length()));
    return localad;
  }

  private static String b(Element paramElement, String paramString)
  {
    String str = paramElement.attributeValue(paramString);
    if (str != null)
      return hjapp.com.hjclass_mobile.h.y.b(str);
    return null;
  }

  private static Boolean c(Element paramElement, String paramString)
  {
    return Boolean.valueOf(Boolean.parseBoolean(paramElement.attributeValue(paramString)));
  }

  private static List c(Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Element)paramElement.elements("qlist").get(0)).elements("q").iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      g localg = new g();
      localg.a(b(localElement, "answer"));
      localg.a(a(localElement, "questionID"));
      localg.c(localElement.elementTextTrim("t").replace("<P>", "").replace("</P>", "<br/>"));
      localg.d(localElement.elementTextTrim("sol"));
      localg.e(localElement.elementTextTrim("op"));
      localg.f(localElement.elementTextTrim("iop"));
      localg.a(Integer.parseInt(b(localElement, "questionID")));
      localg.b(b(localElement, "type"));
      localArrayList.add(localg);
    }
    return localArrayList;
  }

  public final b a(String paramString)
  {
    Document localDocument = new SAXReader().read(new File(paramString));
    b localb = new b();
    Element localElement = localDocument.getRootElement().element("lessonInfo");
    localb.a(Integer.valueOf(Integer.parseInt(localElement.elementText("classID"))));
    localb.b(Integer.valueOf(Integer.parseInt(localElement.elementText("lessonID"))));
    localb.a(localElement.elementText("lessonName"));
    localb.b(localElement.elementText("mediaAudio"));
    localb.c(Integer.valueOf(Integer.parseInt(localElement.elementText("totalTime"))));
    localb.b(Boolean.valueOf(Boolean.parseBoolean(localElement.elementText("isComment"))));
    localb.a(Boolean.valueOf(Boolean.parseBoolean(localElement.elementText("isStudy"))));
    localb.c(Boolean.valueOf(Boolean.parseBoolean(localElement.elementText("isLastLesson"))));
    localb.c(localElement.elementTextTrim("mediaType"));
    localb.a(a(localDocument));
    return localb;
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     z
 * JD-Core Version:    0.6.2
 */