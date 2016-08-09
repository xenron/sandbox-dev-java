package rmi;

import java.rmi.Naming;
import java.util.Date;

// BEGIN main
/* A very simple client for the RemoteDate service. */
public class DateClient {

    /** The local proxy for the service. */
    protected static RemoteDate netConn = null;

    public static void main(String[] args) {
        try {
            netConn = (RemoteDate)Naming.lookup(RemoteDate.LOOKUPNAME);
            Date today = netConn.getRemoteDate();
            System.out.println(today.toString()); // Could use a DateFormat...
        } catch (Exception e) {
            System.err.println("RemoteDate exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
// END main
