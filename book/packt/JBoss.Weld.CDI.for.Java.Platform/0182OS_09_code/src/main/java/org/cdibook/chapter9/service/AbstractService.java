package org.cdibook.chapter9.service;

import org.cdibook.chapter9.annotations.BookDB;
import org.cdibook.chapter9.annotations.Transactional;
import org.cdibook.chapter9.exception.ServiceException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

public abstract class AbstractService<T> {

    @Inject
    @BookDB
    private EntityManager entityManager;

    private Class<T> entityClass;

    public AbstractService() {
    }

    public AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional
    public T get(Long id) throws ServiceException {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);

        Root<T> root = criteriaQuery.from(entityClass);
        Predicate condition = criteriaBuilder.equal(root.get("id"), id);
        criteriaQuery.select(criteriaBuilder.createQuery(entityClass).getSelection()).where(condition);
        try {
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException nre) {
            throw new ServiceException(nre);
        }
    }

    @Transactional
    public List<T> getAll(Map<String, String> parameters) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);

        Root<T> root = criteriaQuery.from(entityClass);
        Predicate[] predicates = buildPredicates(parameters, criteriaBuilder, root);

        criteriaQuery.select(criteriaQuery.getSelection()).where(predicates);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));

        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    protected Predicate[] buildPredicates(Map<String, String> params, CriteriaBuilder criteriaBuilder, Root<T> root) {
        return new Predicate[]{};
    }
}
