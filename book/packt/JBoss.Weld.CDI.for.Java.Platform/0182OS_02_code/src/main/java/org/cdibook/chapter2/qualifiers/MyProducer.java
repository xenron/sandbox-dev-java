package org.cdibook.chapter2.qualifiers;

import javax.enterprise.inject.Produces;
import java.util.Locale;

public class MyProducer {
    @Produces
    @MyQualifier
    public Locale getMyLocale() {
        return Locale.US;
    }
}
