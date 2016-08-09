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
@Table(name = "order_user_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderUserDetails.findAll", query = "SELECT o FROM OrderUserDetails o"),
    @NamedQuery(name = "OrderUserDetails.findById", query = "SELECT o FROM OrderUserDetails o WHERE o.id = :id"),
    @NamedQuery(name = "OrderUserDetails.findByName", query = "SELECT o FROM OrderUserDetails o WHERE o.name = :name"),
    @NamedQuery(name = "OrderUserDetails.findByCreditCard", query = "SELECT o FROM OrderUserDetails o WHERE o.creditCard = :creditCard"),
    @NamedQuery(name = "OrderUserDetails.findByAddress1", query = "SELECT o FROM OrderUserDetails o WHERE o.address1 = :address1"),
    @NamedQuery(name = "OrderUserDetails.findByAddress2", query = "SELECT o FROM OrderUserDetails o WHERE o.address2 = :address2")})
public class OrderUserDetails implements Serializable {
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
    @Size(min = 1, max = 20)
    @Column(name = "credit_card")
    private String creditCard;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address1")
    private String address1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address2")
    private String address2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDataId", fetch = FetchType.LAZY)
    private List<Orders> ordersList;

    public OrderUserDetails() {
    }

    public OrderUserDetails(Integer id) {
        this.id = id;
    }

    public OrderUserDetails(Integer id, String name, String creditCard, String address1, String address2) {
        this.id = id;
        this.name = name;
        this.creditCard = creditCard;
        this.address1 = address1;
        this.address2 = address2;
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

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @XmlTransient
    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
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
        if (!(object instanceof OrderUserDetails)) {
            return false;
        }
        OrderUserDetails other = (OrderUserDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "osa.ora.jpa.OrderUserDetails[ id=" + id + " ]";
    }
    
}
