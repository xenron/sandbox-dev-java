package org.cdibook.chapter9.interceptor;

import org.cdibook.chapter9.annotations.Secure;
import org.cdibook.chapter9.enums.RoleType;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@Secure(rolesAllowed = RoleType.ORDER_PROCESSOR)
public class TestService {
    @Secure()
    public void testSecureAnnotationMissing() {}

    @Secure(rolesAllowed = RoleType.ADMIN)
    public void testSecureAnnotationAdmin() {}

    @Secure(rolesAllowed = RoleType.USER)
    public void testSecureAnnotationUser() {}

    @Secure(rolesAllowed = {RoleType.ADMIN, RoleType.ORDER_PROCESSOR})
    public void testSecureAnnotationAdminOrder() {}

    @Secure(rolesAllowed = RoleType.GUEST)
    public void testSecureAnnotationGuest() {}

    public void testSecureAnnotationClass() {}
}
