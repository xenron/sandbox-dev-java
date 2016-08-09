package org.jboss.resteasy.examples.oauth;

import org.jboss.resteasy.auth.oauth.OAuthConsumerRegistration;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.examples.oauth.provider.OAuthDBProvider;
import org.jboss.resteasy.util.Base64;
import org.jboss.resteasy.util.HttpResponseCodes;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.Properties;



@Path("receiver/subscriber")
public class SubscriberReceiver
{
    private static final String MessagingServiceCallbackRegistrationURL;
    private static final String MessagingServiceMessagesURL;
    
    private static final String MESSAGING_SERVICE_ID = "http://www.messaging-service.com/2";
    
    static {
        Properties props = new Properties();
        try {
            props.load(Subscriber.class.getResourceAsStream("/oauth.properties"));
        } catch (Exception ex) {
            throw new RuntimeException("oauth.properties resource is not available");
        }
        MessagingServiceCallbackRegistrationURL = props.getProperty("messaging.service.callbacks.url");
        MessagingServiceMessagesURL = props.getProperty("messaging.service.messages.url");
    } 
    

   @Context 
   private UriInfo ui;
   
   private OAuthConsumerRegistration consumerRegistration; 
   private String greetingMessage; 
   
    
   public SubscriberReceiver() {
       // Will be injected/configured
       consumerRegistration = new OAuthDBProvider();
   }
   
   @GET
   @RolesAllowed("JBossAdmin")
   public String getMessage()
   {
       registerMessagingService(MESSAGING_SERVICE_ID);
       
       String callbackURI = getCallbackURI();
       registerMessagingServiceScopes(MESSAGING_SERVICE_ID, callbackURI);
       
       registerMessagingServiceCallback(MESSAGING_SERVICE_ID, callbackURI);       
       
       produceMessages();
       
       synchronized (this) 
       {
           while (greetingMessage == null) 
           {
               try {
                   wait(2000);
               } catch (InterruptedException ex) {
                   break;
               }
           } 
           if (greetingMessage == null)
           {
               throw new WebApplicationException(500);
           }
           return greetingMessage;
       }
   }
   
   @POST
   @Consumes("text/plain")
   @RolesAllowed("user")
   public Response receiveMessage(String value)
   {
       synchronized (this) 
       {
           greetingMessage = value;
           notify();
       }
       
       return Response.ok().build();
   }
   
   private String registerMessagingService(String consumerKey) {
       try {
           return consumerRegistration.registerConsumer(consumerKey, "", "").getSecret();
       } catch (Exception ex) {
           throw new RuntimeException(consumerKey + " can not be registered");
       }
   }
   
   private void registerMessagingServiceScopes(String consumerKey, String scope)
   {
       try {
           consumerRegistration.registerConsumerScopes(consumerKey, new String[] {scope});
       } catch (Exception ex) {
           throw new RuntimeException(consumerKey + " scopes can not be registered");
       }
   }
   
   private String getCallbackURI() {
       UriBuilder ub = ui.getBaseUriBuilder();
       return ub.path(SubscriberReceiver.class).build().toString();
   }
   
   public void registerMessagingServiceCallback(String consumerKey, String callback)
   {
      ClientRequest request = new ClientRequest(MessagingServiceCallbackRegistrationURL);
      String base64Credentials = new String(Base64.encodeBytes("admin:admin".getBytes()));
      request.header("Authorization", "Basic " + base64Credentials);
      request.formParameter("consumer_id", consumerKey);
      request.formParameter("callback_uri", callback);
      ClientResponse<?> response = null;
      try {
         response = request.post();
         if (HttpResponseCodes.SC_OK != response.getStatus()) {
            throw new RuntimeException("Callback Registration failed");
         }
      }
      catch (Exception ex) {
         throw new RuntimeException("Callback Registration failed");
      }
      finally {
         response.releaseConnection();
      }
   }
   
   public void produceMessages()
    {
      ClientRequest request = new ClientRequest(MessagingServiceMessagesURL);
      String base64Credentials = new String(Base64.encodeBytes("admin:admin".getBytes()));
      request.header("Authorization", "Basic " + base64Credentials);
      request.body("text/plain", "Hello2 !");
      ClientResponse<?> response = null;
      try {
         response = request.post();
         if (HttpResponseCodes.SC_OK != response.getStatus()) {
            throw new RuntimeException("Messages can not be sent");
         }
      }
      catch (Exception ex) {
         throw new RuntimeException("Messages can not be sent");
      }
      finally {
         response.releaseConnection();
      }
    }
}
