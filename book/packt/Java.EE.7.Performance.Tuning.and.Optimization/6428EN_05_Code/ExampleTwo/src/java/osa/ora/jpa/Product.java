/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package osa.ora.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author VF_Local
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByDesc", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price < :price and p.active = 0"),
    @NamedQuery(name = "Product.findByCategoryId", query = "SELECT p FROM Product p WHERE p.categoryId.id = :categoryId and p.active = 0"),
    @NamedQuery(name = "Product.findByPriceCategoryDesc", query = "SELECT p FROM Product p WHERE p.price < :price and p.categoryId.id = :categoryId and p.description like :description and p.active = 0"),
    @NamedQuery(name = "Product.findByStartDate", query = "SELECT p FROM Product p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Product.findByShippingDays", query = "SELECT p FROM Product p WHERE p.shippingDays = :shippingDays"),
    @NamedQuery(name = "Product.findByActive", query = "SELECT p FROM Product p WHERE p.active = 0")})
public class Product implements Serializable {
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
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping_days")
    private int shippingDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductSpecifications> productSpecificationsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId", fetch = FetchType.LAZY)
    private List<ProductReviews> productReviewsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId", fetch = FetchType.LAZY)
    private List<ProductStock> productStockList;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, String desc, float price, Date startDate, int shippingDays, boolean active) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.price = price;
        this.startDate = startDate;
        this.shippingDays = shippingDays;
        this.active = active;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getShippingDays() {
        return shippingDays;
    }

    public void setShippingDays(int shippingDays) {
        this.shippingDays = shippingDays;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @XmlTransient
    public List<ProductSpecifications> getProductSpecificationsList() {
        return productSpecificationsList;
    }

    public void setProductSpecificationsList(List<ProductSpecifications> productSpecificationsList) {
        this.productSpecificationsList = productSpecificationsList;
    }

    @XmlTransient
    public List<ProductReviews> getProductReviewsList() {
        return productReviewsList;
    }

    public void setProductReviewsList(List<ProductReviews> productReviewsList) {
        this.productReviewsList = productReviewsList;
    }

    @XmlTransient
    public List<ProductStock> getProductStockList() {
        return productStockList;
    }

    public void setProductStockList(List<ProductStock> productStockList) {
        this.productStockList = productStockList;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "osa.ora.jpa.Product[ id=" + id + " ]";
    }
    
}
