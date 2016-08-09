package tuning.distrib.custom;

import java.lang.reflect.*;
import java.io.*;
import java.net.*;

public class Generate
{
  static String LF;
  static java.util.Vector ServerObjects = new java.util.Vector();
  static java.util.Hashtable ServerNames = new java.util.Hashtable();
  static java.util.Hashtable ServerConnections = new java.util.Hashtable();
  public static void runServer(int port)
    throws Exception
  {
    ServerSocket sock = new ServerSocket(port);
    Socket client;
    ObjectInputStream clientIn;
    ObjectOutputStream clientOut;
    int serverNumber;
    Integer i;
    String serverName;
    GenericServerObject server;
    for(;;)
    {
      try
      {
        client = sock.accept();
        clientOut = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
        clientIn = new ObjectInputStream(client.getInputStream());
        for(;;)
        {
          serverNumber = clientIn.readInt();
          if (serverNumber == -1)
          {
            //Resolve name and return id
            i = (Integer) ServerNames.get(serverName = clientIn.readUTF());
            if ( (i == null) || (ServerObjects.elementAt(i.intValue()) == null) )
            {
              clientOut.writeInt(1); //failed
              clientOut.writeUTF("No server by the name of " + serverName);
              clientOut.flush();
            }
            else
            {
              clientOut.writeInt(0);
              clientOut.writeInt(i.intValue());
              clientOut.writeUTF(ServerObjects.elementAt(i.intValue()).getClass().getName());
              clientOut.flush();
            }
          }
          else if ( (serverNumber >= ServerObjects.size()) || 
               ( (server = (GenericServerObject) ServerObjects.elementAt(serverNumber)) == null) )
          {
            client.close();
            break;
          }
          else
          {
            server.setSocket(client, clientIn, clientOut);
            server.serviceRequest();
          }
        }
      }
      catch(Exception e){}
    }
  }

  public static Object resolveServer(String serverName, String host, int port)
    throws Exception
  {
    Socket client = (Socket) ServerConnections.get(host+port);
    if (client == null)
    {
      client = new Socket(host, port);
      ServerConnections.put(host+port, client);
    }
    ObjectOutputStream clientOut = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
    clientOut.writeInt(-1);
    clientOut.writeUTF(serverName);
    clientOut.flush();
    ObjectInputStream clientIn = new ObjectInputStream(client.getInputStream());
    int resultType = clientIn.readInt();
    if (resultType == 1) throw new Exception(clientIn.readUTF());
    else if (resultType != 0) throw new Exception("Unknown error");
    else
    {
      int id = clientIn.readInt();
      String classname = clientIn.readUTF();
      GenericServerObject serverInstance = (GenericServerObject) Class.forName(classname).newInstance();
      serverInstance.setId(id);
      serverInstance.setSocket(client, clientIn, clientOut);
      return serverInstance;
    }
  }

  public static Class interfaceWithCommunicator(Class c)
    throws Exception
  {
    Class[] interfaces = c.getInterfaces();
    if (interfaces.length == 0)
      return null;
    String communicatorClassName;
    String iname;
    Class found;
    for (int i = 0; i < interfaces.length; i++)
    {
      iname = interfaces[i].getName();
      communicatorClassName = iname.substring(0, iname.lastIndexOf('.')) + "._" +
        iname.substring(iname.lastIndexOf('.')+1) + "Communicator";
      found = null;
      try {found = Class.forName(communicatorClassName);}
      catch(ClassNotFoundException e){found = null;}
      if (found != null)
        return found;
    }    
    //still here - try super-interfaces
    for (int i = 0; i < interfaces.length; i++)
    {
      found = interfaceWithCommunicator(interfaces[i]);
      if (found != null)
        return found;
    }
    return null;
  }

  public synchronized static void addServer(String serverName, Object server)
    throws Exception
  {
    Class communicatorClass = interfaceWithCommunicator(server.getClass());
    GenericServerObject serverInstance = (GenericServerObject) communicatorClass.newInstance();
    serverInstance.setRealServerObject(server);
    int id = ServerObjects.size();
    serverInstance.setId(id);
    ServerObjects.addElement(serverInstance);
    ServerNames.put(serverName, new Integer(id));
  }

