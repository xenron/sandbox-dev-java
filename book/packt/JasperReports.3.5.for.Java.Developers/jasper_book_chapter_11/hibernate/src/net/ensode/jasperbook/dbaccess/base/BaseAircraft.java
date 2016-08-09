package net.ensode.jasperbook.dbaccess.base;

import java.lang.Comparable;
import java.io.Serializable;

/**
 * This is an object that contains data related to the aircraft table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="aircraft"
 */

public abstract class BaseAircraft implements Comparable, Serializable
{

  public static String REF = "Aircraft";
  public static String PROP_AIRCRAFT_SERIAL = "AircraftSerial";
  public static String PROP_AIRCRAFT_TYPE_ID = "AircraftTypeId";
  public static String PROP_STATE = "State";
  public static String PROP_REGISTRANT_TYPE_ID = "RegistrantTypeId";
  public static String PROP_ADDRESS1 = "Address1";
  public static String PROP_AIR_WORTH_DATE = "AirWorthDate";
  public static String PROP_ZIP = "Zip";
  public static String PROP_CITY = "City";
  public static String PROP_MODE_S_CODE = "ModeSCode";
  public static String PROP_COUNTY = "County";
  public static String PROP_YEAR_BUILT = "YearBuilt";
  public static String PROP_AIRCRAFT_ENGINE_TYPE_ID = "AircraftEngineTypeId";
  public static String PROP_STATUS_CODE = "StatusCode";
  public static String PROP_REGION = "Region";
  public static String PROP_AIRCRAFT_MODEL_CODE = "AircraftModelCode";
  public static String PROP_AIRCRAFT_ENGINE_CODE = "AircraftEngineCode";
  public static String PROP_FRACT_OWNER = "FractOwner";
  public static String PROP_LAST_ACTION_DATE = "LastActionDate";
  public static String PROP_COUNTRY = "Country";
  public static String PROP_NAME = "Name";
  public static String PROP_ID = "Id";
  public static String PROP_CERT_ISSUE_DATE = "CertIssueDate";
  public static String PROP_ADDRESS2 = "Address2";
  public static String PROP_CERTIFICATION = "Certification";

  // constructors
  public BaseAircraft()
  {
    initialize();
  }

  /**
   * Constructor for primary key
   */
  public BaseAircraft(java.lang.String id)
  {
    this.setId(id);
    initialize();
  }

  /**
   * Constructor for required fields
   */
  public BaseAircraft(java.lang.String id, java.lang.String aircraftSerial,
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

    this.setId(id);
    this.setAircraftSerial(aircraftSerial);
    this.setAircraftModelCode(aircraftModelCode);
    this.setAircraftEngineCode(aircraftEngineCode);
    this.setYearBuilt(yearBuilt);
    this.setAircraftTypeId(aircraftTypeId);
    this.setAircraftEngineTypeId(aircraftEngineTypeId);
    this.setRegistrantTypeId(registrantTypeId);
    this.setName(name);
    this.setAddress1(address1);
    this.setAddress2(address2);
    this.setCity(city);
    this.setState(state);
    this.setZip(zip);
    this.setRegion(region);
    this.setCounty(county);
    this.setCountry(country);
    this.setCertification(certification);
    this.setStatusCode(statusCode);
    this.setModeSCode(modeSCode);
    this.setFractOwner(fractOwner);
    this.setLastActionDate(lastActionDate);
    this.setCertIssueDate(certIssueDate);
    this.setAirWorthDate(airWorthDate);
    initialize();
  }

  protected void initialize()
  {
  }

  private int hashCode = Integer.MIN_VALUE;

  // primary key
  private java.lang.String id;

  // fields
  private java.lang.String aircraftSerial;
  private java.lang.String aircraftModelCode;
  private java.lang.String aircraftEngineCode;
  private java.lang.String yearBuilt;
  private java.lang.String aircraftTypeId;
  private java.lang.String aircraftEngineTypeId;
  private java.lang.String registrantTypeId;
  private java.lang.String name;
  private java.lang.String address1;
  private java.lang.String address2;
  private java.lang.String city;
  private java.lang.String state;
  private java.lang.String zip;
  private java.lang.String region;
  private java.lang.String county;
  private java.lang.String country;
  private java.lang.String certification;
  private java.lang.String statusCode;
  private java.lang.String modeSCode;
  private java.lang.String fractOwner;
  private java.util.Date lastActionDate;
  private java.util.Date certIssueDate;
  private java.util.Date airWorthDate;

  /**
   * Return the unique identifier of this class
   * 
   * @hibernate.id generator-class="sequence" column="tail_num"
   */
  public java.lang.String getId()
  {
    return id;
  }

  /**
   * Set the unique identifier of this class
   * 
   * @param id
   *          the new ID
   */
  public void setId(java.lang.String id)
  {
    this.id = id;
    this.hashCode = Integer.MIN_VALUE;
  }

