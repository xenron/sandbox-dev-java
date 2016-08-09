package org.cdibook.chapter8.replace;

@PojoDoc("myRequestBean")
public class MyRequestBean {

    private String message = "Here is our message";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
