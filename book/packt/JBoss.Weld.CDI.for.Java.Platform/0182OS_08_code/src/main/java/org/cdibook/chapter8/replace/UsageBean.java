package org.cdibook.chapter8.replace;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UsageBean {
    @Inject
    MyRequestBean requestBean;

    @Inject
    MySessionBean sessionBean;
}