  /**
   * Return the value associated with the column: aircraft_serial
   */
  public java.lang.String getAircraftSerial()
  {
    return aircraftSerial;
  }

  /**
   * Set the value related to the column: aircraft_serial
   * 
   * @param aircraftSerial
   *          the aircraft_serial value
   */
  public void setAircraftSerial(java.lang.String aircraftSerial)
  {
    this.aircraftSerial = aircraftSerial;
  }

  /**
   * Return the value associated with the column: aircraft_model_code
   */
  public java.lang.String getAircraftModelCode()
  {
    return aircraftModelCode;
  }

  /**
   * Set the value related to the column: aircraft_model_code
   * 
   * @param aircraftModelCode
   *          the aircraft_model_code value
   */
  public void setAircraftModelCode(java.lang.String aircraftModelCode)
  {
    this.aircraftModelCode = aircraftModelCode;
  }

  /**
   * Return the value associated with the column: aircraft_engine_code
   */
  public java.lang.String getAircraftEngineCode()
  {
    return aircraftEngineCode;
  }

  /**
   * Set the value related to the column: aircraft_engine_code
   * 
   * @param aircraftEngineCode
   *          the aircraft_engine_code value
   */
  public void setAircraftEngineCode(java.lang.String aircraftEngineCode)
  {
    this.aircraftEngineCode = aircraftEngineCode;
  }

  /**
   * Return the value associated with the column: year_built
   */
  public java.lang.String getYearBuilt()
  {
    return yearBuilt;
  }

  /**
   * Set the value related to the column: year_built
   * 
   * @param yearBuilt
   *          the year_built value
   */
  public void setYearBuilt(java.lang.String yearBuilt)
  {
    this.yearBuilt = yearBuilt;
  }

  /**
   * Return the value associated with the column: aircraft_type_id
   */
  public java.lang.String getAircraftTypeId()
  {
    return aircraftTypeId;
  }

  /**
   * Set the value related to the column: aircraft_type_id
   * 
   * @param aircraftTypeId
   *          the aircraft_type_id value
   */
  public void setAircraftTypeId(java.lang.String aircraftTypeId)
  {
    this.aircraftTypeId = aircraftTypeId;
  }

  /**
   * Return the value associated with the column: aircraft_engine_type_id
   */
  public java.lang.String getAircraftEngineTypeId()
  {
    return aircraftEngineTypeId;
  }

  /**
   * Set the value related to the column: aircraft_engine_type_id
   * 
   * @param aircraftEngineTypeId
   *          the aircraft_engine_type_id value
   */
  public void setAircraftEngineTypeId(java.lang.String aircraftEngineTypeId)
  {
    this.aircraftEngineTypeId = aircraftEngineTypeId;
  }

  /**
   * Return the value associated with the column: registrant_type_id
   */
  public java.lang.String getRegistrantTypeId()
  {
    return registrantTypeId;
  }

  /**
   * Set the value related to the column: registrant_type_id
   * 
   * @param registrantTypeId
   *          the registrant_type_id value
   */
  public void setRegistrantTypeId(java.lang.String registrantTypeId)
  {
    this.registrantTypeId = registrantTypeId;
  }

  /**
   * Return the value associated with the column: name
   */
  public java.lang.String getName()
  {
    return name;
  }

  /**
   * Set the value related to the column: name
   * 
   * @param name
   *          the name value
   */
  public void setName(java.lang.String name)
  {
    this.name = name;
  }

  /**
   * Return the value associated with the column: address1
   */
  public java.lang.String getAddress1()
  {
    return address1;
  }

  /**
   * Set the value related to the column: address1
   * 
   * @param address1
   *          the address1 value
   */
  public void setAddress1(java.lang.String address1)
  {
    this.address1 = address1;
  }

  /**
   * Return the value associated with the column: address2
   */
  public java.lang.String getAddress2()
  {
    return address2;
  }

  /**
   * Set the value related to the column: address2
   * 
   * @param address2
   *          the address2 value
   */
  public void setAddress2(java.lang.String address2)
  {
    this.address2 = address2;
  }

  /**
   * Return the value associated with the column: city
   */
  public java.lang.String getCity()
  {
    return city;
  }

  /**
   * Set the value related to the column: city
   * 
   * @param city
   *          the city value
   */
  public void setCity(java.lang.String city)
  {
    this.city = city;
  }

  /**
   * Return the value associated with the column: state
   */
  public java.lang.String getState()
  {
    return state;
  }

  /**
   * Set the value related to the column: state
   * 
   * @param state
   *          the state value
   */
  public void setState(java.lang.String state)
  {
    this.state = state;
  }

  /**
   * Return the value associated with the column: zip
   */
  public java.lang.String getZip()
  {
    return zip;
  }

