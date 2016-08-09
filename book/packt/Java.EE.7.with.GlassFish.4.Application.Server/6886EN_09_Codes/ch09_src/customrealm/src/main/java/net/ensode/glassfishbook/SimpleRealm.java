package net.ensode.glassfishbook;

import java.util.Enumeration;
import java.util.Vector;

import com.sun.enterprise.security.auth.realm.IASRealm;
import com.sun.enterprise.security.auth.realm.InvalidOperationException;
import com.sun.enterprise.security.auth.realm.NoSuchUserException;

public class SimpleRealm extends IASRealm {

    @Override
    public Enumeration getGroupNames(String userName)
            throws InvalidOperationException, NoSuchUserException {
        Vector vector = new Vector();

        vector.add("appuser");
        vector.add("appadmin");

        return vector.elements();
    }

    @Override
    public String getAuthType() {
        return "simple";
    }

    @Override
    public String getJAASContext() {
        return "simpleRealm";
    }

    public boolean loginUser(String userName, String password) {
        boolean loginSuccessful = false;

        if ("glassfish".equals(userName) && "secret".equals(
                password)) {
            loginSuccessful = true;
        }

        return loginSuccessful;
    }
}
