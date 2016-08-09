package com.baselogic.javaee6.jmx;

import java.rmi.*;
import javax.management.*;

public interface JINIConnector extends Remote {
    public Integer getMBeanCount()
            throws JINIConnectorException, RemoteException;

    public ObjectInstance createMBean(String className, ObjectName name) throws JINIConnectorException, RemoteException;
}

