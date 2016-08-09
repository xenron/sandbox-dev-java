package com.oreilly.ajax;

import java.util.ArrayList;
import java.util.Collection;

public class CountryCollection
{
    public static Collection getAllCountries()
    {
        ArrayList countryList = new ArrayList();
        countryList.add("United States");
        countryList.add("Chile");
        countryList.add("Belch Forest");
        countryList.add("Costa Rica");
        countryList.add("Ceylon");
        return countryList;
    }
    
}
