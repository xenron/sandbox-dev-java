package org.cdibook.chapter9.interceptor;

import org.cdibook.chapter9.TestDeployment;
import org.cdibook.chapter9.enums.RoleType;
import org.cdibook.chapter9.exception.AuthorizationException;
import org.cdibook.chapter9.model.User;
import org.cdibook.chapter9.service.AbstractServiceTest;
import org.cdibook.chapter9.service.UserService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@RunWith(Arquillian.class)
public class SecurityInterceptorTest extends AbstractServiceTest {

    @Deployment
    public static WebArchive deployment() {
        return TestDeployment.deployment()
                .addAsWebInfResource("META-INF/test-security-beans.xml", "beans.xml")
                .addClass(AbstractServiceTest.class)
                .addClass(UserService.class)
                .addClass(TestService.class);
    }

    @PersistenceContext
    EntityManager em;

    @Inject
    UserTransaction utx;

    @Inject
    BeanManager beanManager;

    @Inject
    UserService userService;

    @Inject
    Instance<TestService> testServiceInstance;

    @Before
    public void prepareTest() throws Exception {
        // Clear old records
        utx.begin();
        em.joinTransaction();
        em.createQuery("delete from User").executeUpdate();
        utx.commit();
    }

    @Override
    protected BeanManager getBeanManager() {
        return beanManager;
    }

    @Test(expected = AuthorizationException.class)
    public void no_role_type_defined() throws Exception {
        // given

        // when
        testServiceInstance.get().testSecureAnnotationMissing();

        // then
        // AuthorizationException thrown
    }

    @Test
    public void test_admin_role_type_ok() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.ADMIN, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        testServiceInstance.get().testSecureAnnotationAdmin();

        // then
    }

    @Test(expected = AuthorizationException.class)
    public void test_admin_role_type_not_ok() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.ORDER_PROCESSOR, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        testServiceInstance.get().testSecureAnnotationAdmin();

        // then
        // AuthorizationException thrown
    }

    @Test
    public void test_user_role_type_ok() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        testServiceInstance.get().testSecureAnnotationUser();

        // then
    }

    @Test
    public void test_multiple_role_types_ok_admin() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.ADMIN, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        testServiceInstance.get().testSecureAnnotationAdminOrder();

        // then
    }

    @Test
    public void test_multiple_role_types_ok_order() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.ORDER_PROCESSOR, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        testServiceInstance.get().testSecureAnnotationAdminOrder();

        // then
    }

    @Test(expected = AuthorizationException.class)
    public void test_multiple_role_types_not_ok() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        testServiceInstance.get().testSecureAnnotationAdminOrder();

        // then
        // AuthorizationException thrown
    }

    @Test
    public void test_guest_role_type_ok() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.GUEST, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        testServiceInstance.get().testSecureAnnotationGuest();

        // then
    }

    @Test(expected = AuthorizationException.class)
    public void test_guest_role_type_not_ok() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        testServiceInstance.get().testSecureAnnotationGuest();

        // then
        // AuthorizationException thrown
    }

    @Test
    public void test_role_on_class_ok() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.ORDER_PROCESSOR, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        testServiceInstance.get().testSecureAnnotationClass();

        // then
    }

    @Test(expected = AuthorizationException.class)
    public void test_role_on_class_not_ok() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        testServiceInstance.get().testSecureAnnotationClass();

        // then
        // AuthorizationException thrown
    }
}
