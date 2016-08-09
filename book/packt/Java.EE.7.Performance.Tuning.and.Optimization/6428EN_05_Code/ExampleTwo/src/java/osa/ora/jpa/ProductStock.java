/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package osa.ora.jpa;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VF_Local
 */
@Entity
@Table(name = "product_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductStock.findAll", query = "SELECT p FROM ProductStock p"),
    @NamedQuery(name = "ProductStock.findById", query = "SELECT p FROM ProductStock p WHERE p.id = :id"),
    @NamedQuery(name = "ProductStock.findByStockSize", query = "SELECT p FROM ProductStock p WHERE p.stockSize = :stockSize")})
public class ProductStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_size")
    private int stockSize;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product productId;

    public ProductStock() {
    }

    public ProductStock(Integer id) {
        this.id = id;
    }

    public ProductStock(Integer id, int stockSize) {
        this.id = id;
        this.stockSize = stockSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStockSize() {
        return stockSize;
    }

    public void setStockSize(int stockSize) {
        this.stockSize = stockSize;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
        if (!(object instanceof ProductStock)) {
            return false;
        }
        ProductStock other = (ProductStock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "osa.ora.jpa.ProductStock[ id=" + id + " ]";
    }
    
}
