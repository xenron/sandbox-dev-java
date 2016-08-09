package org.cdibook.chapter9.interceptor;

import org.cdibook.chapter9.annotations.Secure;
import org.cdibook.chapter9.bean.CurrentUser;
import org.cdibook.chapter9.enums.RoleType;
import org.cdibook.chapter9.event.LoggedIn;
import org.cdibook.chapter9.exception.AuthorizationException;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Method;

@Secure
@Interceptor
public class SecurityInterceptor {

    @Inject
    @LoggedIn
    Instance<CurrentUser> currentUserInstance;

    @AroundInvoke
    public Object checkRoles(InvocationContext context) throws Exception {
        // Check for defined roles
        Secure secure = getAnnotation(context.getMethod());
        RoleType[] roles = secure.rolesAllowed();
        if (roles.length == 0) {
            throwException("No RoleType's defined for @Secure: ", context.getMethod());
        }

        boolean roleMatches = false;
        for (int i = 0; i < roles.length; i++) {
            if (roles[i].equals(currentUserInstance.get().getRole())) {
                roleMatches = true;
                break;
            }
        }

        if (!roleMatches) {
            throwException("User does not have permission to call method: ", context.getMethod());
        }
        return context.proceed();
    }

    private void throwException(String msg, Method method) throws AuthorizationException {
        throw new AuthorizationException(msg
                + method.getDeclaringClass().getName()
                + "."
                + method.getName());
    }

    private Secure getAnnotation(Method method) {
        Secure secure = null;
        secure = method.getAnnotation(Secure.class);
        if (null == secure) {
            secure = method.getDeclaringClass().getAnnotation(Secure.class);
        }
        return secure;
    }
}
