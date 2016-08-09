package org.cdibook.chapter9.service;

import org.cdibook.chapter9.TestDeployment;
import org.cdibook.chapter9.enums.RoleType;
import org.cdibook.chapter9.exception.AuthorizationException;
import org.cdibook.chapter9.exception.ServiceException;
import org.cdibook.chapter9.model.Account;
import org.cdibook.chapter9.model.Address;
import org.cdibook.chapter9.model.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class AccountServiceTest extends AbstractServiceTest {

    @Deployment
    public static WebArchive deployment() {
        return TestDeployment.deployment()
                .addAsWebInfResource("META-INF/test-security-beans.xml", "beans.xml")
                .addClass(UserService.class)
                .addClass(AccountService.class)
                .addClass(AbstractServiceTest.class);
    }

    @PersistenceContext
    EntityManager em;

    @Inject
    UserTransaction utx;

    @Inject
    AccountService accountService;

    @Inject
    UserService userService;

    @Inject
    BeanManager beanManager;

    @Before
    public void prepareTest() throws Exception {
        // Clear old records
        utx.begin();
        em.joinTransaction();
        em.createQuery("delete from Account").executeUpdate();
        em.createQuery("delete from User").executeUpdate();
        utx.commit();
    }

    @Override
    protected BeanManager getBeanManager() {
        return beanManager;
    }

    @Test
    public void account_registration() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        Account account = new Account(user);

        // when
        accountService.register(account);
        List<Account> accounts = accountService.getAll(null);

        // then
        assertEquals(1, accounts.size());
        assertEquals(account, accounts.get(0));
    }

    @Test(expected = AuthorizationException.class)
    public void account_registration_fail_auth() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.ORDER_PROCESSOR, "password");
        userService.createUser(user);
        userService.login("newuser@user.com", "password");
        User user2 = new User("New User2", "newuser2@user.com", RoleType.USER, "password");
        Account account = new Account(user2);

        // when
        accountService.register(account);

        // then
        // AuthorizationException thrown
    }

    @Test
    public void account_add_payment_address() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        Account account = new Account(user);

        accountService.register(account);
        List<Account> accounts = accountService.getAll(null);
        userService.login("newuser@user.com", "password");

        Account updated = accounts.get(0);
        Long version = updated.getVersion();
        Address addr = new Address("New User", "line1", null, "city", "state", "zip", "ctry");

        // when
        updated.setPaymentAddress(addr);
        accountService.updateAccount(updated);

        // then
        accounts = accountService.getAll(null);
        updated = accounts.get(0);
        assertNotEquals(version, updated.getVersion());
        assertNotEquals(account, updated);
    }

    @Test(expected = IllegalArgumentException.class)
    public void account_add_payment_address_fail() throws Exception {
        // given
        User user = new User("New User", "newuser@user.com", RoleType.USER, "password");
        Account account = new Account(user);

        accountService.register(account);
        List<Account> accounts = accountService.getAll(null);
        userService.login("newuser@user.com", "password");

        Account updated = accounts.get(0);
        Long version = updated.getVersion();
        Address addr = new Address("New User", null, null, "city", "state", "zip", "ctry");

        // when
        updated.setPaymentAddress(addr);

        // then
        // IllegalArgumentException thrown
    }
}
