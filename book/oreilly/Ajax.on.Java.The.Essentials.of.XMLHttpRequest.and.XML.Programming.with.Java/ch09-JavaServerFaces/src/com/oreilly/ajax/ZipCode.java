
package com.oreilly.ajax;

import javax.faces.component.html.HtmlInputText;


public class ZipCode extends HtmlInputText {

  private String zipcodeId = "0";
  private String stateId = "";
  private String cityId = "";
  private String url = "";

    public ZipCode() {
        super();
        setRendererType("ZipCode");
    }

    public String getCityId()
    {
      return cityId;
    }

    public void setCityId(String cityId)
    {
      this.cityId = cityId;
    }

    public String getStateId()
    {
      return stateId;
    }

    public void setStateId(String stateId)
    {
      this.stateId = stateId;
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
