package net.ensode.jasperbook.dbaccess;

import net.ensode.jasperbook.dbaccess.base.BaseAircraft;

public class Aircraft extends BaseAircraft
{
  private static final long serialVersionUID = 1L;

  /* [CONSTRUCTOR MARKER BEGIN] */
  public Aircraft()
  {
    super();
  }

  /**
   * Constructor for primary key
   */
  public Aircraft(java.lang.String id)
  {
    super(id);
  }

  /**
   * Constructor for required fields
   */
  public Aircraft(java.lang.String id, java.lang.String aircraftSerial,
      java.lang.String aircraftModelCode, java.lang.String aircraftEngineCode,
      java.lang.String yearBuilt, java.lang.String aircraftTypeId,
      java.lang.String aircraftEngineTypeId, java.lang.String registrantTypeId,
      java.lang.String name, java.lang.String address1,
      java.lang.String address2, java.lang.String city, java.lang.String state,
      java.lang.String zip, java.lang.String region, java.lang.String county,
      java.lang.String country, java.lang.String certification,
      java.lang.String statusCode, java.lang.String modeSCode,
      java.lang.String fractOwner, java.util.Date lastActionDate,
      java.util.Date certIssueDate, java.util.Date airWorthDate)
  {

    super(id, aircraftSerial, aircraftModelCode, aircraftEngineCode, yearBuilt,
        aircraftTypeId, aircraftEngineTypeId, registrantTypeId, name, address1,
        address2, city, state, zip, region, county, country, certification,
        statusCode, modeSCode, fractOwner, lastActionDate, certIssueDate,
        airWorthDate);
  }

  /* [CONSTRUCTOR MARKER END] */

}