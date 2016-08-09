/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Myentity.findAll", query = "SELECT m FROM Myentity m"),
    @NamedQuery(name = "Myentity.findById", query = "SELECT m FROM Myentity m WHERE m.id = :id"),
    @NamedQuery(name = "Myentity.findByName", query = "SELECT m FROM Myentity m WHERE m.name = :name"),
    @NamedQuery(name = "Myentity.findByStudentId", query = "SELECT m FROM Myentity m WHERE m.studentId = :studentId")})
public class Myentity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Long id;
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    @Column(name = "STUDENT_ID")
    private String studentId;

    public Myentity() {
    }

    public Myentity(Long id) {
        this.id = id;
    }

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
        if (!(object instanceof Myentity)) {
            return false;
        }
        Myentity other = (Myentity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.packt.ch04.entities.Myentity[ id=" + id + " ]";
    }
    
}
