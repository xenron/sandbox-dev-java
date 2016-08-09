package net.ensode.glassfishbook.customtags;

public class AddressBean
{
  private String addressType;
  private String line1;
  private String line2;
  private String city;
  private String state = "";
  private String zip;

  public String getAddressType()
  {
    return addressType;
  }

  public void setAddressType(String addressType)
  {
    this.addressType = addressType;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public String getLine1()
  {
    return line1;
  }

  public void setLine1(String line1)
  {
    this.line1 = line1;
  }

  public String getLine2()
  {
    return line2;
  }

  public void setLine2(String line2)
  {
    this.line2 = line2;
  }

  public String getState()
  {
    return state;
  }

  public void setState(String state)
  {
    this.state = state;
  }

  public String getZip()
  {
    return zip;
  }

  public void setZip(String zip)
  {
    this.zip = zip;
  }

}
