/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.netbeansbook.jaxrs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author heffel
 */
@Entity
@Table(name = "DISCOUNT_CODE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiscountCode.findAll", query = "SELECT d FROM DiscountCode d"),
    @NamedQuery(name = "DiscountCode.findByDiscountCode", query = "SELECT d FROM DiscountCode d WHERE d.discountCode = :discountCode"),
    @NamedQuery(name = "DiscountCode.findByRate", query = "SELECT d FROM DiscountCode d WHERE d.rate = :rate")})
public class DiscountCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DISCOUNT_CODE")
    private String discountCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RATE")
    private BigDecimal rate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discountCode")
    private Collection<Customer> customerCollection;

    public DiscountCode() {
    }

    public DiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discountCode != null ? discountCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountCode)) {
            return false;
        }
        DiscountCode other = (DiscountCode) object;
        if ((this.discountCode == null && other.discountCode != null) || (this.discountCode != null && !this.discountCode.equals(other.discountCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ensode.netbeansbook.jaxrs.DiscountCode[ discountCode=" + discountCode + " ]";
    }
    
}
