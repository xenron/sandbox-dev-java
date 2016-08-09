package tuning.distrib.custom;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
public class _ServerObjectCommunicator implements ServerObject, GenericServerObject {
  java.net.Socket sock;
  java.io.ObjectInputStream sockObjIn;
  java.io.ObjectOutputStream sockObjOut;
  int id;
  ServerObject  server;

public void setId(int i) {id = i;}
public void setRealServerObject(Object server) {this.server = (ServerObject) server;}
public void setSocket(java.net.Socket client) throws java.io.IOException {
  if (client != sock);    setSocket(client, new ObjectInputStream(client.getInputStream()), new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream())));
}
public void setSocket(java.net.Socket client, ObjectInputStream in, ObjectOutputStream out) throws java.io.IOException {
  sock = client;
  sockObjOut = out;
  sockObjIn = in;
}
public void setAll(boolean x0, int x1, java.lang.String x2) {
  try {
    sockObjOut.writeInt(id);
    sockObjOut.writeInt(6);
    sockObjOut.writeBoolean(x0);
    sockObjOut.writeInt(x1);
    sockObjOut.writeObject(x2);
    sockObjOut.flush();
    int responseType = sockObjIn.readInt();
    if (responseType == 0) ;
    else if (responseType == 1) throw new RuntimeException(sockObjIn.readUTF());
    else throw new RuntimeException("Unknown communication problem");
  } catch (Exception e) {throw new RuntimeException(e.toString());}
}
public void setString(java.lang.String x0) {
  try {
    sockObjOut.writeInt(id);
    sockObjOut.writeInt(5);
    sockObjOut.writeObject(x0);
    sockObjOut.flush();
    int responseType = sockObjIn.readInt();
    if (responseType == 0) ;
    else if (responseType == 1) throw new RuntimeException(sockObjIn.readUTF());
    else throw new RuntimeException("Unknown communication problem");
  } catch (Exception e) {throw new RuntimeException(e.toString());}
}
public void setNumber(int x0) {
  try {
    sockObjOut.writeInt(id);
    sockObjOut.writeInt(4);
    sockObjOut.writeInt(x0);
    sockObjOut.flush();
    int responseType = sockObjIn.readInt();
    if (responseType == 0) ;
    else if (responseType == 1) throw new RuntimeException(sockObjIn.readUTF());
    else throw new RuntimeException("Unknown communication problem");
  } catch (Exception e) {throw new RuntimeException(e.toString());}
}
public void setBoolean(boolean x0) {
  try {
    sockObjOut.writeInt(id);
    sockObjOut.writeInt(3);
    sockObjOut.writeBoolean(x0);
    sockObjOut.flush();
    int responseType = sockObjIn.readInt();
    if (responseType == 0) ;
    else if (responseType == 1) throw new RuntimeException(sockObjIn.readUTF());
    else throw new RuntimeException("Unknown communication problem");
  } catch (Exception e) {throw new RuntimeException(e.toString());}
}
public java.lang.String getString() {
  try {
    sockObjOut.writeInt(id);
    sockObjOut.writeInt(2);
    sockObjOut.flush();
    int responseType = sockObjIn.readInt();
    if (responseType == 0)  return (java.lang.String) sockObjIn.readObject();
    else if (responseType == 1) throw new RuntimeException(sockObjIn.readUTF());
    else throw new RuntimeException("Unknown communication problem");
  } catch (Exception e) {throw new RuntimeException(e.toString());}
}
public int getNumber() {
  try {
    sockObjOut.writeInt(id);
    sockObjOut.writeInt(1);
    sockObjOut.flush();
    int responseType = sockObjIn.readInt();
    if (responseType == 0)  return sockObjIn.readInt();
    else if (responseType == 1) throw new RuntimeException(sockObjIn.readUTF());
    else throw new RuntimeException("Unknown communication problem");
  } catch (Exception e) {throw new RuntimeException(e.toString());}
}
public boolean getBoolean() {
  try {
    sockObjOut.writeInt(id);
    sockObjOut.writeInt(0);
    sockObjOut.flush();
    int responseType = sockObjIn.readInt();
    if (responseType == 0)  return sockObjIn.readBoolean();
    else if (responseType == 1) throw new RuntimeException(sockObjIn.readUTF());
    else throw new RuntimeException("Unknown communication problem");
  } catch (Exception e) {throw new RuntimeException(e.toString());}
}
public void serviceRequest() throws java.io.IOException {
  int requestNum = sockObjIn.readInt();
  switch(requestNum) {
    case 6:
      try {
        server.setAll(sockObjIn.readBoolean(), sockObjIn.readInt(), (java.lang.String) sockObjIn.readObject());
        sockObjOut.writeInt(0);
        sockObjOut.flush();
      } catch (Exception e) {
        sockObjOut.writeInt(1);
        sockObjOut.writeUTF(e.toString());
        sockObjOut.flush();
      }
      return;
    case 5:
      try {
        server.setString((java.lang.String) sockObjIn.readObject());
        sockObjOut.writeInt(0);
        sockObjOut.flush();
      } catch (Exception e) {
        sockObjOut.writeInt(1);
        sockObjOut.writeUTF(e.toString());
        sockObjOut.flush();
      }
      return;
    case 4:
      try {
        server.setNumber(sockObjIn.readInt());
        sockObjOut.writeInt(0);
        sockObjOut.flush();
      } catch (Exception e) {
        sockObjOut.writeInt(1);
        sockObjOut.writeUTF(e.toString());
        sockObjOut.flush();
      }
      return;
    case 3:
      try {
        server.setBoolean(sockObjIn.readBoolean());
        sockObjOut.writeInt(0);
        sockObjOut.flush();
      } catch (Exception e) {
        sockObjOut.writeInt(1);
        sockObjOut.writeUTF(e.toString());
        sockObjOut.flush();
      }
      return;
    case 2:
      try {
        java.lang.String x2 = server.getString();
        sockObjOut.writeInt(0);
        sockObjOut.writeObject(x2);
        sockObjOut.flush();
      } catch (Exception e) {
        sockObjOut.writeInt(1);
        sockObjOut.writeUTF(e.toString());
        sockObjOut.flush();
      }
      return;
    case 1:
      try {
        int x1 = server.getNumber();
        sockObjOut.writeInt(0);
        sockObjOut.writeInt(x1);
        sockObjOut.flush();
      } catch (Exception e) {
        sockObjOut.writeInt(1);
        sockObjOut.writeUTF(e.toString());
        sockObjOut.flush();
      }
      return;
    case 0:
      try {
        boolean x0 = server.getBoolean();
        sockObjOut.writeInt(0);
        sockObjOut.writeBoolean(x0);
        sockObjOut.flush();
      } catch (Exception e) {
        sockObjOut.writeInt(1);
        sockObjOut.writeUTF(e.toString());
        sockObjOut.flush();
      }
      return;
  }
}
}
