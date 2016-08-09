package org.cdibook.chapter9.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
public class OrderItem extends ParentObject {

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    private Integer quantity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    protected OrderItem() {
    }

    public OrderItem(BigDecimal price, Integer qty, Book book, Order order) {
        this.unitPrice = price;
        this.quantity = qty;
        this.book = book;
        this.order = order;
        order.addItem(this);
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || !(obj instanceof OrderItem)) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        } else {
            OrderItem item = (OrderItem) obj;

            if (null != unitPrice ? !unitPrice.equals(item.unitPrice) : null != item.unitPrice) {
                return false;
            }
            if (null != quantity ? !quantity.equals(item.quantity) : null != item.quantity) {
                return false;
            }
            if (null != book ? !book.getId().equals(item.book.getId()) : null != item.book) {
                return false;
            }
            if (null != order ? !order.getId().equals(item.order.getId()) : null != item.order) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + (null != unitPrice ? unitPrice.hashCode() : 0);
        hash = 31 * hash + (null != quantity ? quantity.hashCode() : 0);
        hash = 31 * hash + (null != book.getId() ? book.getId().hashCode() : 0);
        hash = 31 * hash + (null != order.getId() ? order.getId().hashCode() : 0);
        return hash;
    }
}
