package net.ensode.glassfishbook.jdbcselect;

public class UsStateBean
{
  public UsStateBean()
  {

  }

  public UsStateBean(String stateName, String stateCode)
  {
    this.stateName = stateName;
    this.stateCode = stateCode;
  }

  private String stateName;
  private String stateCode;

  public String getStateCode()
  {
    return stateCode;
  }

  public void setStateCode(String stateCode)
  {
    this.stateCode = stateCode;
  }

  public String getStateName()
  {
    return stateName;
  }

  public void setStateName(String stateName)
  {
    this.stateName = stateName;
  }

}
