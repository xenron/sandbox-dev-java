package net.ensode.jasperbook.dbaccess;

import net.ensode.jasperbook.dbaccess.base.BaseAircraftEngineTypes;

public class AircraftEngineTypes extends BaseAircraftEngineTypes
{
  private static final long serialVersionUID = 1L;

  /* [CONSTRUCTOR MARKER BEGIN] */
  public AircraftEngineTypes()
  {
    super();
  }

  /**
   * Constructor for primary key
   */
  public AircraftEngineTypes(java.lang.String id)
  {
    super(id);
  }

  /**
   * Constructor for required fields
   */
  public AircraftEngineTypes(java.lang.String id, java.lang.String description)
  {

    super(id, description);
  }

  /* [CONSTRUCTOR MARKER END] */

}