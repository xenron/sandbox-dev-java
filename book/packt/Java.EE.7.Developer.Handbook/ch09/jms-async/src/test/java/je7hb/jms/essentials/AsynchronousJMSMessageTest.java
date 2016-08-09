/*******************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013,2014 by Peter Pilgrim, Addiscombe, Surrey, XeNoNiQUe UK
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU GPL v3.0
 * which accompanies this distribution, and is available at:
 * http://www.gnu.org/licenses/gpl-3.0.txt
 *
 * Developers:
 * Peter Pilgrim -- design, development and implementation
 *               -- Blog: http://www.xenonique.co.uk/blog/
 *               -- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/

package je7hb.jms.essentials;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import je7hb.common.webcontainer.embedded.glassfish.SimpleEmbeddedRunner;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.impl.base.exporter.zip.ZipExporterImpl;
import org.junit.*;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

/**
 * A unit test AsynchronousJMSMessageTest to verify the operation of AsynchronousJMSMessageTest
 *
 * @author Peter Pilgrim
 */
public class AsynchronousJMSMessageTest {

    private static SimpleEmbeddedRunner runner;
    private static WebArchive webArchive;

    @BeforeClass
    public static void assembleDeployAndStartServer() throws Exception {
        webArchive = ShrinkWrap.create(WebArchive.class, "asyncjms.war")
                .addClasses(PayloadCheck.class)
//                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"))
//                .addAsManifestResource(
//                        new File("src/test/resources-glassfish-embedded/glassfish-resources.xml"),
//                        "glassfish-resources.xml")
                .addAsWebInfResource(
                        new File("src/test/resources-glassfish-embedded/glassfish-resources.xml"),
                        "glassfish-resources.xml")
                .addAsWebInfResource(
                        EmptyAsset.INSTANCE, "beans.xml");

        System.out.println(webArchive.toString(true));

        File warFile = new File(webArchive.getName());
        new ZipExporterImpl(webArchive).exportTo(warFile, true);
        runner = SimpleEmbeddedRunner.launchDeployWarFile(
                warFile, "mywebapp", 8080);
    }

    @AfterClass
    public static void stopServer() throws Exception {
        runner.stop();
    }

    private List<String> messages = new ArrayList<>();

    private CompletionListener completionListener = new CompletionListener() {
        @Override
        public void onCompletion(Message msg) {
            TextMessage textMsg = (TextMessage)msg;
            try {
                System.out.printf("%s.onCompletion(%s) Thread: %s\n",
                        getClass().getSimpleName(), textMsg.getText(), Thread.currentThread());
            } catch (JMSException e) {
                e.printStackTrace(System.err);
            }
        }

        @Override
        public void onException(Message msg, Exception ex) {
            ex.printStackTrace(System.err);
        }
    };


    @Test
    public void shouldFireMessageAsynchronously() throws Exception {

        Properties properties = new Properties();
//        properties.put("com.sun.appserv.iiop.endpoints", "localhost:7676");
//        properties.put("org.omg.CORBA.ORBInitialHost", "localhost");
//        properties.put("org.omg.CORBA.ORBInitialPort", "3700");
//        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
//        properties.put(Context.PROVIDER_URL, "mq://localhost:7676/");
//        properties.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
//        properties.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        properties.put("org.omg.CORBA.ORBInitialHost", "localhost");
        properties.put("org.omg.CORBA.ORBInitialPort", "3700");
//                properties.put(Context.PROVIDER_URL, "mq://localhost:7676"); // vm://localhost:
        //        properties.put(Context.PROVIDER_URL, "iiop://localhost:7676"); // vm://localhost:
        properties.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        properties.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

        InitialContext jndiContext = new InitialContext(properties);

        ConnectionFactory connectionFactory =
                (ConnectionFactory)jndiContext.lookup("jms/demoConnectionFactory");

        Queue queue = (Queue)jndiContext.lookup("jms/demoQueue");

        JMSContext context = connectionFactory.createContext(
                Session.AUTO_ACKNOWLEDGE );
        JMSProducer producer = context.createProducer();

        messages.clear();

        producer.setAsync(completionListener);

        producer.send(queue, "hello");
        producer.send(queue, "world");
        producer.send(queue, "asynchronously");

        Thread.sleep(2000);

        System.out.println("Done");
    }

}
