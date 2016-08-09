/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@NamedEntityGraph(name="includeThis", attributeNodes={@NamedAttributeNode("students")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String id;
    private String name;
    private Integer nbrlevel;
    private String phone;    
    @OneToMany(mappedBy = "depart",fetch = FetchType.LAZY)
    private List<Student> students;

    public Department() {
    }

    public Department(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNbrlevel() {
        return nbrlevel;
    }

    public void setNbrlevel(Integer nbrlevel) {
        this.nbrlevel = nbrlevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.packt.ch04.entities.Department[ id=" + id + " ]";
    }
    
}
