package packt;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AlgorithmConstraints;
import java.util.Date;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

public class EchoServer {

    public EchoServer() {
        try {
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket =
                    (SSLServerSocket) sslServerSocketFactory.createServerSocket(9999);
            System.out.println("Waiting for a client ...");
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            SSLParameters parameters = sslSocket.getSSLParameters();
            parameters.setAlgorithmConstraints(new SimpleConstraints());
            
            AlgorithmConstraints constraints = parameters.getAlgorithmConstraints();
            System.out.println("Constraint: " + constraints);
            
            String endPoint = parameters.getEndpointIdentificationAlgorithm();
            System.out.println("End Point: " + endPoint);
            
            System.out.println("Local Supported Signature Algorithms");
            if (sslSocket.getSession() instanceof ExtendedSSLSession) {
                ExtendedSSLSession extendedSSLSession = 
                        (ExtendedSSLSession) sslSocket.getSession();
                String alogrithms[] = 
                        extendedSSLSession.getLocalSupportedSignatureAlgorithms();
                for (String algorithm : alogrithms) {
                    System.out.println("Algortihm: " + algorithm);
                }
            }

            System.out.println("Peer Supported Signature Algorithms");
            if (sslSocket.getSession() instanceof ExtendedSSLSession) {
                String alogrithms[] = ((ExtendedSSLSession) sslSocket.getSession()).getPeerSupportedSignatureAlgorithms();
                for (String algorithm : alogrithms) {
                    System.out.println("Algortihm: " + algorithm);
                }
            }

            InputStream inputstream = sslSocket.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

            SSLSession session = sslSocket.getHandshakeSession();
            if (session != null) {
                System.out.println("Last accessed: " + new Date(session.getLastAccessedTime()));
            }

            String string = null;
            while ((string = bufferedreader.readLine()) != null) {
                System.out.println(string);
                System.out.flush();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public static void main(String[] arstring) {
        new EchoServer();
    }

}
