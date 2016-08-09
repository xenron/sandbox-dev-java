package actors;
import akka.actor.*;
import static akka.actor.Actors.*;
import java.util.*;

public class AkkaActorExample {
  // server code
  static class MemoryActor extends UntypedActor {
    final Map<String,Date> seen = new HashMap<String,Date>();

    public void onReceive(Object messageObject) {
      String message = messageObject.toString(); // simplifying assumption
      if (message.equals("DUMP")) {
        getContext().replySafe(seen.toString());      
      } else {
        Date date = new Date();
        seen.put(message.toString(), date);
        getContext().replySafe("'" + message + "' recorded at " + date);
      }
    }
  }
  
  public static void main(String[] args) {
    ActorRef remActor = actorOf(MemoryActor.class).start();
    for (String arg: args) {
      // client code
      Object response = remActor.sendRequestReply(arg);
      System.out.println("Reply received: "+response);
    }
    Object response = remActor.sendRequestReply("DUMP");
    System.out.println("Dump of remembered strings: "+response);
    System.exit(0);
  }
}
