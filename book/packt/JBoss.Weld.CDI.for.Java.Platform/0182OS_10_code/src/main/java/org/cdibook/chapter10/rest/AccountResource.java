package org.cdibook.chapter10.rest;

import org.cdibook.chapter10.rest.model.GuestUser;
import org.cdibook.chapter10.rest.model.RestResult;
import org.cdibook.chapter9.bean.CurrentUser;
import org.cdibook.chapter9.enums.RoleType;
import org.cdibook.chapter9.event.LoggedIn;
import org.cdibook.chapter9.exception.ServiceException;
import org.cdibook.chapter9.model.Account;
import org.cdibook.chapter9.model.User;
import org.cdibook.chapter9.service.AccountService;
import org.cdibook.chapter9.service.UserService;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountResource {

    @Inject
    @LoggedIn
    Instance<CurrentUser> currentUserInstance;

    @Inject
    AccountService accountService;

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CurrentUser getCurrentUser() {
        return currentUserInstance.get();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResult register(GuestUser guestUser) {
        User user = new User(guestUser.getName(), guestUser.getEmail(), RoleType.USER, guestUser.getPassword());
        Account acct = new Account(user);

        RestResult result = new RestResult();
        try {
            accountService.register(acct);
            result.setSuccess(true);
        } catch (ServiceException e) {
            result.setSuccess(false);
        }
        return result;
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResult login(GuestUser guestUser) {
        RestResult result = new RestResult();
        try {
            userService.login(guestUser.getEmail(), guestUser.getPassword());
            result.setSuccess(true);
        } catch (ServiceException e) {
            result.setSuccess(false);
        }
        return result;
    }

    @GET
    @Path("/logout")
    public void logout() {
        userService.logout();
    }
}
