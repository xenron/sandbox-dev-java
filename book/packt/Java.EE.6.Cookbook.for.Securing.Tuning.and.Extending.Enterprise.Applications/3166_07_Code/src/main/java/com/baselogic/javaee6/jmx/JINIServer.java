package com.baselogic.javaee6.jmx;

import net.jini.core.entry.Entry;
import net.jini.core.lookup.ServiceID;
import net.jini.discovery.LookupDiscoveryManager;
import net.jini.lease.LeaseRenewalManager;
import net.jini.lookup.JoinManager;
import net.jini.lookup.ServiceIDListener;
import net.jini.lookup.entry.Name;

import javax.management.MBeanRegistration;
import javax.management.MBeanServer;
import javax.management.ObjectInstance;
import javax.management.ObjectName;

public class JINIServer implements JINIServerMBean, MBeanRegistration, ServiceIDListener {
    private MBeanServer mbs = null;
    private JoinManager jm = null;
    private ServiceID id = null;
    private String domain = null;
    private ObjectName name = null;
    private String[] groups;
    private Name entry = null;
    private boolean enabled = false;

    public JINIServer() {
        groups = new String[1];
        groups[0] = "public";
    }

    public String getDomain() {
        return domain;
    }

    public String getEntryName() {
        return entry.name;
    }

    public void serviceIDNotify(ServiceID id) {
        this.id = id;
    }

    public ObjectName preRegister(MBeanServer server, ObjectName name) throws Exception {
        this.mbs = server;

        if (name == null) {
            name = new ObjectName(mbs.getDefaultDomain() + ":connectorType=JINI");
        }

        this.domain = name.getDomain();
        return name;
    }

    public void postRegister(Boolean registrationDone) {
    }

    public void preDeregister() throws Exception {
    }

    public void postDeregister() {
    }

    public void setGroups(String groups[]) {
        if (groups != null) this.groups = groups;
    }

    public String[] getGroups() {
        return groups;
    }

    public void enableConnections() {
        createService();
    }

    public void setEntryName(String name) {
        Entry old = entry;
        this.entry = new Name(name);

        if (enabled) {
            Entry[] newlabels = {entry};
            Entry[] labels = {old};
            jm.modifyAttributes(labels, newlabels);
        }

    }

    private void createService() {
        try {
            JINIConnector connector = new JINIConnectorImpl(this);
            Entry[] labels = {entry};
            LookupDiscoveryManager mgr = new LookupDiscoveryManager(groups, null, null);
            jm = new JoinManager(connector, labels, this, mgr, new LeaseRenewalManager());
            enabled = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    call back methods
    */
    public Integer getMBeanCount() throws Exception {
        return mbs.getMBeanCount();
    }

    public ObjectInstance createMBean(String className, ObjectName name) throws Exception {
        return mbs.createMBean(className, name);
    }

}