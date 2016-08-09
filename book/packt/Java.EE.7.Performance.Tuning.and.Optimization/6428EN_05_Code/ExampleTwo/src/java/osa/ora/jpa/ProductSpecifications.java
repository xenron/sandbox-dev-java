/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package osa.ora.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author VF_Local
 */
@Entity
@Table(name = "product_specifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSpecifications.findAll", query = "SELECT p FROM ProductSpecifications p"),
    @NamedQuery(name = "ProductSpecifications.findByProductId", query = "SELECT p FROM ProductSpecifications p WHERE p.productSpecificationsPK.productId = :productId"),
    @NamedQuery(name = "ProductSpecifications.findBySpecificationId", query = "SELECT p FROM ProductSpecifications p WHERE p.productSpecificationsPK.specificationId = :specificationId"),
    @NamedQuery(name = "ProductSpecifications.findByValue", query = "SELECT p FROM ProductSpecifications p WHERE p.value = :value")})
public class ProductSpecifications implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductSpecificationsPK productSpecificationsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "specification_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Specifications specifications;

    public ProductSpecifications() {
    }

    public ProductSpecifications(ProductSpecificationsPK productSpecificationsPK) {
        this.productSpecificationsPK = productSpecificationsPK;
    }

    public ProductSpecifications(ProductSpecificationsPK productSpecificationsPK, String value) {
        this.productSpecificationsPK = productSpecificationsPK;
        this.value = value;
    }

    public ProductSpecifications(int productId, int specificationId) {
        this.productSpecificationsPK = new ProductSpecificationsPK(productId, specificationId);
    }

    public ProductSpecificationsPK getProductSpecificationsPK() {
        return productSpecificationsPK;
    }

    public void setProductSpecificationsPK(ProductSpecificationsPK productSpecificationsPK) {
        this.productSpecificationsPK = productSpecificationsPK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productSpecificationsPK != null ? productSpecificationsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSpecifications)) {
            return false;
        }
        ProductSpecifications other = (ProductSpecifications) object;
        if ((this.productSpecificationsPK == null && other.productSpecificationsPK != null) || (this.productSpecificationsPK != null && !this.productSpecificationsPK.equals(other.productSpecificationsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "osa.ora.jpa.ProductSpecifications[ productSpecificationsPK=" + productSpecificationsPK + " ]";
    }
    
}
