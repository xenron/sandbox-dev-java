/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package osa.ora.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author VF_Local
 */
@Embeddable
public class ProductSpecificationsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "specification_id")
    private int specificationId;

    public ProductSpecificationsPK() {
    }

    public ProductSpecificationsPK(int productId, int specificationId) {
        this.productId = productId;
        this.specificationId = specificationId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(int specificationId) {
        this.specificationId = specificationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productId;
        hash += (int) specificationId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSpecificationsPK)) {
            return false;
        }
        ProductSpecificationsPK other = (ProductSpecificationsPK) object;
        if (this.productId != other.productId) {
            return false;
        }
        if (this.specificationId != other.specificationId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "osa.ora.jpa.ProductSpecificationsPK[ productId=" + productId + ", specificationId=" + specificationId + " ]";
    }
    
}
