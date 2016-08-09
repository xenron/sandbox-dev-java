package com.oreilly.ajax;

public class Zipcode
{
    String city;
    String state;
    String zipcode;
    
    public Zipcode()
    {
        zipcode = "";
        city = "";
        state="";
    }

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

    public String getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }
}    