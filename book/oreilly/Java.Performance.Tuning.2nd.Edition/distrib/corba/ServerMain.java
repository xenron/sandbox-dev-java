package tuning.distrib.corba;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
 
public class ServerMain {
 
    public static void main(String args[])
    {
        try{
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);
 
            // create servant and register it with the ORB
            ServerObjectImpl serverRef = new ServerObjectImpl();
            orb.connect(serverRef);
 
            // get the root naming context
            org.omg.CORBA.Object objRef = 
                orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
 
            // bind the Object Reference in Naming
            NameComponent nc = new NameComponent("ServerObject", "");
            NameComponent path[] = {nc};
            ncRef.rebind(path, serverRef);
 
            // wait for invocations from clients
            System.out.println("Server now waiting for client invocations");
            java.lang.Object sync = new java.lang.Object();
            synchronized (sync) {
                sync.wait();
            }
 
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}
