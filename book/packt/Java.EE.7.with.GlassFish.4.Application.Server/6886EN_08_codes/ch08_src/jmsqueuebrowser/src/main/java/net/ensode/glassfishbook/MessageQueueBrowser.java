package net.ensode.glassfishbook;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.TextMessage;

public class MessageQueueBrowser {

    @Resource(mappedName = "jms/GlassFishBookConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/GlassFishBookQueue")
    private static Queue queue;

    public void browseMessages() {
        try {
            Enumeration messageEnumeration;
            TextMessage textMessage;
            JMSContext jmsContext = connectionFactory.createContext();
            QueueBrowser browser = jmsContext.createBrowser(queue);

            messageEnumeration = browser.getEnumeration();

            if (messageEnumeration != null) {
                if (!messageEnumeration.hasMoreElements()) {
                    System.out.println("There are no messages "
                            + "in the queue.");
                } else {
                    System.out.println(
                            "The following messages are in the queue:");
                    while (messageEnumeration.hasMoreElements()) {
                        textMessage = (TextMessage) messageEnumeration.
                                nextElement();
                        System.out.println(textMessage.getText());
                    }
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageQueueBrowser().browseMessages();
    }
}
