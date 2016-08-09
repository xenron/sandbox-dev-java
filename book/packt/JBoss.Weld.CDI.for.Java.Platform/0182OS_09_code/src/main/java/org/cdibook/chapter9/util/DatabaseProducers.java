package org.cdibook.chapter9.util;

import org.cdibook.chapter9.annotations.BookDB;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducers {

    @PersistenceContext(unitName = "bookStore")
    private EntityManager em;

    @Produces
    @BookDB
    public EntityManager produceBookDatabase() {
        return em;
    }
}
