package org.cdibook.chapter9.service;

import org.cdibook.chapter9.annotations.Secure;
import org.cdibook.chapter9.annotations.Transactional;
import org.cdibook.chapter9.enums.RoleType;
import org.cdibook.chapter9.exception.ServiceException;
import org.cdibook.chapter9.model.Account;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.validation.ConstraintViolationException;

@RequestScoped
public class AccountService extends AbstractService<Account> {

    @Inject
    UserService userService;

    public AccountService() {
        super(Account.class);
    }

    @Transactional
    @Secure(rolesAllowed = RoleType.GUEST)
    public void register(Account account) throws ServiceException {
        if (null == account.getUser()) {
            throw new IllegalArgumentException("User can not be null on Account");
        }
        if (null != account.getId()) {
            throw new EntityExistsException();
        }

        userService.createUser(account.getUser());
        try {
            getEntityManager().persist(account);
        } catch (ConstraintViolationException cve) {
            throw new ServiceException(cve);
        }
    }

    @Transactional
    @Secure(rolesAllowed = RoleType.USER)
    public void updateAccount(Account account) throws ServiceException {
        if (null == account.getId()) {
            throw new IllegalArgumentException("Account not previously persisted");
        }
        try {
            getEntityManager().merge(account);
        } catch (ConstraintViolationException cve) {
            throw new ServiceException(cve);
        }
    }
}
