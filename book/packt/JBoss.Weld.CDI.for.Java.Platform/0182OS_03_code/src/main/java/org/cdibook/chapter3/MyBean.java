package org.cdibook.chapter3;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MyBean {

    private String welcome = "Welcome to JBoss Weld";

    public String getWelcome() {
        return welcome;
    }
}
