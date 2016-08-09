/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06.jms;

import javax.ejb.Stateless;
import javax.jms.CompletionListener;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Administrator
 */
@Stateless
public class JmsImprovement implements JmsImprovementLocal {

    //Sending message with JMS 1.1
    public void sendMessageJMSWithOldAPI(ConnectionFactory connectionFactory, Queue destination) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        try {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage("Message send with the old API");
            messageProducer.send(textMessage);
        } finally {
            connection.close();
        }
    }

    //Sending message with JMS 2.0
    public void sendMessageJMSWithNewdAPI(ConnectionFactory connectionFactory, Queue destination) {
        try (JMSContext context = connectionFactory.createContext();) {
            context.createProducer().send(destination, "Message send with the new API");
        } 
    }

    public void sendMessageAsynchronously(ConnectionFactory cfactory, Queue destination) {
        try (JMSContext context = cfactory.createContext();) {
            context.createProducer().setAsync(new Completion()).send(destination, "Hello world");
        }
    }

    public void sendMessageWithDelay(ConnectionFactory cfactory, Queue destination) {
        try (JMSContext context = cfactory.createContext();) {
            context.createProducer().setDeliveryDelay(1000 * 60 * 60).send(destination, "Hello world");
        }
    }

    class Completion implements CompletionListener {

        public void onCompletion(Message message) {
            System.out.println("message sent successfully");
        }

        public void onException(Message message, Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
