package org.cdibook.chapter2.qualifiermembers;

import javax.enterprise.util.AnnotationLiteral;

public class BookLiteral extends AnnotationLiteral<Book> implements Book {

    private final Category category;
    private final String description;

    public BookLiteral(Category category, String description) {
        this.category = category;
        this.description = description;
    }

    public Category value() {
        return category;
    }

    public String description() {
        return description;
    }
}
