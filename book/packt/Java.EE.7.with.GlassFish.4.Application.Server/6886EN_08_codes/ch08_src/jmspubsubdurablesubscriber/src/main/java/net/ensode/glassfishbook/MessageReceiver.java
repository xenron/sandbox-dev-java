package net.ensode.glassfishbook;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

public class MessageReceiver {

    @Resource(mappedName
            = "jms/GlassFishBookDurableConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/GlassFishBookTopic")
    private static Topic topic;

    public void getMessages() {
        String message;
        boolean goodByeReceived = false;

        JMSContext jmsContext = connectionFactory.createContext();
        JMSConsumer jMSConsumer = jmsContext.createDurableConsumer(topic, "Subscriber1");

        System.out.println("Waiting for messages...");
        while (!goodByeReceived) {
            message = jMSConsumer.receiveBody(String.class);

            if (message != null) {
                System.out.print("Received the following message: ");
                System.out.println(message);
                System.out.println();
                if (message.equals("Good bye!")) {
                    goodByeReceived = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        new MessageReceiver().getMessages();
    }
}
