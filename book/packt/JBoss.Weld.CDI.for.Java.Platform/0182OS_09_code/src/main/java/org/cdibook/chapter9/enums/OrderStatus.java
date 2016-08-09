package org.cdibook.chapter9.enums;

public enum OrderStatus {

    CREATED,
    ADDRESS_VERIFIED,
    PAYMENT_PROCESSED,
    PAYMENT_RETRY_ATTEMPTED,
    PAYMENT_FAILED,
    PREPARING_SHIPMENT,
    SHIPPED,
    DELIVERED,
    DELIVERY_FAILURE,
    RETURN_REQUESTED,
    RETURN_PROCESSED,
    CLOSED
}