  public static void main(String[] args)
  {
    LF = System.getProperty("line.separator");
    try
    {
      for(int i = 0; i < args.length ; i++)
        generate(args[i]);
    }
    catch(Exception e)
    {
      System.out.println(e);
      e.printStackTrace();
    }
  }

  public static void generate(String classname)
    throws Exception
  {
    Class c = Class.forName(classname);
    Method[] methods = c.getMethods();
    char pathSeparator = System.getProperty("file.separator").charAt(0);
    StringBuffer filename = new StringBuffer(
      classname.substring(0, classname.lastIndexOf('.')+1).replace('.', pathSeparator));
    filename.append("_");
    filename.append(classname.substring(classname.lastIndexOf('.')+1));
    filename.append("Communicator.java");
    Writer w = new BufferedWriter(new FileWriter(filename.toString()));

    writeClassDef(w, classname);
    for(int i = methods.length-1; i >=0 ; i--)
      writeMethodDefinition(i, w, methods[i]);
    w.write("public void serviceRequest() throws java.io.IOException {");
    w.write(LF);
    w.write("  int requestNum = sockObjIn.readInt();");
    w.write(LF);
    w.write("  switch(requestNum) {");
    w.write(LF);
    for(int i = methods.length-1; i >=0 ; i--)
      writeServiceResponse(i, w, methods[i]);
    w.write("  }");
    w.write(LF);
    w.write("}");
    w.write(LF);
    w.write("}");
    w.write(LF);
    w.close();
//    System.out.println(w);
  }

  public static void writeClassDef(Writer w, String fullclassname)
    throws IOException
  {
    String classname = fullclassname.substring(fullclassname.lastIndexOf('.')+1);
    w.write("package ");
    w.write(fullclassname.substring(0, fullclassname.lastIndexOf('.')));
    w.write(";");
    w.write(LF);
    w.write("import java.io.BufferedInputStream;");
    w.write(LF);
    w.write("import java.io.ObjectInputStream;");
    w.write(LF);
    w.write("import java.io.BufferedOutputStream;");
    w.write(LF);
    w.write("import java.io.ObjectOutputStream;");
    w.write(LF);
    w.write("public class _");
    w.write(classname);
    w.write("Communicator implements ");
    w.write(classname);
    w.write(", GenericServerObject {");
    w.write(LF);
    w.write("  java.net.Socket sock;");
    w.write(LF);
    w.write("  java.io.ObjectInputStream sockObjIn;");
    w.write(LF);
    w.write("  java.io.ObjectOutputStream sockObjOut;");
    w.write(LF);
    w.write("  int id;");
    w.write(LF);
    w.write("  ");
    w.write(classname);
    w.write("  server;");
    w.write(LF);
    w.write(LF);
    w.write("public void setId(int i) {id = i;}");
    w.write(LF);
    w.write("public void setRealServerObject(Object server) {this.server = (");
    w.write(classname);
    w.write(") server;}");
    w.write(LF);
    w.write("public void setSocket(java.net.Socket client) throws java.io.IOException {");
    w.write(LF);
    w.write("  if (client != sock);");
    w.write("    setSocket(client, new ObjectInputStream(client.getInputStream()), new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream())));");
    w.write(LF);
    w.write("}");
    w.write(LF);
    w.write("public void setSocket(java.net.Socket client, ObjectInputStream in, ObjectOutputStream out) throws java.io.IOException {");
    w.write(LF);
    w.write("  sock = client;");
    w.write(LF);
    w.write("  sockObjOut = out;");
    w.write(LF);
    w.write("  sockObjIn = in;");
    w.write(LF);
    w.write("}");
    w.write(LF);
  }

