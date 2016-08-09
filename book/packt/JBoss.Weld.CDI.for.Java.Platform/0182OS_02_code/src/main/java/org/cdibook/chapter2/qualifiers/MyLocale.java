package org.cdibook.chapter2.qualifiers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Locale;

@ApplicationScoped
public class MyLocale {
    @Inject
    @MyQualifier
    private Locale myLocale;
}
