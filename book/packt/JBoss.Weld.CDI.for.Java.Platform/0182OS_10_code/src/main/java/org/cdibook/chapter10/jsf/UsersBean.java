package org.cdibook.chapter10.jsf;

import org.cdibook.chapter9.model.User;
import org.cdibook.chapter9.service.UserService;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("users")
@ViewScoped
public class UsersBean implements Serializable {
    @Inject
    UserService userService;

    public List<User> getAllUsers() {
        return userService.getAll(null);
    }
}
