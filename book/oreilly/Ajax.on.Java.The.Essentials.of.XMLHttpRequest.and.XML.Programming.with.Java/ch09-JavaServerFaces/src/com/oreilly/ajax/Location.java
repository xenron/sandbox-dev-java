package com.oreilly.ajax;

import javax.faces.component.html.HtmlInputText;

public class Location
{
  private String city;
  private String state;
  private String zipCode;
  public String getCity()
  {
    return city;
  }
  public void setCity(String city)
  {
    this.city = city;
  }
  public String getState()
  {
    return state;
  }
  public void setState(String state)
  {
    this.state = state;
  }
  public String getZipCode()
  {
    return zipCode;
  }
  public void setZipCode(String zipCode)
  {
    this.zipCode = zipCode;
  }
}
