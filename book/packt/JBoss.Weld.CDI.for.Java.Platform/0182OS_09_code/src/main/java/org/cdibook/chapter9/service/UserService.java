package org.cdibook.chapter9.service;

import org.cdibook.chapter9.annotations.Secure;
import org.cdibook.chapter9.annotations.Transactional;
import org.cdibook.chapter9.bean.CurrentUser;
import org.cdibook.chapter9.enums.RoleType;
import org.cdibook.chapter9.event.LoggedIn;
import org.cdibook.chapter9.event.LoggedOut;
import org.cdibook.chapter9.exception.ServiceException;
import org.cdibook.chapter9.model.User;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestScoped
public class UserService extends AbstractService<User> {

    @Inject
    @LoggedIn
    Instance<CurrentUser> currentUserInstance;

    @Inject
    @LoggedIn
    Event<User> userLoggedInEvent;

    @Inject
    @LoggedOut
    Event<CurrentUser> userLoggedOutEvent;

    public UserService() {
        super(User.class);
    }

    @Transactional
    @Secure(rolesAllowed = {RoleType.GUEST, RoleType.ADMIN})
    public void createUser(User user) throws ServiceException {
        if (null != user.getId()) {
            throw new EntityExistsException();
        }
        try {
            getEntityManager().persist(user);
        } catch (ConstraintViolationException cve) {
            throw new ServiceException(cve);
        }
    }

    @Secure(rolesAllowed = RoleType.GUEST)
    public void login(String email, String password) throws ServiceException {
        if (currentUserInstance.get().isLoggedIn()) {
            // Already logged in
            return;
        }

        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        List<User> results = getAll(params);

        if (null == results || results.size() == 0 || results.size() > 1) {
            throw new ServiceException("User record not found.");
        }

        User user = results.get(0);
        if (!user.passwordMatches(password)) {
            throw new ServiceException("Unable to login user.");
        }

        userLoggedInEvent.fire(user);
    }

    @Secure(rolesAllowed = {RoleType.USER, RoleType.ORDER_PROCESSOR, RoleType.ADMIN})
    public void logout() {
        if (!currentUserInstance.get().isLoggedIn()) {
            // Already logged out
            return;
        }

        userLoggedOutEvent.fire(currentUserInstance.get());
    }

    @Transactional
    @Secure(rolesAllowed = {RoleType.USER, RoleType.ORDER_PROCESSOR, RoleType.ADMIN})
    public void changePassword(String currentPassword, String newPassword) throws ServiceException {
        User user = get(currentUserInstance.get().getUserId());
        if (user.passwordMatches(currentPassword)) {
            user.setPassword(newPassword);
        }
    }

    @Override
    protected Predicate[] buildPredicates(Map<String, String> params, CriteriaBuilder criteriaBuilder, Root<User> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (null != params) {
            if (params.containsKey("email")) {
                String email = params.get("email");
                predicates.add(criteriaBuilder.equal(root.get("email"), email));
            }
            if (params.containsKey("roleType")) {
                String roleType = params.get("roleType");
                predicates.add(criteriaBuilder.equal(root.get("roleType"), RoleType.valueOf(roleType)));
            }
            if (params.containsKey("name")) {
                String name = params.get("name");
                predicates.add(criteriaBuilder.equal(root.get("name"), name));
            }
        }

        return predicates.toArray(new Predicate[]{});
    }
}
