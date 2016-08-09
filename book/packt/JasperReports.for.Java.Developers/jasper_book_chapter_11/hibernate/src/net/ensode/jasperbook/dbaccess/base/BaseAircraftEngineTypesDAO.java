package net.ensode.jasperbook.dbaccess.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import net.ensode.jasperbook.dbaccess.dao.AircraftEngineTypesDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseAircraftEngineTypesDAO extends
    net.ensode.jasperbook.dbaccess.dao._RootDAO
{

  // query name references

  public static AircraftEngineTypesDAO instance;

  /**
   * Return a singleton of the DAO
   */
  public static AircraftEngineTypesDAO getInstance()
  {
    if (null == instance)
      instance = new AircraftEngineTypesDAO();
    return instance;
  }

  public Class getReferenceClass()
  {
    return net.ensode.jasperbook.dbaccess.AircraftEngineTypes.class;
  }

  public Order getDefaultOrder()
  {
    return null;
  }

  /**
   * Cast the object as a net.ensode.jasperbook.dbaccess.AircraftEngineTypes
   */
  public net.ensode.jasperbook.dbaccess.AircraftEngineTypes cast(Object object)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftEngineTypes) object;
  }

  public net.ensode.jasperbook.dbaccess.AircraftEngineTypes get(
      java.lang.String key)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftEngineTypes) get(
        getReferenceClass(), key);
  }

  public net.ensode.jasperbook.dbaccess.AircraftEngineTypes get(
      java.lang.String key, Session s)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftEngineTypes) get(
        getReferenceClass(), key, s);
  }

  public net.ensode.jasperbook.dbaccess.AircraftEngineTypes load(
      java.lang.String key)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftEngineTypes) load(
        getReferenceClass(), key);
  }

  public net.ensode.jasperbook.dbaccess.AircraftEngineTypes load(
      java.lang.String key, Session s)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftEngineTypes) load(
        getReferenceClass(), key, s);
  }

  public net.ensode.jasperbook.dbaccess.AircraftEngineTypes loadInitialize(
      java.lang.String key, Session s)
  {
    net.ensode.jasperbook.dbaccess.AircraftEngineTypes obj = load(key, s);
    if (!Hibernate.isInitialized(obj))
    {
      Hibernate.initialize(obj);
    }
    return obj;
  }

  /* Generic methods */

  /**
   * Return all objects related to the implementation of this DAO with no
   * filter.
   */
  public java.util.List<net.ensode.jasperbook.dbaccess.AircraftEngineTypes> findAll()
  {
    return super.findAll();
  }

  /**
   * Return all objects related to the implementation of this DAO with no
   * filter.
   */
  public java.util.List<net.ensode.jasperbook.dbaccess.AircraftEngineTypes> findAll(
      Order defaultOrder)
  {
    return super.findAll(defaultOrder);
  }

  /**
   * Return all objects related to the implementation of this DAO with no
   * filter. Use the session given.
   * 
   * @param s
   *          the Session
   */
  public java.util.List<net.ensode.jasperbook.dbaccess.AircraftEngineTypes> findAll(
      Session s, Order defaultOrder)
  {
    return super.findAll(s, defaultOrder);
  }

  /**
   * Persist the given transient instance, first assigning a generated
   * identifier. (Or using the current value of the identifier property if the
   * assigned generator is used.)
   * 
   * @param aircraftEngineTypes
   *          a transient instance of a persistent class
   * @return the class identifier
   */
  public java.lang.String save(
      net.ensode.jasperbook.dbaccess.AircraftEngineTypes aircraftEngineTypes)
  {
    return (java.lang.String) super.save(aircraftEngineTypes);
  }

  /**
   * Persist the given transient instance, first assigning a generated
   * identifier. (Or using the current value of the identifier property if the
   * assigned generator is used.) Use the Session given.
   * 
   * @param aircraftEngineTypes
   *          a transient instance of a persistent class
   * @param s
   *          the Session
   * @return the class identifier
   */
  public java.lang.String save(
      net.ensode.jasperbook.dbaccess.AircraftEngineTypes aircraftEngineTypes,
      Session s)
  {
    return (java.lang.String) save((Object) aircraftEngineTypes, s);
  }

  /**
   * Either save() or update() the given instance, depending upon the value of
   * its identifier property. By default the instance is always saved. This
   * behaviour may be adjusted by specifying an unsaved-value attribute of the
   * identifier property mapping.
   * 
   * @param aircraftEngineTypes
   *          a transient instance containing new or updated state
   */
  public void saveOrUpdate(
      net.ensode.jasperbook.dbaccess.AircraftEngineTypes aircraftEngineTypes)
  {
    saveOrUpdate((Object) aircraftEngineTypes);
  }

  /**
   * Either save() or update() the given instance, depending upon the value of
   * its identifier property. By default the instance is always saved. This
   * behaviour may be adjusted by specifying an unsaved-value attribute of the
   * identifier property mapping. Use the Session given.
   * 
   * @param aircraftEngineTypes
   *          a transient instance containing new or updated state.
   * @param s
   *          the Session.
   */
  public void saveOrUpdate(
      net.ensode.jasperbook.dbaccess.AircraftEngineTypes aircraftEngineTypes,
      Session s)
  {
    saveOrUpdate((Object) aircraftEngineTypes, s);
  }

  /**
   * Update the persistent state associated with the given identifier. An
   * exception is thrown if there is a persistent instance with the same
   * identifier in the current session.
   * 
   * @param aircraftEngineTypes
   *          a transient instance containing updated state
   */
  public void update(
      net.ensode.jasperbook.dbaccess.AircraftEngineTypes aircraftEngineTypes)
  {
    update((Object) aircraftEngineTypes);
  }

  /**
   * Update the persistent state associated with the given identifier. An
   * exception is thrown if there is a persistent instance with the same
   * identifier in the current session. Use the Session given.
   * 
   * @param aircraftEngineTypes
   *          a transient instance containing updated state
   * @param the
   *          Session
   */
  public void update(
      net.ensode.jasperbook.dbaccess.AircraftEngineTypes aircraftEngineTypes,
      Session s)
  {
    update((Object) aircraftEngineTypes, s);
  }

  /**
   * Remove a persistent instance from the datastore. The argument may be an
   * instance associated with the receiving Session or a transient instance with
   * an identifier associated with existing persistent state.
   * 
   * @param id
   *          the instance ID to be removed
   */
  public void delete(java.lang.String id)
  {
    delete((Object) load(id));
  }

  /**
   * Remove a persistent instance from the datastore. The argument may be an
   * instance associated with the receiving Session or a transient instance with
   * an identifier associated with existing persistent state. Use the Session
   * given.
   * 
   * @param id
   *          the instance ID to be removed
   * @param s
   *          the Session
   */
  public void delete(java.lang.String id, Session s)
  {
    delete((Object) load(id, s), s);
  }

  /**
   * Remove a persistent instance from the datastore. The argument may be an
   * instance associated with the receiving Session or a transient instance with
   * an identifier associated with existing persistent state.
   * 
   * @param aircraftEngineTypes
   *          the instance to be removed
   */
  public void delete(
      net.ensode.jasperbook.dbaccess.AircraftEngineTypes aircraftEngineTypes)
  {
    delete((Object) aircraftEngineTypes);
  }

  /**
   * Remove a persistent instance from the datastore. The argument may be an
   * instance associated with the receiving Session or a transient instance with
   * an identifier associated with existing persistent state. Use the Session
   * given.
   * 
   * @param aircraftEngineTypes
   *          the instance to be removed
   * @param s
   *          the Session
   */
  public void delete(
      net.ensode.jasperbook.dbaccess.AircraftEngineTypes aircraftEngineTypes,
      Session s)
  {
    delete((Object) aircraftEngineTypes, s);
  }

  /**
   * Re-read the state of the given instance from the underlying database. It is
   * inadvisable to use this to implement long-running sessions that span many
   * business tasks. This method is, however, useful in certain special
   * circumstances. For example
   * <ul>
   * <li>where a database trigger alters the object state upon insert or update</li>
   * <li>after executing direct SQL (eg. a mass update) in the same session</li>
   * <li>after inserting a Blob or Clob</li>
   * </ul>
   */
  public void refresh(
      net.ensode.jasperbook.dbaccess.AircraftEngineTypes aircraftEngineTypes,
      Session s)
  {
    refresh((Object) aircraftEngineTypes, s);
  }

}