/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.flowbean;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
@Named
@FlowScoped(value="inscriptionFlow")
public class InscriptionFlowBean {
    private boolean termsAccepted;
    private String name;
    private String school;
    private String address;
    private String allergy;
    
    public String getExitValue(){
        return "/index";//back to index page
    }

    public boolean isTermsAccepted() {
        return termsAccepted;
    }

    public void setTermsAccepted(boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }        

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }        
}
