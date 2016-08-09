package org.cdibook.chapter5;

import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.List;

@RequestScoped
public class FictionSearch implements BookSearch, Serializable {
    private String description = "Welcome to searching for fiction!";

    @Override
    public String description() {
        return description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    @Override
    public List<String> search(String term) {
        // Not implemented
        return null;
    }
}