  public static void writeServiceResponse(int count, Writer w, Method m)
    throws IOException
  {
    Class returnType = m.getReturnType();
    Class[] params = m.getParameterTypes();
    w.write("    case " + count);
    w.write(":");
    w.write(LF);
    w.write("      try {");
    w.write(LF);
    w.write("        ");
    if (returnType != Void.TYPE)
    {
      writeClassName(w, returnType);
      w.write(" x" + count);
      w.write(" = ");
    }
    w.write("server.");
    w.write(m.getName());
    w.write("(");
    for (int j = 0; j < params.length; j++)
    {
      if (!params[j].isPrimitive())
      {
        w.write("(");
        writeClassName(w, params[j]);
        w.write(") ");
      }
      w.write("sockObjIn.read");
      writeMappedDataType(w, params[j]);
      w.write("()");
      if (j < (params.length - 1))
        w.write(", ");
    }
    w.write(");");
    w.write(LF);
    w.write("        sockObjOut.writeInt(0);");
    w.write(LF);
    if (returnType != Void.TYPE)
    {
      w.write("        sockObjOut.write");
      writeMappedDataType(w, returnType);
      w.write("(x" + count);
      w.write(");");
      w.write(LF);
    }
    w.write("        sockObjOut.flush();");
    w.write(LF);
    w.write("      } catch (Exception e) {");
    w.write(LF);
    w.write("        sockObjOut.writeInt(1);");
    w.write(LF);
    w.write("        sockObjOut.writeUTF(e.toString());");
    w.write(LF);
    w.write("        sockObjOut.flush();");
    w.write(LF);
    w.write("      }");
    w.write(LF);
    w.write("      return;");
    w.write(LF);
  }

  public static void writeMethodDefinition(int count, Writer w, Method m)
    throws IOException
  {
    Class returnType = m.getReturnType();
    Class[] params = m.getParameterTypes();
    String[] paramNames = new String[params.length];
    Class[] exceptions = m.getExceptionTypes();
    w.write("public ");
    writeClassName(w, returnType);
    w.write(" ");
    w.write(m.getName());
    w.write("(");
    for (int j = 0; j < params.length; j++)
    {
      writeClassName(w, params[j]);
      paramNames[j] = "x" + j;
      w.write(" ");
      w.write(paramNames[j]);
      if (j < (params.length - 1))
        w.write(", ");
    }
    w.write(")");
    if (exceptions.length > 0)
    {
      w.write(" throws ");
      for (int k = 0; k < exceptions.length; k++)
      {
        writeClassName(w, exceptions[k]);
        if (k < (exceptions.length - 1))
          w.write(", ");
      }
    }
    w.write(" {");
    w.write(LF);
    w.write("  try {");
    w.write(LF);

    w.write("    sockObjOut.writeInt(id);");
    w.write(LF);
    w.write("    sockObjOut.writeInt(" + count);
    w.write(");");
    w.write(LF);
    for (int j = 0; j < params.length; j++)
    {
      
      w.write("    sockObjOut.write");
      writeMappedDataType(w, params[j]);
      w.write("(");
      w.write(paramNames[j]);
      w.write(");");
      w.write(LF);
    }
    w.write("    sockObjOut.flush();");
    w.write(LF);

    w.write("    int responseType = sockObjIn.readInt();");
    w.write(LF);
    w.write("    if (responseType == 0) ");
    if (returnType == Void.TYPE)
      w.write(";");
    else
    {
      w.write(" return ");
      if (!returnType.isPrimitive())
      {
        w.write("(");
        writeClassName(w, returnType);
        w.write(") ");
      }
      w.write("sockObjIn.read");
      writeMappedDataType(w, returnType);
      w.write("();");
    }
    w.write(LF);
    w.write("    else if (responseType == 1) throw new RuntimeException(sockObjIn.readUTF());");
    w.write(LF);
    w.write("    else throw new RuntimeException(\"Unknown communication problem\");");
    w.write(LF);
    w.write("  } catch (Exception e) {throw new RuntimeException(e.toString());}");
    w.write(LF);
    w.write("}");
    w.write(LF);
  }

  static java.util.Hashtable MappedDataType;
  public static void writeMappedDataType(Writer w, Class c)
    throws IOException
  {
    if (MappedDataType == null)
    {
      MappedDataType = new java.util.Hashtable();
      MappedDataType.put("boolean", "Boolean");
      MappedDataType.put("float", "Float");
      MappedDataType.put("double", "Double");
      MappedDataType.put("long", "Long");
      MappedDataType.put("int", "Int");
      MappedDataType.put("short", "Short");
      MappedDataType.put("char", "Char");
      MappedDataType.put("byte", "Byte");
    }
    if (c.isPrimitive())
    {
      w.write((String) MappedDataType.get(c.getName()));
    }
    else
    {
      w.write("Object");
    }
  }

  public static void writeClassName(Writer w, Class c)
    throws IOException
  {
    if (c.isArray())
    {
      writeClassName(w, c.getComponentType());
      w.write("[]");
    }
    else
      w.write(c.getName());
  }
}
