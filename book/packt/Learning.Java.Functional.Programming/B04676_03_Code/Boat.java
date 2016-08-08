package packt;

import java.util.Properties;

public class Boat {
    private String name;
    private String country;
    private int tonnage;
    private int draft;

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public Boat setName(String name) {
        this.name = name;
        return this;
    }

    public Boat named(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

//    public void setCountry(String country) {
//        this.country = country;
//    }

    public Boat setCountry(String country) {
        this.country = country;
        return this;
    }

    public Boat country(String country) {
        this.country = country;
        return this;
    }

    public int getTonnage() {
        return tonnage;
    }

//    public void setTonnage(int tonnage) {
//        this.tonnage = tonnage;
//    }

    public Boat setTonnage(int tonnage) {
        this.tonnage = tonnage;
        return this;
    }

    public Boat tonnage(int tonnage) {
        this.tonnage = tonnage;
        return this;
    }

    public int getDraft() {
        return draft;
    }

//    public void setDraft(int draft) {
//        this.draft = draft;
//    }

    public Boat setDraft(int draft) {
        this.draft = draft;
        return this;
    }

    public Boat draft(int draft) {
        this.draft = draft;
        return this;
    }

    public Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("name", this.name); 
        properties.setProperty("country", this.country);  
        properties.setProperty("tonnage", this.tonnage + "");
        properties.setProperty("draft", this.draft + "");
        return properties;
    }
    
    public String toString() {
        return "Name: " + this.name + " Country: " + this.country
                + " Tonnage: " + this.tonnage + " Draft: " + this.draft;
    }
}
