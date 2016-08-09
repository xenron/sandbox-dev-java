package net.ensode.jasperbook.dbaccess;

import net.ensode.jasperbook.dbaccess.base.BaseAircraftEngines;

public class AircraftEngines extends BaseAircraftEngines
{
  private static final long serialVersionUID = 1L;

  /* [CONSTRUCTOR MARKER BEGIN] */
  public AircraftEngines()
  {
    super();
  }

  /**
   * Constructor for primary key
   */
  public AircraftEngines(java.lang.String id)
  {
    super(id);
  }

  /**
   * Constructor for required fields
   */
  public AircraftEngines(java.lang.String id, java.lang.String manufacturer,
      java.lang.String model, java.lang.String aircraftEngineTypeId,
      java.lang.String horsepower, java.lang.String thrust,
      java.math.BigDecimal fuelConsumed)
  {

    super(id, manufacturer, model, aircraftEngineTypeId, horsepower, thrust,
        fuelConsumed);
  }

  /* [CONSTRUCTOR MARKER END] */

}