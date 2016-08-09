package net.ensode.glassfishbook;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;

public class AsynchMessReceiver {

    @Resource(mappedName = "jms/GlassFishBookConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/GlassFishBookQueue")
    private static Queue queue;

    public void getMessages() {
        try {
            JMSContext jmsContext = connectionFactory.createContext();
            JMSConsumer jMSConsumer = jmsContext.createConsumer(queue);
            
            jMSConsumer.setMessageListener(new ExampleMessageListener());

            System.out.println("The above line will allow the "
                    + "MessageListener implementation to "
                    + "receiving and processing messages from the queue.");
            Thread.sleep(1000);
            System.out.println("Our code does not have to block "
                    + "while messages are received.");
            Thread.sleep(1000);
            System.out.println("It can do other stuff "
                    + "(hopefully something more useful than sending "
                    + "silly output to the console. :)");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AsynchMessReceiver().getMessages();
    }
}
