package org.jboss.resteasy.examples.oauth.provider;

import org.jboss.resteasy.auth.oauth.OAuthConsumer;
import org.jboss.resteasy.auth.oauth.OAuthException;
import org.jboss.resteasy.auth.oauth.OAuthProvider;
import org.jboss.resteasy.auth.oauth.OAuthRequestToken;
import org.jboss.resteasy.auth.oauth.OAuthToken;

import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

/**
 * OAuthDBProvider that keeps all data in DB. 
 *
 **/
public class OAuthDBProvider implements OAuthProvider {

    private static final String DEFAULT_CONSUMER_ROLE = "user";
    
    private static Connection conn;
    
    
	public OAuthDBProvider() {
	    initConnection();
	}
	
	public OAuthDBProvider(Map<String, String> props) {
        initConnection(props.get("db.driver"),
                       props.get("db.url"),
                       props.get("db.username"),
                       props.get("db.password"));
    }
	
	private static synchronized void initConnection() {
	    
	    if (conn != null) {
	        return;
	    }
	    
	    Properties props = new Properties();
        try {
            props.load(OAuthDBProvider.class.getResourceAsStream("/db.properties"));
        } catch (Exception ex) {
            throw new RuntimeException("db.properties resource is not available");
        }
        String driver = props.getProperty("db.driver");
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.username");
        String password = props.getProperty("db.password");
        
        initConnection(driver, url, user, password);
	}
	
