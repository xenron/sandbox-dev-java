package org.cdibook.chapter9.model;

import org.cdibook.chapter9.enums.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order")
public class Order extends ParentObject {

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status = OrderStatus.CREATED;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderItem> items = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @Transient
    private BigDecimal total;

    protected Order() {
    }

    public Order(Account account, Set<OrderItem> items) {
        this.account = account;
        this.items.addAll(items);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        if (null == this.items) {
            this.items = new HashSet<>();
        }
        if (!this.items.contains(item)) {
            this.items.add(item);
        }
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || !(obj instanceof Order)) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        } else {
            Order order = (Order) obj;

            if (null != status ? !status.equals(order.status) : null != order.status) {
                return false;
            }
            if (null != items ? !items.equals(order.items) : null != order.items) {
                return false;
            }
            if (null != account ? !account.getId().equals(order.account.getId()) : null != order.account) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + (null != status ? status.hashCode() : 0);
        hash = 31 * hash + (null != items ? items.hashCode() : 0);
        hash = 31 * hash + (null != account ? account.hashCode() : 0);
        return hash;
    }
}
