package com.baselogic.javaee6.jmx.ch3;

import com.sun.jdmk.comm.*;

import javax.management.remote.JMXServiceURL;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.MBeanServerConnection;
import java.io.IOException;

public class RMIClientFactory {

    public static MBeanServerConnection getClient() {
        MBeanServerConnection mbsc = null;
        try {
            JMXServiceURL url = new JMXServiceURL(
                    "service:jmx:rmi:///jndi/rmi://localhost:9999/server");
            JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

            mbsc = jmxc.getMBeanServerConnection();

            return mbsc;
        } catch (IOException e) {
            e.printStackTrace(); //To change body of catch statement use File | Settings | File Templates.
        } finally {
            return mbsc;
        }
    }

}