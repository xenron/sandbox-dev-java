package org.cdibook.chapter9.service;

import org.cdibook.chapter9.annotations.Secure;
import org.cdibook.chapter9.annotations.Transactional;
import org.cdibook.chapter9.enums.RoleType;
import org.cdibook.chapter9.exception.ServiceException;
import org.cdibook.chapter9.model.Author;
import org.cdibook.chapter9.model.Book;
import org.cdibook.chapter9.model.Category;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityExistsException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestScoped
public class BookService extends AbstractService<Book> {

    public BookService() {
        super(Book.class);
    }

    public List<Category> getCategories() {
        final CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);

        Root<Category> root = criteriaQuery.from(Category.class);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("name")));

        TypedQuery<Category> query = getEntityManager().createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Transactional
    @Secure(rolesAllowed = RoleType.ADMIN)
    public void addCategory(Category category) throws ServiceException {
        if (null != category.getId()) {
            throw new EntityExistsException();
        }
        try {
            getEntityManager().persist(category);
        } catch (ConstraintViolationException cve) {
            throw new ServiceException(cve);
        }
    }

    public List<Author> getAuthors() {
        final CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);

        Root<Author> root = criteriaQuery.from(Author.class);

        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("name")));

        TypedQuery<Author> query = getEntityManager().createQuery(criteriaQuery);
        return query.getResultList();
    }

    public Author getAuthor(String name) {
        final CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);

        Root<Author> root = criteriaQuery.from(Author.class);
        Predicate[] predicates = new Predicate[]{criteriaBuilder.equal(root.get("name"), name)};

        criteriaQuery.select(criteriaQuery.getSelection()).where(predicates);

        TypedQuery<Author> query = getEntityManager().createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Transactional
    @Secure(rolesAllowed = RoleType.ADMIN)
    public void addAuthor(Author author) throws ServiceException {
        if (null != author.getId()) {
            throw new EntityExistsException();
        }

        try {
            getEntityManager().persist(author);
        } catch (ConstraintViolationException cve) {
            throw new ServiceException(cve);
        }
    }

    @Transactional
    @Secure(rolesAllowed = RoleType.ADMIN)
    public void addBook(Book book) throws ServiceException {
        if (null != book.getId()) {
            throw new EntityExistsException();
        }

        try {
            getEntityManager().persist(book);
        } catch (ConstraintViolationException cve) {
            throw new ServiceException(cve);
        }
    }

    @Transactional
    @Secure(rolesAllowed = RoleType.ADMIN)
    public void updateBook(Book book) throws ServiceException {
        if (null == book.getId()) {
            throw new IllegalArgumentException("Book not previously persisted");
        }

        try {
            getEntityManager().merge(book);
        } catch (ConstraintViolationException cve) {
            throw new ServiceException(cve);
        }
    }

    public List<Book> getAvailableBooks() {
        Map<String, String> params = new HashMap<>();
        params.put("available", "true");
        return getAll(params);
    }

    @Override
    protected Predicate[] buildPredicates(Map<String, String> params, CriteriaBuilder criteriaBuilder, Root<Book> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (null != params) {
            if (params.containsKey("available")) {
                Boolean available = Boolean.parseBoolean(params.get("available"));
                predicates.add(criteriaBuilder.equal(root.get("available"), available));
            }
            if (params.containsKey("title")) {
                String title = params.get("title");
                predicates.add(criteriaBuilder.equal(root.get("title"), title));
            }
            if (params.containsKey("categoryId")) {
                Long categoryId = Long.parseLong(params.get("categoryId"));
                predicates.add(criteriaBuilder.equal(root.get("category").get("id"), categoryId));
            }
        }

        return predicates.toArray(new Predicate[]{});
    }
}
