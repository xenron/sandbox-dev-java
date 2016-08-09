package org.cdibook.chapter9.service;

import org.cdibook.chapter9.TestDeployment;
import org.cdibook.chapter9.bean.CurrentUser;
import org.cdibook.chapter9.enums.RoleType;
import org.cdibook.chapter9.exception.AuthorizationException;
import org.cdibook.chapter9.exception.ServiceException;
import org.cdibook.chapter9.model.PasswordEncryptorAccessor;
import org.cdibook.chapter9.model.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class UserServiceTest extends AbstractServiceTest {

    @Deployment
    public static WebArchive deployment() {
        return TestDeployment.deployment()
                .addAsWebInfResource("META-INF/test-security-beans.xml", "beans.xml")
                .addClass(UserService.class)
                .addClass(AbstractServiceTest.class);
    }

    @PersistenceContext
    EntityManager em;

    @Inject
    UserTransaction utx;

    @Inject
    UserService userService;

    @Inject
    BeanManager beanManager;

    @After
    public void clearTest() throws Exception {
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

    @Test
    public void user_registration() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");

        // when
        userService.createUser(user);

        // then
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", user.getEmail())
                .getResultList();
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));
    }

    @Test(expected = ServiceException.class)
    public void user_registration_name_validation_error() throws Exception {
        // given
        User user = new User("NU", "newuser@user.com", RoleType.USER, "password");

        // when
        userService.createUser(user);

        // then
        // ServiceException
    }

    @Test(expected = ServiceException.class)
    public void user_registration_email_validation_error() throws Exception {
        // given
        User user = new User("New User", "newuser.com", RoleType.USER, "password");

        // when
        userService.createUser(user);

        // then
        // ServiceException
    }

    @Test(expected = IllegalArgumentException.class)
    public void user_registration_pwd_validation_error() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "");

        // then
        // IllegalArgumentException
    }

    @Test
    public void user_get_all() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        userService.createUser(user);

        // when
        List<User> users = userService.getAll(null);

        // then
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));
    }

    @Test
    public void user_get() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        userService.createUser(user);

        // when
        User retrieved = userService.get(user.getId());

        // then
        assertNotNull(retrieved);
        assertTrue(user.equals(retrieved));
    }

    @Test(expected = ServiceException.class)
    public void user_does_not_exist_error() throws Exception {
        // given

        // when
        userService.get(Long.parseLong("1"));

        // then
        // ServiceException
    }

    @Test(expected = ServiceException.class)
    public void user_registration_duplicate_error_with_same_details() throws Exception {
        // given
        User user = new User("New User", "newuser.com", RoleType.USER, "password");
        userService.createUser(user);

        // when
        userService.createUser(new User("New User", "newuser.com", RoleType.USER, "password"));

        // then
        // ServiceException
    }

    @Test(expected = ServiceException.class)
    public void user_registration_duplicate_error_with_same_email() throws Exception {
        // given
        User user = new User("New User", "newuser.com", RoleType.USER, "password");
        userService.createUser(user);

        // when
        userService.createUser(new User("Different User", "newuser.com", RoleType.USER, "different"));

        // then
        // ServiceException
    }

    @Test
    public void user_change_password() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        userService.changePassword("password", "changed");

        // then
        User retrieved = userService.get(user.getId());
        assertTrue(PasswordEncryptorAccessor.matches("changed", retrieved.getHashedPassword()));
    }

    @Test(expected = AuthorizationException.class)
    public void user_change_password_error_not_authorized() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        userService.createUser(user);

        // when
        userService.changePassword("password", "changed");

        // then
        // AuthorizationException
    }

    @Test
    public void user_login() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        userService.createUser(user);

        // when
        userService.login("newuser@user.com", "password");

        // then
        CurrentUser current = getBean(CurrentUser.class, "currentUser");
        assertNotNull(current);
        assertEquals(user.getId(), current.getUserId());
        assertEquals(user.getName(), current.getName());
        assertEquals(user.getEmail(), current.getEmail());
        assertEquals(user.getRole(), current.getRole());
    }

    @Test
    public void user_login_failed() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        userService.createUser(user);

        // when
        try {
            userService.login("newuser@user.com", "passwrd");
        } catch (ServiceException se) {
            // Login failed as expected
        } catch (Exception e) {
            fail("ServiceException should have been thrown");
        }

        // then
        CurrentUser current = getBean(CurrentUser.class, "currentUser");
        assertFalse(current.isLoggedIn());
    }

    @Test
    public void user_login_failed_no_user() throws Exception {
        // given
        // No user created

        // when
        try {
            userService.login("newuser@user.com", "password");
        } catch (ServiceException se) {
            // Login failed as expected
        } catch (Exception e) {
            fail("ServiceException should have been thrown");
        }

        // then
        CurrentUser current = getBean(CurrentUser.class, "currentUser");
        assertFalse(current.isLoggedIn());
    }

    @Test
    public void user_login_multiple_records() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        User user2 = new User("New User Two", "newuser2@user.com", RoleType.USER, "password");
        userService.createUser(user);
        userService.createUser(user2);

        // when
        userService.login("newuser@user.com", "password");

        // then
        CurrentUser current = getBean(CurrentUser.class, "currentUser");
        assertNotNull(current);
        assertEquals(user.getId(), current.getUserId());
        assertEquals(user.getName(), current.getName());
        assertEquals(user.getEmail(), current.getEmail());
        assertEquals(user.getRole(), current.getRole());
    }

    @Test
    public void user_logout() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");

        // when
        userService.logout();

        // then
        CurrentUser current = getBean(CurrentUser.class, "currentUser");
        assertNotNull(current);
        assertEquals(null, current.getUserId());
        assertEquals(null, current.getName());
        assertEquals(null, current.getEmail());
        assertEquals(RoleType.GUEST, current.getRole());
    }
}
