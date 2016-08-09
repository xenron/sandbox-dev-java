package org.cdibook.chapter9.service;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

public abstract class AbstractServiceTest {

    protected <T> T getBean(Class<T> type, String elName) {
        BeanManager bm = getBeanManager();
        Bean bean = bm.getBeans(elName).iterator().next();
        CreationalContext context = bm.createCreationalContext(bean);
        return (T) bm.getReference(bean, type, context);
    }

    protected abstract BeanManager getBeanManager();
}
