package org.cdibook.chapter9.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class ParentObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date createdOn = new Date();

    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date updatedOn = new Date();

    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || !(obj instanceof ParentObject)) {
            return false;
        }

        ParentObject parent = (ParentObject) obj;

        if (null != id ? !id.equals(parent.id) : null != parent.id) {
            return false;
        }
        if (null != createdOn ? !createdOn.equals(parent.createdOn) : null != parent.createdOn) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 31 * (null != createdOn ? createdOn.hashCode() : 0);
    }
}
