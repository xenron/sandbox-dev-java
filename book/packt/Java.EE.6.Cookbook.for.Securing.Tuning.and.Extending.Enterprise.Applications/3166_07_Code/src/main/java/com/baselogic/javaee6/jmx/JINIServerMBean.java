package com.baselogic.javaee6.jmx;

public interface JINIServerMBean {
    public String getDomain();

    public String getEntryName();

    public void setEntryName(String name);

    public String[] getGroups();

    public void setGroups(String[] groups);

    public void enableConnections();
}

