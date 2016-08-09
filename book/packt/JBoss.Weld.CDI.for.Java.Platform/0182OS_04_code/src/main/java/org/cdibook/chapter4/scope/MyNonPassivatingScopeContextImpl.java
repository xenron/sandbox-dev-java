package org.cdibook.chapter4.scope;

import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import java.lang.Class;
import java.lang.Override;
import java.lang.annotation.Annotation;

public class MyNonPassivatingScopeContextImpl implements Context {
    @Override
    public Class<? extends Annotation> getScope() {
        return MyNonPassivatingScope.class;
    }

    @Override
    public <T> T get(Contextual<T> contextual, CreationalContext<T> creationalContext) {
        // Not implemented
        return null;
    }

    @Override
    public <T> T get(Contextual<T> contextual) {
        // Not implemented
        return null;
    }

    @Override
    public boolean isActive() {
        // Not implemented
        return true;
    }
}
