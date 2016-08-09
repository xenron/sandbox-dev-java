package org.cdibook.chapter10.jsf;

import org.cdibook.chapter9.exception.ServiceException;
import org.cdibook.chapter9.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("login")
@RequestScoped
public class LoginBean {
    private String email;
    private String password;

    @Inject
    UserService userService;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void submit() throws ServiceException {
        userService.login(email, password);
    }
}
