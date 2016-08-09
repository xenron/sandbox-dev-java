package org.cdibook.chapter5;

import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.List;

@RequestScoped
public class NonFictionSearch implements BookSearch, Serializable {
    @Override
    public String description() {
        return "Welcome to Non Fiction searching";
    }

    @Override
    public List<String> search(String term) {
        // Not implemented
        return null;
    }
}
