/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428).
 */

package osa.ora.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Osama Oransa
 */
@Entity
@Table(name = "contact_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactDetails.findAll", query = "SELECT c FROM ContactDetails c"),
    @NamedQuery(name = "ContactDetails.findById", query = "SELECT c FROM ContactDetails c WHERE c.id = :id"),
    @NamedQuery(name = "ContactDetails.findByStreet", query = "SELECT c FROM ContactDetails c WHERE c.street = :street"),
    @NamedQuery(name = "ContactDetails.findByHome", query = "SELECT c FROM ContactDetails c WHERE c.home = :home"),
    @NamedQuery(name = "ContactDetails.findByCity", query = "SELECT c FROM ContactDetails c WHERE c.city = :city"),
    @NamedQuery(name = "ContactDetails.findByCountry", query = "SELECT c FROM ContactDetails c WHERE c.country = :country"),
    @NamedQuery(name = "ContactDetails.findByPhone", query = "SELECT c FROM ContactDetails c WHERE c.phone = :phone"),
    @NamedQuery(name = "ContactDetails.findByZipCode", query = "SELECT c FROM ContactDetails c WHERE c.zipCode = :zipCode")})
public class ContactDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "street")
    private String street;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "home")
    private String home;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "country")
    private String country;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "zip_code")
    private String zipCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
    private Collection<Empolyee> empolyeeCollection;

    public ContactDetails() {
    }

    public ContactDetails(Integer id) {
        this.id = id;
    }

    public ContactDetails(Integer id, String street, String home, String city, String country, String phone, String zipCode) {
        this.id = id;
        this.street = street;
        this.home = home;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @XmlTransient
    public Collection<Empolyee> getEmpolyeeCollection() {
        return empolyeeCollection;
    }

    public void setEmpolyeeCollection(Collection<Empolyee> empolyeeCollection) {
        this.empolyeeCollection = empolyeeCollection;
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
        if (!(object instanceof ContactDetails)) {
            return false;
        }
        ContactDetails other = (ContactDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "osa.ora.beans.ContactDetails[ id=" + id + " ]";
    }
    
}
