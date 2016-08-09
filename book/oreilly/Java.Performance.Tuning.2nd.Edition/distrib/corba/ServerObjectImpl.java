package tuning.distrib.corba;

public class ServerObjectImpl
  extends _ServerObjectImplBase
{
  public ServerObjectImpl()
  {
    super();
    System.out.println("ServerObjectImpl created");
  }
  boolean bool;
  int num;
  String string;
  public boolean getBoolean() {return bool;}
  public int getNumber() {return num;}
  public String getString() {return string;}
  public void setBoolean(boolean b) {bool = b;}
  public void setNumber(int i) {num = i;}
  public void setString(String s) {string = s;}
  public void setAll(boolean b, int i, String s)
  {
    bool = b; num = i; string = s;
  }
}

