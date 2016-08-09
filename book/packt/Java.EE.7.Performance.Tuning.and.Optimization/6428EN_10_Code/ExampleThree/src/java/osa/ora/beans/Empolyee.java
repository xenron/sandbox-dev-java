/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428).
 */

package osa.ora.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Osama Oransa
 */
@Entity
@Table(name = "empolyee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empolyee.findAll", query = "SELECT e FROM Empolyee e"),
    @NamedQuery(name = "Empolyee.findById", query = "SELECT e FROM Empolyee e WHERE e.id = :id"),
    @NamedQuery(name = "Empolyee.findByName", query = "SELECT e FROM Empolyee e WHERE e.name = :name"),
    @NamedQuery(name = "Empolyee.findByTitle", query = "SELECT e FROM Empolyee e WHERE e.title = :title"),
    @NamedQuery(name = "Empolyee.findBySalary", query = "SELECT e FROM Empolyee e WHERE e.salary = :salary"),
    @NamedQuery(name = "Empolyee.findByRole", query = "SELECT e FROM Empolyee e WHERE e.role = :role"),
    @NamedQuery(name = "Empolyee.findByRating", query = "SELECT e FROM Empolyee e WHERE e.rating = :rating")})
public class Empolyee implements Serializable {
    @JoinColumn(name = "contact", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ContactDetails contact;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private int salary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rating")
    private int rating;

    public Empolyee() {
    }

    public Empolyee(Integer id) {
        this.id = id;
    }

    public Empolyee(Integer id, String name, String title, int salary, String role, int rating) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.salary = salary;
        this.role = role;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
        if (!(object instanceof Empolyee)) {
            return false;
        }
        Empolyee other = (Empolyee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "osa.ora.soap.Empolyee[ id=" + id + " ]";
    }

    public ContactDetails getContact() {
        return contact;
    }

    public void setContact(ContactDetails contact) {
        this.contact = contact;
    }
    
}
