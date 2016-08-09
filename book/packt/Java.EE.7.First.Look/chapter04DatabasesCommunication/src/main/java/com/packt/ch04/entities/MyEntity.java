/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04.entities;

import java.io.Serializable;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(indexes = @Index(columnList = "name ASC, id DESC"))
public class MyEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;    
    private String name;
    @JoinColumn(foreignKey = @ForeignKey(name = "FK"))
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }        

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyEntity)) {
            return false;
        }
        MyEntity other = (MyEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.packt.ch04.entities.EntityWithIndex[ id=" + id + " ]";
    }
    
}
