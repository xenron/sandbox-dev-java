package com.oreilly.ajax;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.render.Renderer;
import javax.faces.webapp.UIComponentTag;

public final class ZipCodeTag extends UIComponentTag
{
  private String zipcodeId = "0";
  private String stateId = "";
  private String cityId = "";
  private String url = "";

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
  public String getComponentType()
  {
    return "oreilly.ajax.ZipCode";
  }
  public String getRendererType()
  {
    return "ZipCode"; // ZipCodeRenderer
  }
  public void release()
  {
    zipcodeId = null;
    stateId = null;
    cityId = null;
    url = null;
  }
  protected void setProperties(UIComponent component)
  {
    super.setProperties(component);
    ZipCode input = null;

    try
    {
      input = (ZipCode) component;
    }
    catch (ClassCastException cce)
    {
      throw new IllegalStateException(
          "Component "
              + component.toString()
              + " not expected type.  Expected: ZipCode.  Perhaps you're missing a tag?");
    }
    FacesContext context = getFacesContext();
    if (cityId != null)
    {
      if (isValueReference(cityId))
      {
        ValueBinding vb = context.getApplication().createValueBinding(cityId);
        component.setValueBinding("cityId", vb);
      }
      else
      {
        input.setCityId(cityId);
      }
    }
  }
}
