
package com.oreilly.ajax;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author steveo
 *
 */
public final class UserBean extends Object
{

  /**
   * 
   */
  private String password;
  /**
   * 
   */
  private String name;

  public UserBean()
  {
    super();
    // TODO Auto-generated constructor stub
  }
  public String loginUser() {
      if("myeclipse".equals(getName()) && "myeclipse".equals(getPassword()))
          return "success";
     
      FacesContext facesContext = FacesContext.getCurrentInstance();
      FacesMessage facesMessage = new FacesMessage(
          "You have entered an invalid user name and/or password");
      facesContext.addMessage("loginForm", facesMessage);
     
      return "failure";
  }
   

  /**
   * @return Returns the password.
   */
  public String getPassword()
  {
    return password;
  }

  /**
   * @param password The password to set.
   */
  public void setPassword(String password)
  {
    this.password = password;
  }

  /**
   * @return Returns the userName.
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param userName The userName to set.
   */
  public void setName(String userName)
  {
    this.name = userName;
  }

}
