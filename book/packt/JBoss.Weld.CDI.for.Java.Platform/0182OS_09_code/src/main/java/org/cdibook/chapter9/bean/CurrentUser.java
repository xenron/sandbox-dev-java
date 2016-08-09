package org.cdibook.chapter9.bean;

import org.cdibook.chapter9.enums.RoleType;
import org.cdibook.chapter9.event.LoggedIn;
import org.cdibook.chapter9.event.LoggedOut;
import org.cdibook.chapter9.model.User;

import javax.enterprise.event.Observes;
import java.io.Serializable;

public class CurrentUser implements Serializable {

    private boolean loggedIn = false;

    private Long userId;

    private String name;

    private String email;

    private RoleType role = RoleType.GUEST;

    public CurrentUser() {
    }

    public CurrentUser(Long id, String name, String email, RoleType role) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.loggedIn = true;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public RoleType getRole() {
        return role;
    }

    public void userLoggedIn(@Observes @LoggedIn User loggedInUser) {
        this.userId = loggedInUser.getId();
        this.name = loggedInUser.getName();
        this.email = loggedInUser.getEmail();
        this.role = loggedInUser.getRole();
        this.loggedIn = true;
    }

    public void userLoggedOut(@Observes @LoggedOut CurrentUser currentUser) {
        this.userId = null;
        this.name = null;
        this.email = null;
        this.role = RoleType.GUEST;
        this.loggedIn = false;
    }

}
