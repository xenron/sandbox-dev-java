/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author Administrator
 */
@Stateless
public class SendMessageBean2 {

    @Inject
    JMSContext context;
    @Resource(lookup = "java:global/jms/javaee7Queue")
    Queue queue;

    public void sendMessage(String message) {
        context.createProducer().send(queue, message);
    }
}
