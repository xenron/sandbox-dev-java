/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "html5Bean")
public class Html5FriendlyMarkupBean {
    private Map mapOfParameters;
    private String placeHolder = "Enter your last name";
    
    public Html5FriendlyMarkupBean(){
        mapOfParameters = new HashMap();
        mapOfParameters.put("type","image");
        mapOfParameters.put("src","img_submit.gif"); 
        mapOfParameters.put("width","78"); 
        mapOfParameters.put("height","78");
    }

    public void submitListener(ActionEvent evt){
        System.out.println("submitListener");
    }
    
    public Map getMapOfParameters() {
        return mapOfParameters;
    }

    public void setMapOfParameters(Map mapOfParameters) {
        this.mapOfParameters = mapOfParameters;
    }     

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }       
}
