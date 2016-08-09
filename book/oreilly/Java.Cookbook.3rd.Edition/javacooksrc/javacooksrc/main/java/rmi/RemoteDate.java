package rmi;

import java.util.Date;

// BEGIN main
/** A statement of what the client & server must agree upon. */
public interface RemoteDate extends java.rmi.Remote {

    /** The method used to get the current date on the remote */
    public Date getRemoteDate() throws java.rmi.RemoteException;

    /** The name used in the RMI registry service. */
    public final static String LOOKUPNAME = "RemoteDate";
}
// END main
