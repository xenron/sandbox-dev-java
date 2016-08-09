package rmi.callback;

import java.rmi.Remote;
import java.rmi.RemoteException;

// BEGIN main
public interface TickerServer extends Remote {
    public static final String LOOKUP_NAME = "Ticker_Service";
    public void connect(Client d) throws RemoteException;
}
// END main
