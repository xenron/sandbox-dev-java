package org.cdibook.chapter5;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import java.io.Serializable;

@SessionScoped
public class SearchManager implements Serializable {

    private SearchType searchType = SearchType.FICTION;

    @Produces
    @Preferred
    @SessionScoped
    public BookSearch getSearch(@New FictionSearch fiction, @New NonFictionSearch nonfiction) {
        switch (searchType) {
            case FICTION:
                fiction.setDescription("Hello from Fiction Search!");
                return fiction;
            case NONFICTION:
                return nonfiction;
            default:
                return null;
        }
    }

    public SearchType getType() {
        return searchType;
    }

    public void setType(SearchType type) {
        this.searchType = type;
    }
}
