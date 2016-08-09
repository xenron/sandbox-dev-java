/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package osa.ora.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VF_Local
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name = "Orders.findByOrderRef", query = "SELECT o FROM Orders o WHERE o.orderRef = :orderRef"),
    @NamedQuery(name = "Orders.findByTotalPrice", query = "SELECT o FROM Orders o WHERE o.totalPrice = :totalPrice"),
    @NamedQuery(name = "Orders.findByStatus", query = "SELECT o FROM Orders o WHERE o.status = :status"),
    @NamedQuery(name = "Orders.findByDate", query = "SELECT o FROM Orders o WHERE o.date = :date"),
    @NamedQuery(name = "Orders.findByExpectedDate", query = "SELECT o FROM Orders o WHERE o.expectedDate = :expectedDate")})
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "order_ref")
    private String orderRef;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price")
    private float totalPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expected_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedDate;
    @JoinColumn(name = "user_data_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderUserDetails userDataId;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Orders(Integer id, String orderRef, float totalPrice, int status, Date date, Date expectedDate) {
        this.id = id;
        this.orderRef = orderRef;
        this.totalPrice = totalPrice;
        this.status = status;
        this.date = date;
        this.expectedDate = expectedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public OrderUserDetails getUserDataId() {
        return userDataId;
    }

    public void setUserDataId(OrderUserDetails userDataId) {
        this.userDataId = userDataId;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "osa.ora.jpa.Orders[ id=" + id + " ]";
    }
    
}
