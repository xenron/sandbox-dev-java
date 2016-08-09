package tuning.distrib.custom;

public interface ServerObject
{
  public abstract boolean getBoolean();
  public abstract int getNumber();
  public abstract String getString();
  public abstract void setBoolean(boolean flag);
  public abstract void setNumber(int i);
  public abstract void setString(String obj);
  public abstract void setAll(boolean flag, int i, String obj);
}
