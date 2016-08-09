package org.cdibook.chapter9.bean;

import org.cdibook.chapter9.event.LoggedIn;
import org.cdibook.chapter9.event.LoggedOut;
import org.cdibook.chapter9.model.User;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
public class Authentication implements Serializable {

    private CurrentUser currentUser;

    public void userLoggedIn(@Observes(notifyObserver = Reception.IF_EXISTS) @LoggedIn User loggedInUser) {
        currentUser =
                new CurrentUser(loggedInUser.getId(), loggedInUser.getName(),
                        loggedInUser.getEmail(), loggedInUser.getRole());
    }

    public void userLoggedOut(@Observes(notifyObserver = Reception.IF_EXISTS) @LoggedOut CurrentUser currentUser) {
        if (null != this.currentUser && this.currentUser.equals(currentUser)) {
            this.currentUser = null;
        }
    }

    @Produces
    @Named("currentUser")
    @LoggedIn
    public CurrentUser produceCurrentUser() {
        return null != this.currentUser ? this.currentUser : new CurrentUser();
    }
}
