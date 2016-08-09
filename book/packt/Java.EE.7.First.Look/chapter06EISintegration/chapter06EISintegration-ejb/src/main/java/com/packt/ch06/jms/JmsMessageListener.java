/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Administrator
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/javaee7Queue")
})
public class JmsMessageListener implements MessageListener {
        
    @Override
    public void onMessage(Message message) {
        try {
            int jmsxDeliveryCount = message.getIntProperty("JMSXDeliveryCount");
            //...
            if(jmsxDeliveryCount > 5){
                // do something
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}
