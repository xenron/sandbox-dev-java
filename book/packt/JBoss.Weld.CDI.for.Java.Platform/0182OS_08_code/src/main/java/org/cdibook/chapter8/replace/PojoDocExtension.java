package org.cdibook.chapter8.replace;

import org.apache.deltaspike.core.api.literal.ApplicationScopedLiteral;
import org.apache.deltaspike.core.api.literal.NamedLiteral;
import org.apache.deltaspike.core.api.literal.RequestScopedLiteral;
import org.apache.deltaspike.core.api.literal.SessionScopeLiteral;
import org.apache.deltaspike.core.util.metadata.builder.AnnotatedTypeBuilder;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.util.AnnotationLiteral;
import java.lang.annotation.Annotation;

public class PojoDocExtension implements Extension {

    <X> void processType(@Observes ProcessAnnotatedType<X> event) {
        AnnotatedType<X> orig = event.getAnnotatedType();

        if (orig.isAnnotationPresent(PojoDoc.class)) {
            Annotation scopeAnnotation = null;
            PojoDoc pojoDoc = orig.getAnnotation(PojoDoc.class);
            switch (pojoDoc.scope()) {
                case REQUEST:
                    scopeAnnotation = new RequestScopedLiteral();
                    break;
                case SESSION:
                    scopeAnnotation = new SessionScopeLiteral();
                    break;
                case APPLICATION:
                    scopeAnnotation = new ApplicationScopedLiteral();
                    break;
            }

            AnnotatedType<X> updated = new AnnotatedTypeBuilder<X>()
                    .readFromType(orig, true)
                    .addToClass(
                            new NamedLiteral(pojoDoc.value())
                    )
                    .addToClass(scopeAnnotation)
                    .removeFromClass(PojoDoc.class)
                    .create();

            event.setAnnotatedType(updated);
        }
    }
}
