package packt;

import java.util.Properties;

//public class BaseBoat {
//    private String name;
//    private String country;
//    private int tonnage;
//    private int draft;
//
//    public String getName() {
//        return name;
//    }
//
////    @SuppressWarnings("unchecked")
//    public BaseBoat named(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public BaseBoat country(String country) {
//        this.country = country;
//        return this;
//    }
//
//    public BaseBoat tonnage(int tonnage) {
//        this.tonnage = tonnage;
//        return this;
//    }
//
//    public int getDraft() {
//        return draft;
//    }
//
//    public BaseBoat draft(int draft) {
//        this.draft = draft;
//        return this;
//    }
//
//    public String toString() {
//        return "Name: " + this.name + " Country: " + this.country
//                + " Tonnage: " + this.tonnage + " Draft: " + this.draft;
//    }    
//}

public class BaseBoat<DERIVED extends BaseBoat<DERIVED>> {
    private String name;
    private String country;
    private int tonnage;
    private int draft;

    public String getName() {
        return name;
    }

    public DERIVED named(String name) {
        this.name = name;
        return (DERIVED)this;
    }

    public String getCountry() {
        return country;
    }

    public DERIVED country(String country) {
        this.country = country;
        return (DERIVED)this;
    }

    public DERIVED tonnage(int tonnage) {
        this.tonnage = tonnage;
        return (DERIVED)this;
    }

    public int getDraft() {
        return draft;
    }

    public DERIVED draft(int draft) {
        this.draft = draft;
        return (DERIVED)this;
    }

    public String toString() {
        return "Name: " + this.name + " Country: " + this.country
                + " Tonnage: " + this.tonnage + " Draft: " + this.draft;
    }    
}
