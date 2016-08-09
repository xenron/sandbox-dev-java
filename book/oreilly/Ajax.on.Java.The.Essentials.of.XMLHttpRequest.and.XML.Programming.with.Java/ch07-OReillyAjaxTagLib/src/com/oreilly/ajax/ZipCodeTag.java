package com.oreilly.ajax;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class ZipCodeTag extends TagSupport
{
    private String zipcodeId = "0";
    private String stateId = "";
    private String cityId = "";
    private String url = "";

    public int doStartTag()
    {
        try
        {
            this.pageContext.getOut().print(
                    JavaScriptCode.getZipCodeScript(stateId, cityId, zipcodeId,
                            url));
        }
        catch (IOException e)
        {
            System.out.println("couldn't write JavaScript to jsp"
                    + e.getMessage());
        }
        return EVAL_BODY_INCLUDE;
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
