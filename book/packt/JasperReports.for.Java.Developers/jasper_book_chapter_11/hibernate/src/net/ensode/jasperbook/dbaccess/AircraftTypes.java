package net.ensode.jasperbook.dbaccess;

import net.ensode.jasperbook.dbaccess.base.BaseAircraftTypes;

public class AircraftTypes extends BaseAircraftTypes
{
  private static final long serialVersionUID = 1L;

  /* [CONSTRUCTOR MARKER BEGIN] */
  public AircraftTypes()
  {
    super();
  }

  /**
   * Constructor for primary key
   */
  public AircraftTypes(java.lang.String id)
  {
    super(id);
  }

  /**
   * Constructor for required fields
   */
  public AircraftTypes(java.lang.String id, java.lang.String description)
  {

    super(id, description);
  }

  /* [CONSTRUCTOR MARKER END] */

}