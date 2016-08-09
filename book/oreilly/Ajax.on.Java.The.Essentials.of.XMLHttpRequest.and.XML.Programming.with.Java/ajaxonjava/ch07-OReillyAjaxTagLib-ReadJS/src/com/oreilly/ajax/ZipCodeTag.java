package com.oreilly.ajax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.jsp.tagext.TagSupport;

public class ZipCodeTag extends TagSupport
{
  private String zipcodeId = "0";

  private String stateId = "";

  private String cityId = "";

  private String url = "";

  static String javaScript;

  private String getJavaScript()
  {
    if (javaScript != null)
    {
      return javaScript;
    }
    else
    {
      String tempString = "";
      String outString = "";

      try
      {

        InputStream is = getClass().getResourceAsStream("oreillyajaxtags.js");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((tempString = br.readLine()) != null)
        {
          outString += tempString;
        }

        outString = outString.replaceAll("stateId", stateId);
        outString = outString.replaceAll("cityId", cityId);
        outString = outString.replaceAll("zipcodeId", zipcodeId);
        outString = outString.replaceAll("urlName", url);
        br.close();
        is.close();
        javaScript = outString;

      } catch (IOException e)
      {
        System.out.println("couldn't get JavaScript from oreillyajaxtags.js"
            + e.getMessage());
      }
    }
    return javaScript;
  }

  public int doStartTag()
  {
    try
    {
      pageContext.getOut().print(getJavaScript());
    } catch (IOException e)
    {
      System.out.println("couldn't write JavaScript to jsp" + e.getMessage());
    }
    return SKIP_BODY;
  }

  public String getCityId()
  {
    return cityId;
  }

  public void setCityId(String city)
  {
    this.cityId = city;
  }

  public String getStateId()
  {
    return stateId;
  }

  public void setStateId(String state)
  {
    this.stateId = state;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  public String getZipcodeId()
  {
    return zipcodeId;
  }

  public void setZipcodeId(String zipcodeId)
  {
    this.zipcodeId = zipcodeId;
  }
}
