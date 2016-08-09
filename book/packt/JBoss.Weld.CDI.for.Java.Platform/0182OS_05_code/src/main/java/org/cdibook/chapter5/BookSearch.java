package org.cdibook.chapter5;

import java.util.List;

public interface BookSearch {
    String description();

    List<String> search(String term);
}
