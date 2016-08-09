package net.ensode.glassfishbook;

import java.util.Enumeration;

import javax.security.auth.login.LoginException;

import com.sun.appserv.security.AppservPasswordLoginModule;
import com.sun.enterprise.security.auth.realm.InvalidOperationException;
import com.sun.enterprise.security.auth.realm.NoSuchUserException;

public class SimpleLoginModule extends AppservPasswordLoginModule {

    @Override
    protected void authenticateUser() throws LoginException {
        Enumeration userGroupsEnum = null;
        String[] userGroupsArray = null;
        SimpleRealm simpleRealm;

        if (!(_currentRealm instanceof SimpleRealm)) {
            throw new LoginException();
        } else {
            simpleRealm = (SimpleRealm) _currentRealm;
        }

        if (simpleRealm.loginUser(_username, _password)) {
            try {
                userGroupsEnum = simpleRealm.getGroupNames(_username);
            } catch (InvalidOperationException e) {
                throw new LoginException(e.getMessage());
            } catch (NoSuchUserException e) {
                throw new LoginException(e.getMessage());
            }

            userGroupsArray = new String[2];
            int i = 0;

            while (userGroupsEnum.hasMoreElements()) {
                userGroupsArray[i++]
                        = ((String) userGroupsEnum.nextElement());
            }
        } else {
            throw new LoginException();
        }
        commitUserAuthentication(userGroupsArray);
    }
}
