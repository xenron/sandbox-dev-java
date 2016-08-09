package net.ensode.jasperbook.dbaccess.base;

import java.lang.Comparable;
import java.io.Serializable;

/**
 * This is an object that contains data related to the aircraft_types table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="aircraft_types"
 */

public abstract class BaseAircraftTypes implements Comparable, Serializable
{

  public static String REF = "AircraftTypes";
  public static String PROP_DESCRIPTION = "Description";
  public static String PROP_ID = "Id";

  // constructors
  public BaseAircraftTypes()
  {
    initialize();
  }

  /**
   * Constructor for primary key
   */
  public BaseAircraftTypes(java.lang.String id)
  {
    this.setId(id);
    initialize();
  }

  /**
   * Constructor for required fields
   */
  public BaseAircraftTypes(java.lang.String id, java.lang.String description)
  {

    this.setId(id);
    this.setDescription(description);
    initialize();
  }

  protected void initialize()
  {
  }

  private int hashCode = Integer.MIN_VALUE;

  // primary key
  private java.lang.String id;

  // fields
  private java.lang.String description;

  /**
   * Return the unique identifier of this class
   * 
   * @hibernate.id column="aircraft_type_id"
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
   * Return the value associated with the column: description
   */
  public java.lang.String getDescription()
  {
    return description;
  }

  /**
   * Set the value related to the column: description
   * 
   * @param description
   *          the description value
   */
  public void setDescription(java.lang.String description)
  {
    this.description = description;
  }

  public boolean equals(Object obj)
  {
    if (null == obj)
      return false;
    if (!(obj instanceof net.ensode.jasperbook.dbaccess.AircraftTypes))
      return false;
    else
    {
      net.ensode.jasperbook.dbaccess.AircraftTypes aircraftTypes = (net.ensode.jasperbook.dbaccess.AircraftTypes) obj;
      if (null == this.getId() || null == aircraftTypes.getId())
        return false;
      else
        return (this.getId().equals(aircraftTypes.getId()));
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