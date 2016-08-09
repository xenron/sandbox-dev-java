/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Administrator
 */
@Stateless
public class SendMessageBean {

    @Resource(name = "jms/javaee7New/ConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(name = "jms/javaee7New/Queue")
    private Queue queue;

    public void sendMessage(String message) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage textMessage = session.createTextMessage(message);
            messageProducer.send(textMessage);
            connection.close();
        } catch (JMSException ex) {
            // handle exception (details omitted)
        }
    }
}
