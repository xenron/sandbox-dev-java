package com.baselogic.javaee6.jmx;

import net.jini.core.lookup.ServiceMatches;
import net.jini.core.lookup.ServiceRegistrar;
import net.jini.core.lookup.ServiceTemplate;
import net.jini.discovery.DiscoveryEvent;
import net.jini.discovery.DiscoveryListener;
import net.jini.discovery.LookupDiscovery;

import javax.management.*;
import javax.management.loading.ClassLoaderRepository;
import java.io.ObjectInputStream;
import java.rmi.RMISecurityManager;
import java.util.Set;

public class JINIConnectorClient
        implements DiscoveryListener, MBeanServer {
    private ServiceTemplate template = null;
    private LookupDiscovery reg = null;
    private JINIConnector server = null;

    public JINIConnectorClient() {
        System.setSecurityManager(new RMISecurityManager());
        Class[] cls = {JINIConnector.class};
        template = new ServiceTemplate(null, cls, null);

        try {
            reg = new LookupDiscovery(new String[]{""});
            reg.addDiscoveryListener(this);
            while (server == null) Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void discovered(DiscoveryEvent event) {
        if (server != null) return;
        ServiceRegistrar[] lookups = event.getRegistrars();

        try {
            ServiceMatches items = lookups[0].lookup(template, Integer.MAX_VALUE);
            server = (JINIConnector) items.items[0].service;
            System.out.println("service found");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void discarded(DiscoveryEvent event) {
    }

    public Integer getMBeanCount() {
        try {
            return server.getMBeanCount();
        } catch (Exception e) {
            return null;
        }
    }

    public ObjectInstance createMBean(String className, ObjectName name) throws ReflectionException, InstanceAlreadyExistsException, MBeanRegistrationException, MBeanException, NotCompliantMBeanException {
        try {
            return server.createMBean(className, name);
        } catch (JINIConnectorException e) {
            Exception ex = e.getWrappedException();
            if (ex instanceof ReflectionException) throw (ReflectionException) ex;
            else if (ex instanceof InstanceAlreadyExistsException) throw (InstanceAlreadyExistsException) ex;
            else if (ex instanceof MBeanRegistrationException) throw (MBeanRegistrationException) ex;
            else if (ex instanceof MBeanException) throw (MBeanException) ex;
            else throw (NotCompliantMBeanException) ex;
        } catch (Exception e) {
            throw (NotCompliantMBeanException) e;
        }
    }

    @Override
    public ClassLoader getClassLoader(ObjectName mbeanName)
        throws InstanceNotFoundException{
        return Thread.currentThread().getContextClassLoader();
    }

    @Override
    public ClassLoader getClassLoaderFor(ObjectName mbeanName)
        throws InstanceNotFoundException{
        return Thread.currentThread().getContextClassLoader();
    }

    @Override
    public ClassLoaderRepository getClassLoaderRepository(){
        return null;//Thread.currentThread().get();
    }

    /*
    Implement getMBeanCount() method
    UNIMPLEMENTED METHODS BELOW
    */
    public Object instantiate(String className) throws ReflectionException, MBeanException {
        return null;
    }

    public Object instantiate(String className, ObjectName loaderName) throws ReflectionException, MBeanException, InstanceNotFoundException {
        return null;
    }

    public Object instantiate(String className, Object params[], String signature[]) throws ReflectionException, MBeanException {
        return null;
    }

    public Object instantiate(String className, ObjectName loaderName, Object params[], String signature[]) throws ReflectionException, MBeanException, InstanceNotFoundException {
        return null;
    }

    public ObjectInstance createMBean(String className, ObjectName name, ObjectName loaderName) throws ReflectionException, InstanceAlreadyExistsException, MBeanRegistrationException, MBeanException, NotCompliantMBeanException, InstanceNotFoundException {
        return null;
    }

    public ObjectInstance createMBean(String className, ObjectName name, Object params[], String signature[]) throws ReflectionException, InstanceAlreadyExistsException, MBeanRegistrationException, MBeanException, NotCompliantMBeanException {
        return null;
    }

    public ObjectInstance createMBean(String className, ObjectName name, ObjectName loaderName, Object params[], String signature[]) throws ReflectionException, InstanceAlreadyExistsException, MBeanRegistrationException, MBeanException, NotCompliantMBeanException, InstanceNotFoundException {
        return null;
    }

    public ObjectInstance registerMBean(Object object, ObjectName name) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        return null;
    }

    public void unregisterMBean(ObjectName name) throws InstanceNotFoundException, MBeanRegistrationException {
        return;
    }

    public ObjectInstance getObjectInstance(ObjectName name) throws InstanceNotFoundException {
        return null;
    }

    public Set queryMBeans(ObjectName name, QueryExp query) {
        return null;
    }

    public Set queryNames(ObjectName name, QueryExp query) {
        return null;
    }

    public boolean isRegistered(ObjectName name) {
        return false;
    }

    public Object getAttribute(ObjectName name, String attribute) throws MBeanException, AttributeNotFoundException, InstanceNotFoundException, ReflectionException {
        return null;
    }

    public AttributeList getAttributes(ObjectName name, String[] attributes) throws InstanceNotFoundException, ReflectionException {
        return null;
    }

    public void setAttribute(ObjectName name, Attribute attribute) throws InstanceNotFoundException, AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        return;
    }

    public AttributeList setAttributes(ObjectName name, AttributeList attributes) throws InstanceNotFoundException, ReflectionException {
        return null;
    }

    public Object invoke(ObjectName name, String operationName, Object params[], String signature[]) throws InstanceNotFoundException, MBeanException, ReflectionException {
        return null;
    }

    public String getDefaultDomain() {
        return null;
    }

    public String[] getDomains(){
        return null;
    }

    public void addNotificationListener(ObjectName name, NotificationListener listener, NotificationFilter filter, Object handback) throws InstanceNotFoundException {
        return;
    }

    public void addNotificationListener(ObjectName name, ObjectName listener, NotificationFilter filter, Object handback) throws InstanceNotFoundException {
        return;
    }

    public void removeNotificationListener(ObjectName name, NotificationListener listener) throws InstanceNotFoundException, ListenerNotFoundException {
        return;
    }

    public void removeNotificationListener(ObjectName name, ObjectName listener) throws InstanceNotFoundException, ListenerNotFoundException {
        return;
    }

    // doc comment inherited from MBeanServerConnection
    public void removeNotificationListener(ObjectName name,
                                           ObjectName listener,
                                           NotificationFilter filter,
                                           Object handback)
            throws InstanceNotFoundException, ListenerNotFoundException{}

    // doc comment inherited from MBeanServerConnection
    public void removeNotificationListener(ObjectName name,
                                           NotificationListener listener,
                                           NotificationFilter filter,
                                           Object handback)
            throws InstanceNotFoundException, ListenerNotFoundException{}


    public MBeanInfo getMBeanInfo(ObjectName name) throws InstanceNotFoundException, IntrospectionException, ReflectionException {
        return null;
    }

    public boolean isInstanceOf(ObjectName name, String className) throws InstanceNotFoundException {
        return false;
    }

    public ObjectInputStream deserialize(ObjectName name, byte[] data) throws InstanceNotFoundException, OperationsException {
        return null;
    }

    public ObjectInputStream deserialize(String className, byte[] data) throws OperationsException, ReflectionException {
        return null;
    }

    public ObjectInputStream deserialize(String className, ObjectName loaderName, byte[] data) throws InstanceNotFoundException, OperationsException, ReflectionException {
        return null;
    }

    public static void main(String args[]) {
        try {
            JINIConnectorClient client = new JINIConnectorClient();
            System.out.println(client.getMBeanCount());
            //client.createMBean("com.baselogic.javaee6.jmx.JINIConnect", new ObjectName("JavaEECookbookAgent:name=hwtest"));
            client.createMBean( "com.baselogic.javaee6.jmx.ch2.HelloWorld", new ObjectName( "JMXBookAgent:name=hwtest" ) );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

