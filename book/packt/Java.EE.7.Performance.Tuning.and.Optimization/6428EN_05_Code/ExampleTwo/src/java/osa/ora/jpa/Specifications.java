/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package osa.ora.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author VF_Local
 */
@Entity
@Table(name = "specifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specifications.findAll", query = "SELECT s FROM Specifications s"),
    @NamedQuery(name = "Specifications.findById", query = "SELECT s FROM Specifications s WHERE s.id = :id"),
    @NamedQuery(name = "Specifications.findByName", query = "SELECT s FROM Specifications s WHERE s.name = :name")})
public class Specifications implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specifications", fetch = FetchType.LAZY)
    private List<ProductSpecifications> productSpecificationsList;

    public Specifications() {
    }

    public Specifications(Integer id) {
        this.id = id;
    }

    public Specifications(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public List<ProductSpecifications> getProductSpecificationsList() {
        return productSpecificationsList;
    }

    public void setProductSpecificationsList(List<ProductSpecifications> productSpecificationsList) {
        this.productSpecificationsList = productSpecificationsList;
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
        if (!(object instanceof Specifications)) {
            return false;
        }
        Specifications other = (Specifications) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "osa.ora.jpa.Specifications[ id=" + id + " ]";
    }
    
}
