/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.mdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author heffel
 */
@MessageDriven(mappedName = "jms/myQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode",
    propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType",
    propertyValue = "javax.jms.Queue")})
public class MessageReceiver implements MessageListener {

    public MessageReceiver() {
    }

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            Logger.getLogger(MessageReceiver.class.getName()).log(Level.INFO,
                    new StringBuilder("Received Message: ").append(
                    textMessage.getText()).toString());
        } catch (JMSException ex) {
            Logger.getLogger(MessageReceiver.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
}
