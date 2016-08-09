package net.ensode.jasperbook.dbaccess;

import net.ensode.jasperbook.dbaccess.base.BaseAircraftModels;

public class AircraftModels extends BaseAircraftModels
{
  private static final long serialVersionUID = 1L;

  /* [CONSTRUCTOR MARKER BEGIN] */
  public AircraftModels()
  {
    super();
  }

  /**
   * Constructor for primary key
   */
  public AircraftModels(java.lang.String id)
  {
    super(id);
  }

  /**
   * Constructor for required fields
   */
  public AircraftModels(java.lang.String id, java.lang.String manufacturer,
      java.lang.String model, java.lang.String aircraftTypeId,
      java.lang.String aircraftEngineTypeId,
      java.lang.String aircraftCategoryId, java.lang.String amateur,
      java.lang.Byte engines, java.lang.Short seats, java.lang.Integer weight,
      java.lang.Short speed)
  {

    super(id, manufacturer, model, aircraftTypeId, aircraftEngineTypeId,
        aircraftCategoryId, amateur, engines, seats, weight, speed);
  }

  /* [CONSTRUCTOR MARKER END] */

}