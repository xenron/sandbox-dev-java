/*
 * 
 * 
 * 
 */
package net.ensode.glassfishbook.websocketchat.named;

import javax.enterprise.inject.Model;

/**
 *
 * @author heffel
 */
@Model
public class User {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
