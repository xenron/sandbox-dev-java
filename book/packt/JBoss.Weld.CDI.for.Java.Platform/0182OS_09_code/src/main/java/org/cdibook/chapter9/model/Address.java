package org.cdibook.chapter9.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable {

    private String name;

    private String line1;

    private String line2;

    private String city;

    private String state;

    private String zip;

    private String country;

    protected Address() {
    }

    public Address(String name, String line1, String line2, String city, String state, String zip, String country) {
        this.name = name;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || !(obj instanceof Address)) {
            return false;
        }

        Address addr = (Address) obj;

        if (null != name ? !name.equals(addr.name) : null != addr.name) {
            return false;
        }
        if (null != line1 ? !line1.equals(addr.line1) : null != addr.line1) {
            return false;
        }
        if (null != line2 ? !line2.equals(addr.line2) : null != addr.line2) {
            return false;
        }
        if (null != city ? !city.equals(addr.city) : null != addr.city) {
            return false;
        }
        if (null != state ? !state.equals(addr.state) : null != addr.state) {
            return false;
        }
        if (null != zip ? !zip.equals(addr.zip) : null != addr.zip) {
            return false;
        }
        if (null != country ? !country.equals(addr.country) : null != addr.country) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = null != name ? name.hashCode() : 0;
        result = 31 * result + (null != line1 ? line1.hashCode() : 0);
        result = 31 * result + (null != line2 ? line2.hashCode() : 0);
        result = 31 * result + (null != city ? city.hashCode() : 0);
        result = 31 * result + (null != state ? state.hashCode() : 0);
        result = 31 * result + (null != zip ? zip.hashCode() : 0);
        result = 31 * result + (null != country ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + ", " + line1 + ", " + line2 + ", " + city + ", " + state + ", " + zip + ", " + country;
    }
}
