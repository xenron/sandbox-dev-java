package org.cdibook.chapter5;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class Page {
    @Inject
    FictionSearch fictionSearch;

    @Inject
    @Preferred
    BookSearch search;

    public String getDescription() {
        return fictionSearch.description();
    }

    public String getSessionDescription() {
        return search.description();
    }
}
