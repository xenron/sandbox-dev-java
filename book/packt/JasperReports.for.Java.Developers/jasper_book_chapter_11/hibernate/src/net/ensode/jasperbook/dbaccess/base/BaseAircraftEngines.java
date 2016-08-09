package net.ensode.jasperbook.dbaccess.base;

import java.lang.Comparable;
import java.io.Serializable;

/**
 * This is an object that contains data related to the aircraft_engines table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="aircraft_engines"
 */

public abstract class BaseAircraftEngines implements Comparable, Serializable
{

  public static String REF = "AircraftEngines";
  public static String PROP_MODEL = "Model";
  public static String PROP_AIRCRAFT_ENGINE_TYPE_ID = "AircraftEngineTypeId";
  public static String PROP_FUEL_CONSUMED = "FuelConsumed";
  public static String PROP_HORSEPOWER = "Horsepower";
  public static String PROP_THRUST = "Thrust";
  public static String PROP_MANUFACTURER = "Manufacturer";
  public static String PROP_ID = "Id";

  // constructors
  public BaseAircraftEngines()
  {
    initialize();
  }

  /**
   * Constructor for primary key
   */
  public BaseAircraftEngines(java.lang.String id)
  {
    this.setId(id);
    initialize();
  }

  /**
   * Constructor for required fields
   */
  public BaseAircraftEngines(java.lang.String id,
      java.lang.String manufacturer, java.lang.String model,
      java.lang.String aircraftEngineTypeId, java.lang.String horsepower,
      java.lang.String thrust, java.math.BigDecimal fuelConsumed)
  {

    this.setId(id);
    this.setManufacturer(manufacturer);
    this.setModel(model);
    this.setAircraftEngineTypeId(aircraftEngineTypeId);
    this.setHorsepower(horsepower);
    this.setThrust(thrust);
    this.setFuelConsumed(fuelConsumed);
    initialize();
  }

  protected void initialize()
  {
  }

  private int hashCode = Integer.MIN_VALUE;

  // primary key
  private java.lang.String id;

  // fields
  private java.lang.String manufacturer;
  private java.lang.String model;
  private java.lang.String aircraftEngineTypeId;
  private java.lang.String horsepower;
  private java.lang.String thrust;
  private java.math.BigDecimal fuelConsumed;

  /**
   * Return the unique identifier of this class
   * 
   * @hibernate.id generator-class="sequence" column="aircraft_engine_code"
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
   * Return the value associated with the column: manufacturer
   */
  public java.lang.String getManufacturer()
  {
    return manufacturer;
  }

  /**
   * Set the value related to the column: manufacturer
   * 
   * @param manufacturer
   *          the manufacturer value
   */
  public void setManufacturer(java.lang.String manufacturer)
  {
    this.manufacturer = manufacturer;
  }

  /**
   * Return the value associated with the column: model
   */
  public java.lang.String getModel()
  {
    return model;
  }

  /**
   * Set the value related to the column: model
   * 
   * @param model
   *          the model value
   */
  public void setModel(java.lang.String model)
  {
    this.model = model;
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
   * Return the value associated with the column: horsepower
   */
  public java.lang.String getHorsepower()
  {
    return horsepower;
  }

  /**
   * Set the value related to the column: horsepower
   * 
   * @param horsepower
   *          the horsepower value
   */
  public void setHorsepower(java.lang.String horsepower)
  {
    this.horsepower = horsepower;
  }

  /**
   * Return the value associated with the column: thrust
   */
  public java.lang.String getThrust()
  {
    return thrust;
  }

  /**
   * Set the value related to the column: thrust
   * 
   * @param thrust
   *          the thrust value
   */
  public void setThrust(java.lang.String thrust)
  {
    this.thrust = thrust;
  }

  /**
   * Return the value associated with the column: fuel_consumed
   */
  public java.math.BigDecimal getFuelConsumed()
  {
    return fuelConsumed;
  }

  /**
   * Set the value related to the column: fuel_consumed
   * 
   * @param fuelConsumed
   *          the fuel_consumed value
   */
  public void setFuelConsumed(java.math.BigDecimal fuelConsumed)
  {
    this.fuelConsumed = fuelConsumed;
  }

  public boolean equals(Object obj)
  {
    if (null == obj)
      return false;
    if (!(obj instanceof net.ensode.jasperbook.dbaccess.AircraftEngines))
      return false;
    else
    {
      net.ensode.jasperbook.dbaccess.AircraftEngines aircraftEngines = (net.ensode.jasperbook.dbaccess.AircraftEngines) obj;
      if (null == this.getId() || null == aircraftEngines.getId())
        return false;
      else
        return (this.getId().equals(aircraftEngines.getId()));
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