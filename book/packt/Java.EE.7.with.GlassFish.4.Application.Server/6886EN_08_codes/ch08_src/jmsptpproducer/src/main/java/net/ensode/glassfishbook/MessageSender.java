package net.ensode.glassfishbook;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

public class MessageSender {

    @Resource(mappedName = "jms/GlassFishBookConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/GlassFishBookQueue")
    private static Queue queue;

    public void produceMessages() {

        JMSContext jmsContext = connectionFactory.createContext();
        JMSProducer jmsProducer = jmsContext.createProducer();

        String msg1 = "Testing, 1, 2, 3. Can you hear me?";
        String msg2 = "Do you copy?";
        String msg3 = "Good bye!";

        System.out.println("Sending the following message: "
                + msg1);
        jmsProducer.send(queue, msg1);
        System.out.println("Sending the following message: "
                + msg2);
        jmsProducer.send(queue, msg2);
        System.out.println("Sending the following message: "
                + msg3);
        jmsProducer.send(queue, msg3);   

    }

    public static void main(String[] args) {
        new MessageSender().produceMessages();
    }
}
