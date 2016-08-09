package com.baselogic.javaee6.jaxrs.resources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerNotFoundDetails {
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