  /**
   * Set the value related to the column: zip
   * 
   * @param zip
   *          the zip value
   */
  public void setZip(java.lang.String zip)
  {
    this.zip = zip;
  }

  /**
   * Return the value associated with the column: region
   */
  public java.lang.String getRegion()
  {
    return region;
  }

  /**
   * Set the value related to the column: region
   * 
   * @param region
   *          the region value
   */
  public void setRegion(java.lang.String region)
  {
    this.region = region;
  }

  /**
   * Return the value associated with the column: county
   */
  public java.lang.String getCounty()
  {
    return county;
  }

  /**
   * Set the value related to the column: county
   * 
   * @param county
   *          the county value
   */
  public void setCounty(java.lang.String county)
  {
    this.county = county;
  }

  /**
   * Return the value associated with the column: country
   */
  public java.lang.String getCountry()
  {
    return country;
  }

  /**
   * Set the value related to the column: country
   * 
   * @param country
   *          the country value
   */
  public void setCountry(java.lang.String country)
  {
    this.country = country;
  }

  /**
   * Return the value associated with the column: certification
   */
  public java.lang.String getCertification()
  {
    return certification;
  }

  /**
   * Set the value related to the column: certification
   * 
   * @param certification
   *          the certification value
   */
  public void setCertification(java.lang.String certification)
  {
    this.certification = certification;
  }

  /**
   * Return the value associated with the column: status_code
   */
  public java.lang.String getStatusCode()
  {
    return statusCode;
  }

  /**
   * Set the value related to the column: status_code
   * 
   * @param statusCode
   *          the status_code value
   */
  public void setStatusCode(java.lang.String statusCode)
  {
    this.statusCode = statusCode;
  }

  /**
   * Return the value associated with the column: mode_s_code
   */
  public java.lang.String getModeSCode()
  {
    return modeSCode;
  }

  /**
   * Set the value related to the column: mode_s_code
   * 
   * @param modeSCode
   *          the mode_s_code value
   */
  public void setModeSCode(java.lang.String modeSCode)
  {
    this.modeSCode = modeSCode;
  }

  /**
   * Return the value associated with the column: fract_owner
   */
  public java.lang.String getFractOwner()
  {
    return fractOwner;
  }

  /**
   * Set the value related to the column: fract_owner
   * 
   * @param fractOwner
   *          the fract_owner value
   */
  public void setFractOwner(java.lang.String fractOwner)
  {
    this.fractOwner = fractOwner;
  }

  /**
   * Return the value associated with the column: last_action_date
   */
  public java.util.Date getLastActionDate()
  {
    return lastActionDate;
  }

  /**
   * Set the value related to the column: last_action_date
   * 
   * @param lastActionDate
   *          the last_action_date value
   */
  public void setLastActionDate(java.util.Date lastActionDate)
  {
    this.lastActionDate = lastActionDate;
  }

  /**
   * Return the value associated with the column: cert_issue_date
   */
  public java.util.Date getCertIssueDate()
  {
    return certIssueDate;
  }

  /**
   * Set the value related to the column: cert_issue_date
   * 
   * @param certIssueDate
   *          the cert_issue_date value
   */
  public void setCertIssueDate(java.util.Date certIssueDate)
  {
    this.certIssueDate = certIssueDate;
  }

  /**
   * Return the value associated with the column: air_worth_date
   */
  public java.util.Date getAirWorthDate()
  {
    return airWorthDate;
  }

  /**
   * Set the value related to the column: air_worth_date
   * 
   * @param airWorthDate
   *          the air_worth_date value
   */
  public void setAirWorthDate(java.util.Date airWorthDate)
  {
    this.airWorthDate = airWorthDate;
  }

  public boolean equals(Object obj)
  {
    if (null == obj)
      return false;
    if (!(obj instanceof net.ensode.jasperbook.dbaccess.Aircraft))
      return false;
    else
    {
      net.ensode.jasperbook.dbaccess.Aircraft aircraft = (net.ensode.jasperbook.dbaccess.Aircraft) obj;
      if (null == this.getId() || null == aircraft.getId())
        return false;
      else
        return (this.getId().equals(aircraft.getId()));
    }
  }

  public int hashCode()
  {
    if (Integer.MIN_VALUE == this.hashCode)
    {
      if (null == this.getId())
        return super.hashCode();
      else
      {
        String hashStr = this.getClass().getName() + ":"
            + this.getId().hashCode();
        this.hashCode = hashStr.hashCode();
      }
    }
    return this.hashCode;
  }

  public int compareTo(Object obj)
  {
    if (obj.hashCode() > hashCode())
      return 1;
    else if (obj.hashCode() < hashCode())
      return -1;
    else
      return 0;
  }

  public String toString()
  {
    return super.toString();
  }

}