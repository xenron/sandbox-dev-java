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
@Table(name = "product_reviews")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductReviews.findAll", query = "SELECT p FROM ProductReviews p"),
    @NamedQuery(name = "ProductReviews.findById", query = "SELECT p FROM ProductReviews p WHERE p.id = :id"),
    @NamedQuery(name = "ProductReviews.findByName", query = "SELECT p FROM ProductReviews p WHERE p.name = :name"),
    @NamedQuery(name = "ProductReviews.findByComment", query = "SELECT p FROM ProductReviews p WHERE p.comment = :comment"),
    @NamedQuery(name = "ProductReviews.findByDate", query = "SELECT p FROM ProductReviews p WHERE p.date = :date"),
    @NamedQuery(name = "ProductReviews.findByStars", query = "SELECT p FROM ProductReviews p WHERE p.stars = :stars")})
public class ProductReviews implements Serializable {
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
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stars")
    private int stars;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product productId;

    public ProductReviews() {
    }

    public ProductReviews(Integer id) {
        this.id = id;
    }

    public ProductReviews(Integer id, String name, String comment, Date date, int stars) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.date = date;
        this.stars = stars;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
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
        if (!(object instanceof ProductReviews)) {
            return false;
        }
        ProductReviews other = (ProductReviews) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "osa.ora.jpa.ProductReviews[ id=" + id + " ]";
    }
    
}
