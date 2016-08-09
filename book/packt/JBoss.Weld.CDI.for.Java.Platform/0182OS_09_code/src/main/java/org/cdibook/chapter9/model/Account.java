package org.cdibook.chapter9.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "account")
public class Account extends ParentObject {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "pmt_addr_name")),
        @AttributeOverride(name = "line1", column = @Column(name = "pmt_addr_line1")),
        @AttributeOverride(name = "line2", column = @Column(name = "pmt_addr_line2")),
        @AttributeOverride(name = "city", column = @Column(name = "pmt_addr_city")),
        @AttributeOverride(name = "state", column = @Column(name = "pmt_addr_state")),
        @AttributeOverride(name = "zip", column = @Column(name = "pmt_addr_zip")),
        @AttributeOverride(name = "country", column = @Column(name = "pmt_addr_ctry"))
    })
    @Embedded
    private Address paymentAddress = new Address();

    @AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "shp_addr_name")),
        @AttributeOverride(name = "line1", column = @Column(name = "shp_addr_line1")),
        @AttributeOverride(name = "line2", column = @Column(name = "shp_addr_line2")),
        @AttributeOverride(name = "city", column = @Column(name = "shp_addr_city")),
        @AttributeOverride(name = "state", column = @Column(name = "shp_addr_state")),
        @AttributeOverride(name = "zip", column = @Column(name = "shp_addr_zip")),
        @AttributeOverride(name = "country", column = @Column(name = "shp_addr_ctry"))
    })
    @Embedded
    private Address shippingAddress = new Address();

    protected Account() {
    }

    public Account(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getPaymentAddress() {
        if (null == paymentAddress) {
            paymentAddress = new Address();
        }
        return paymentAddress;
    }

    public void setPaymentAddress(Address paymentAddress) {
        validateAddress(paymentAddress);
        this.paymentAddress = paymentAddress;
    }

    public Address getShippingAddress() {
        if (null == shippingAddress) {
            shippingAddress = new Address();
        }
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        validateAddress(shippingAddress);
        this.shippingAddress = shippingAddress;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || !(obj instanceof Account)) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        } else {
            Account acct = (Account) obj;

            if (null != user ? !user.equals(acct.user) : null != acct.user) {
                return false;
            }
            if (null != paymentAddress ? !paymentAddress.equals(acct.getPaymentAddress()) : null != acct.paymentAddress) {
                return false;
            }
            if (null != shippingAddress ? !shippingAddress.equals(acct.getShippingAddress()) : null != acct.shippingAddress) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + (null != user ? user.hashCode() : 0);
        hash = 31 * hash + (null != paymentAddress ? paymentAddress.hashCode() : 0);
        hash = 31 * hash + (null != shippingAddress ? shippingAddress.hashCode() : 0);
        return hash;
    }

    private void validateAddress(Address address) throws IllegalArgumentException {
        if (null != address) {
            if (null == address.getLine1() || null == address.getCity()
                    || null == address.getZip() || null == address.getState()
                    || null == address.getCountry()) {
                throw new IllegalArgumentException("Address contains null values.");
            }
        }
    }
}
