package org.cdibook.chapter9.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "author", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Author extends ParentObject {

    @Column(length = 80, nullable = false, unique = true)
    @NotNull
    @Size(min = 3, max = 80)
    @Pattern(regexp = "[A-Za-z ]*")
    private String name;

    protected Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || !(obj instanceof Author)) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        } else {
            Author author = (Author) obj;

            if (null != name ? !name.equals(author.name) : null != author.name) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + (null != name ? name.hashCode() : 0);
        return hash;
    }
}
