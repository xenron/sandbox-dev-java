package net.ensode.jasperbook.dbaccess.base;

import java.lang.Comparable;
import java.io.Serializable;

/**
 * This is an object that contains data related to the aircraft_models table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="aircraft_models"
 */

public abstract class BaseAircraftModels implements Comparable, Serializable
{

  public static String REF = "AircraftModels";
  public static String PROP_WEIGHT = "Weight";
  public static String PROP_MODEL = "Model";
  public static String PROP_SPEED = "Speed";
  public static String PROP_AIRCRAFT_ENGINE_TYPE_ID = "AircraftEngineTypeId";
  public static String PROP_SEATS = "Seats";
  public static String PROP_AIRCRAFT_TYPE_ID = "AircraftTypeId";
  public static String PROP_AIRCRAFT_CATEGORY_ID = "AircraftCategoryId";
  public static String PROP_ENGINES = "Engines";
  public static String PROP_MANUFACTURER = "Manufacturer";
  public static String PROP_ID = "Id";
  public static String PROP_AMATEUR = "Amateur";

  // constructors
  public BaseAircraftModels()
  {
    initialize();
  }

  /**
   * Constructor for primary key
   */
  public BaseAircraftModels(java.lang.String id)
  {
    this.setId(id);
    initialize();
  }

  /**
   * Constructor for required fields
   */
  public BaseAircraftModels(java.lang.String id, java.lang.String manufacturer,
      java.lang.String model, java.lang.String aircraftTypeId,
      java.lang.String aircraftEngineTypeId,
      java.lang.String aircraftCategoryId, java.lang.String amateur,
      java.lang.Byte engines, java.lang.Short seats, java.lang.Integer weight,
      java.lang.Short speed)
  {

    this.setId(id);
    this.setManufacturer(manufacturer);
    this.setModel(model);
    this.setAircraftTypeId(aircraftTypeId);
    this.setAircraftEngineTypeId(aircraftEngineTypeId);
    this.setAircraftCategoryId(aircraftCategoryId);
    this.setAmateur(amateur);
    this.setEngines(engines);
    this.setSeats(seats);
    this.setWeight(weight);
    this.setSpeed(speed);
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
  private java.lang.String aircraftTypeId;
  private java.lang.String aircraftEngineTypeId;
  private java.lang.String aircraftCategoryId;
  private java.lang.String amateur;
  private java.lang.Byte engines;
  private java.lang.Short seats;
  private java.lang.Integer weight;
  private java.lang.Short speed;

  /**
   * Return the unique identifier of this class
   * 
   * @hibernate.id column="aircraft_model_code"
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
   * Return the value associated with the column: aircraft_category_id
   */
  public java.lang.String getAircraftCategoryId()
  {
    return aircraftCategoryId;
  }

  /**
   * Set the value related to the column: aircraft_category_id
   * 
   * @param aircraftCategoryId
   *          the aircraft_category_id value
   */
  public void setAircraftCategoryId(java.lang.String aircraftCategoryId)
  {
    this.aircraftCategoryId = aircraftCategoryId;
  }

  /**
   * Return the value associated with the column: amateur
   */
  public java.lang.String getAmateur()
  {
    return amateur;
  }

  /**
   * Set the value related to the column: amateur
   * 
   * @param amateur
   *          the amateur value
   */
  public void setAmateur(java.lang.String amateur)
  {
    this.amateur = amateur;
  }

  /**
   * Return the value associated with the column: engines
   */
  public java.lang.Byte getEngines()
  {
    return engines;
  }

  /**
   * Set the value related to the column: engines
   * 
   * @param engines
   *          the engines value
   */
  public void setEngines(java.lang.Byte engines)
  {
    this.engines = engines;
  }

  /**
   * Return the value associated with the column: seats
   */
  public java.lang.Short getSeats()
  {
    return seats;
  }

  /**
   * Set the value related to the column: seats
   * 
   * @param seats
   *          the seats value
   */
  public void setSeats(java.lang.Short seats)
  {
    this.seats = seats;
  }

  /**
   * Return the value associated with the column: weight
   */
  public java.lang.Integer getWeight()
  {
    return weight;
  }

  /**
   * Set the value related to the column: weight
   * 
   * @param weight
   *          the weight value
   */
  public void setWeight(java.lang.Integer weight)
  {
    this.weight = weight;
  }

  /**
   * Return the value associated with the column: speed
   */
  public java.lang.Short getSpeed()
  {
    return speed;
  }

  /**
   * Set the value related to the column: speed
   * 
   * @param speed
   *          the speed value
   */
  public void setSpeed(java.lang.Short speed)
  {
    this.speed = speed;
  }

  public boolean equals(Object obj)
  {
    if (null == obj)
      return false;
    if (!(obj instanceof net.ensode.jasperbook.dbaccess.AircraftModels))
      return false;
    else
    {
      net.ensode.jasperbook.dbaccess.AircraftModels aircraftModels = (net.ensode.jasperbook.dbaccess.AircraftModels) obj;
      if (null == this.getId() || null == aircraftModels.getId())
        return false;
      else
        return (this.getId().equals(aircraftModels.getId()));
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