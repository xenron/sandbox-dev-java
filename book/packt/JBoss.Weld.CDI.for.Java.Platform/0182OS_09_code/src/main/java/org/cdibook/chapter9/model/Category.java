package org.cdibook.chapter9.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "category", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Category extends ParentObject {

    @Column(length = 80, nullable = false, unique = true)
    @NotNull
    @Size(min = 3, max = 80)
    @Pattern(regexp = "[A-Za-z0-9 ]*")
    private String name;

    protected Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || !(obj instanceof Category)) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        } else {
            Category cat = (Category) obj;

            if (null != name ? !name.equals(cat.name) : null != cat.name) {
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
