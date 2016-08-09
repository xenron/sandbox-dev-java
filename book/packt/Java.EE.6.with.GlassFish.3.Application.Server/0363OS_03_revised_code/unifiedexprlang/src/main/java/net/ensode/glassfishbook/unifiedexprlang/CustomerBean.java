package net.ensode.glassfishbook.unifiedexprlang;

public class CustomerBean
{

  public CustomerBean()
  {

  }

  public CustomerBean(String firstName, String lastName)
  {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  private String firstName;
  private String lastName;

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  
  @Override
  public String toString()
  {
    StringBuffer fullNameBuffer = new StringBuffer();
    
    fullNameBuffer.append(firstName);
    fullNameBuffer.append(" ");
    fullNameBuffer.append(lastName);
    
    return fullNameBuffer.toString();
  }

}
