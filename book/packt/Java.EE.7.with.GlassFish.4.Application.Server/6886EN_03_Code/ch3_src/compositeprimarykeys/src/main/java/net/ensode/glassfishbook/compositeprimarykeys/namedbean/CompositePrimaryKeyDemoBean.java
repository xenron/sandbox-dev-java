package net.ensode.glassfishbook.compositeprimarykeys.namedbean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.ensode.glassfishbook.compositeprimarykeys.entity.OrderItem;
import net.ensode.glassfishbook.compositeprimarykeys.entity.OrderItemPK;

@Named
@RequestScoped
public class CompositePrimaryKeyDemoBean {

    @PersistenceContext
    private EntityManager entityManager;

    private OrderItem orderItem;

    public String findOrderItem() {
        String retVal = "confirmation";

        try {
            orderItem = entityManager.find(OrderItem.class, new OrderItemPK(1L, 2L));
        } catch (Exception e) {
            retVal = "error";
            e.printStackTrace();
        }

        return retVal;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

}