	private static void initConnection(String driver, String url, String user, String password) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            throw new RuntimeException("In memory OAuth DB can not be created " + ex.getMessage());
        }
        
        try {

            // consumers
            update(
                "CREATE TABLE consumers ( id INTEGER IDENTITY, key VARCHAR(256)" + 
                ", secret VARCHAR(256), display_name VARCHAR(256), connect_uri VARCHAR(256),"
                + " scopes VARCHAR(256), permissions VARCHAR(256), unique(key))");
            
            // request tokens
            update(
                "CREATE TABLE request_tokens ( id INTEGER IDENTITY, consumer_key VARCHAR(256)" + 
                ", token VARCHAR(256), secret VARCHAR(256), callback VARCHAR(256), scopes VARCHAR(256)"
                + ", permissions VARCHAR(256), verifier VARCHAR(256), foreign key(consumer_key) references consumers(key))");
            
            // access tokens
            update(
                "CREATE TABLE access_tokens ( id INTEGER IDENTITY, consumer_key VARCHAR(256)" + 
                ", token VARCHAR(256), secret VARCHAR(256), scopes VARCHAR(256),"
                + "permissions VARCHAR(256), foreign key(consumer_key) references consumers(key))");
            
            // custom permissions to roles map
            update(
                "CREATE TABLE permissions ( id INTEGER IDENTITY, permission VARCHAR(256)" + 
                ", role VARCHAR(256))");
            
            // add permissions to values map
            registerCustomPermissionsAndRoles();
            
        } catch (SQLException ex) {

            throw new RuntimeException("OAuth DB tables can not be created : " + ex.getMessage());
            
        }
    }
	
	
	
    
    public String authoriseRequestToken(String consumerKey, String requestToken)
            throws OAuthException {
        try {
            String verifier = makeRandomString();
            update("UPDATE request_tokens SET verifier='" + verifier + "' " 
                    + "WHERE token='" + requestToken + "'");
         
            return verifier;
         } catch (SQLException ex) {
             throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, 
                     "Request token for the consumer with key " + consumerKey + " can not be authorized");
         }
    }

    public void checkTimestamp(OAuthToken token, long timestamp)
            throws OAuthException {
        // TODO Auto-generated method stub
        
    }

    public OAuthToken getAccessToken(String consumerKey, String accessToken)
            throws OAuthException {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM access_tokens WHERE"
                    + " token = '" + accessToken + "'");
            if (rs.next()) {
                String token = rs.getString("token");
                String secret = rs.getString("secret");
                String scopes = rs.getString("scopes");
                String permissions = rs.getString("permissions");
                String tokenConsumerKey = rs.getString("consumer_key");
                
                if (consumerKey != null && !tokenConsumerKey.equals(consumerKey)) {
                    throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, "No such consumer key "+consumerKey);
                }
                
                return new OAuthToken(token, secret, 
                        scopes == null ? null : new String[] {scopes},
                        permissions == null ? null : new String[] {permissions},        
                        -1, getConsumer(tokenConsumerKey));
            } else {
                throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, "No such consumer key "+consumerKey);
            }
        } catch (SQLException ex) {
            throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, "No such consumer key "+consumerKey);
        }
    }

    public OAuthConsumer getConsumer(String consumerKey) throws OAuthException {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM consumers WHERE key = '" + consumerKey + "'");
            if (rs.next()) {
                String key = rs.getString("key");
                String secret = rs.getString("secret");
                String displayName = rs.getString("display_name");
                String connectURI = rs.getString("connect_uri");
                String scopes = rs.getString("scopes");
                String perms = rs.getString("permissions");
                OAuthConsumer consumer = 
                    new OAuthConsumer(key, secret, displayName, connectURI, 
                        perms != null ? new String[]{perms} : null);
                consumer.setScopes(new String[]{scopes});
                return consumer;
            } else {
                throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, "No such consumer key "+consumerKey);
            }
        } catch (SQLException ex) {
            throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, "No such consumer key "+consumerKey);
        }
    }

    public String getRealm() {
        return "default";
    }

    public OAuthRequestToken getRequestToken(String consumerKey,
            String requestToken) throws OAuthException {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM request_tokens WHERE"
                    + " token = '" + requestToken + "'");
            if (rs.next()) {
                String token = rs.getString("token");
                String secret = rs.getString("secret");
                String callback = rs.getString("callback");
                String scopes = rs.getString("scopes");
                String permissions = rs.getString("permissions");
                String verifier = rs.getString("verifier");
                String tokenConsumerKey = rs.getString("consumer_key");
                
                if (consumerKey != null && !tokenConsumerKey.equals(consumerKey)) {
                    throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, "No such consumer key "+consumerKey);
                }
                
                OAuthRequestToken newToken = new OAuthRequestToken(token, secret, callback, 
                        scopes == null ? null : new String[] {scopes},
                        permissions == null ? null : new String[] {permissions},        
                        -1, getConsumer(tokenConsumerKey));
                newToken.setVerifier(verifier);
                return newToken;
            } else {
                throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, "No such consumer key "+consumerKey);
            }
        } catch (SQLException ex) {
            throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, "No such consumer key "+consumerKey);
        }
    }

    public OAuthToken makeAccessToken(String consumerKey, String requestTokenKey,
            String verifier) throws OAuthException {
        OAuthRequestToken requestToken = verifyAndRemoveRequestToken(consumerKey, requestTokenKey, verifier);
        try {
            String token = makeRandomString();
            String secret = makeRandomString();
            String[] scopes = requestToken.getScopes();
            String[] permissions = requestToken.getPermissions();
            update("INSERT INTO access_tokens(token,consumer_key,secret,scopes,permissions) "
                    + "VALUES('" + token + "', '" + consumerKey + "', '"
                    + secret + "'" 
                    + ", " + (scopes != null ? "'" + scopes[0] + "'" : null)
                    + ", " + (permissions != null ? "'" + permissions[0] + "'" : null)
                    + ")");
         
            return new OAuthToken(token, secret, 
                    requestToken.getScopes(), requestToken.getPermissions(), -1, requestToken.getConsumer());
         } catch (SQLException ex) {
             throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, 
                     "Request token for the consumer with key " + consumerKey + " can not be created");
         }
    }

    private OAuthRequestToken verifyAndRemoveRequestToken(String consumerKey, String requestToken, String verifier) throws OAuthException {
        OAuthRequestToken token = getRequestToken(consumerKey, requestToken);
        checkCustomerKey(token, consumerKey);
        // check the verifier, which is only set when the request token was accepted
        if(verifier == null || !verifier.equals(token.getVerifier()))
            throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, "Invalid verifier code for token "+requestToken);
        try 
        {
            update("DELETE FROM request_tokens WHERE token='" + requestToken + "'");
        }
        catch (SQLException ex) 
        {
            throw new RuntimeException("Request Token can not be deleted");
        }
        return token;
    }
    
    public OAuthToken makeRequestToken(String consumerKey, String callback,
            String[] scopes, String[] permissions) throws OAuthException {
        try {
            String token = makeRandomString();
            String secret = makeRandomString();
            update("INSERT INTO request_tokens(token,consumer_key,secret,callback,scopes,permissions) "
                    + "VALUES('" + token + "', '" + consumerKey + "', '"
                    + secret + "', '" + callback + "'" 
                    + ", " + (scopes != null ? "'" + scopes[0] + "'" : null)
                    + ", " + (permissions != null ? "'" + permissions[0] + "'" : null)
                    + ")");
         
            return new OAuthRequestToken(token, secret, callback, 
                    scopes, permissions, -1, getConsumer(consumerKey));
         } catch (SQLException ex) {
             throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, 
                     "Request token for the consumer with key " + consumerKey + " can not be created");
         }
         
    }

    public OAuthConsumer registerConsumer(String consumerKey,
            String displayName, String connectURI) throws OAuthException {
        
        String secret = makeRandomString();
        
        try {
               update("INSERT INTO consumers(key,secret,display_name,connect_uri) "
                       + "VALUES('" + consumerKey + "', '" + secret + "'" 
                       + ", " + (displayName == null ? null : "'" + displayName + "'") 
                       + ", " + (connectURI == null ? null : "'" + connectURI + "'")
                       + ")");
            
        } catch (SQLException ex) {
            throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, 
                    "Consumer with key " + consumerKey + " can not be created");
        }
        return new OAuthConsumer(consumerKey, secret, displayName, connectURI);
    }

    private static String makeRandomString(){
        return UUID.randomUUID().toString();
    }

    private void checkCustomerKey(OAuthToken token, String customerKey) throws OAuthException {
        if (customerKey != null && !customerKey.equals(token.getConsumer().getKey())) {
            throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, "Invalid customer key");
        }
    }
    
    public void registerConsumerScopes(String consumerKey,
            String[] scopes) throws OAuthException {
        try {
            if (scopes != null)
            {
                update("UPDATE consumers SET scopes="
                        + "'" + scopes[0] + "'" 
                        + " WHERE key='" + consumerKey + "'");
            }
         } catch (SQLException ex) {
             throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, 
                     "Scopes for the consumer with key " + consumerKey + " can not be registered");
         }

    }


    public void registerConsumerPermissions(String consumerKey,
            String[] permissions) throws OAuthException {
        try {
            if (permissions != null)
            {
                update("UPDATE consumers SET permissions="
                        + "'" + permissions[0] + "'"
                        + " WHERE key='" + consumerKey + "'");
            }
        } catch (SQLException ex) {
             throw new OAuthException(HttpURLConnection.HTTP_UNAUTHORIZED, 
                     "Scopes for the consumer with key " + consumerKey + " can not be registered");
        }
        
    }
    
    public Set<String> convertPermissionsToRoles(String[] permissions) {
        Set<String> roles = new HashSet<String>();
        roles.add(DEFAULT_CONSUMER_ROLE);
        if (permissions == null || permissions.length == 0) {
            return roles;
        }
        StringBuilder query = new StringBuilder();
        query.append("SELECT role FROM permissions WHERE ");
        for (int i = 0; i < permissions.length; i++) {
            query.append("permission='" + permissions[i] + "'");
            if (i + 1 < permissions.length) {
                query.append(" OR ");
            }
        }
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query.toString());
            if (rs.next()) {
                String rolesValues = rs.getString("role");
                roles.add(rolesValues);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("No role exists for permission " + permissions);
        }
        return roles;
    }
    
    private static synchronized void update(String expression) throws SQLException {

        Statement st = conn.createStatement();    // statements

        int i = st.executeUpdate(expression);    // run the query

        if (i == -1) {
            System.out.println("db error : " + expression);
        }

        st.close();
    }
    
    private static void registerCustomPermissionsAndRoles() { 
        
        try {
               // for 3-leg OAuth demos involving the end user and a 3rd party printer service
               update("INSERT INTO permissions(permission,role) "
                       + "VALUES('" + "printResources" + "', '" + "PrinterService" + "'" 
                       + ")");
               // for OAuth push messaging demos
               update("INSERT INTO permissions(permission,role) "
                       + "VALUES('" + "sendMessages" + "', '" + "MessagingService" + "'" 
                       + ")");
            
        } catch (SQLException ex) {
            throw new RuntimeException("Permissions can not be mapped to roles");
        }
    }
}
