package net.ensode.jasperbook.dbaccess.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import net.ensode.jasperbook.dbaccess.dao.AircraftEnginesDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseAircraftEnginesDAO extends
    net.ensode.jasperbook.dbaccess.dao._RootDAO
{

  // query name references

  public static AircraftEnginesDAO instance;

  /**
   * Return a singleton of the DAO
   */
  public static AircraftEnginesDAO getInstance()
  {
    if (null == instance)
      instance = new AircraftEnginesDAO();
    return instance;
  }

  public Class getReferenceClass()
  {
    return net.ensode.jasperbook.dbaccess.AircraftEngines.class;
  }

  public Order getDefaultOrder()
  {
    return null;
  }

  /**
   * Cast the object as a net.ensode.jasperbook.dbaccess.AircraftEngines
   */
  public net.ensode.jasperbook.dbaccess.AircraftEngines cast(Object object)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftEngines) object;
  }

  public net.ensode.jasperbook.dbaccess.AircraftEngines get(java.lang.String key)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftEngines) get(
        getReferenceClass(), key);
  }

  public net.ensode.jasperbook.dbaccess.AircraftEngines get(
      java.lang.String key, Session s)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftEngines) get(
        getReferenceClass(), key, s);
  }

  public net.ensode.jasperbook.dbaccess.AircraftEngines load(
      java.lang.String key)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftEngines) load(
        getReferenceClass(), key);
  }

  public net.ensode.jasperbook.dbaccess.AircraftEngines load(
      java.lang.String key, Session s)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftEngines) load(
        getReferenceClass(), key, s);
  }

  public net.ensode.jasperbook.dbaccess.AircraftEngines loadInitialize(
      java.lang.String key, Session s)
  {
    net.ensode.jasperbook.dbaccess.AircraftEngines obj = load(key, s);
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
  public java.util.List<net.ensode.jasperbook.dbaccess.AircraftEngines> findAll()
  {
    return super.findAll();
  }

  /**
   * Return all objects related to the implementation of this DAO with no
   * filter.
   */
  public java.util.List<net.ensode.jasperbook.dbaccess.AircraftEngines> findAll(
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
  public java.util.List<net.ensode.jasperbook.dbaccess.AircraftEngines> findAll(
      Session s, Order defaultOrder)
  {
    return super.findAll(s, defaultOrder);
  }

  /**
   * Persist the given transient instance, first assigning a generated
   * identifier. (Or using the current value of the identifier property if the
   * assigned generator is used.)
   * 
   * @param aircraftEngines
   *          a transient instance of a persistent class
   * @return the class identifier
   */
  public java.lang.String save(
      net.ensode.jasperbook.dbaccess.AircraftEngines aircraftEngines)
  {
    return (java.lang.String) super.save(aircraftEngines);
  }

  /**
   * Persist the given transient instance, first assigning a generated
   * identifier. (Or using the current value of the identifier property if the
   * assigned generator is used.) Use the Session given.
   * 
   * @param aircraftEngines
   *          a transient instance of a persistent class
   * @param s
   *          the Session
   * @return the class identifier
   */
  public java.lang.String save(
      net.ensode.jasperbook.dbaccess.AircraftEngines aircraftEngines, Session s)
  {
    return (java.lang.String) save((Object) aircraftEngines, s);
  }

  /**
   * Either save() or update() the given instance, depending upon the value of
   * its identifier property. By default the instance is always saved. This
   * behaviour may be adjusted by specifying an unsaved-value attribute of the
   * identifier property mapping.
   * 
   * @param aircraftEngines
   *          a transient instance containing new or updated state
   */
  public void saveOrUpdate(
      net.ensode.jasperbook.dbaccess.AircraftEngines aircraftEngines)
  {
    saveOrUpdate((Object) aircraftEngines);
  }

  /**
   * Either save() or update() the given instance, depending upon the value of
   * its identifier property. By default the instance is always saved. This
   * behaviour may be adjusted by specifying an unsaved-value attribute of the
   * identifier property mapping. Use the Session given.
   * 
   * @param aircraftEngines
   *          a transient instance containing new or updated state.
   * @param s
   *          the Session.
   */
  public void saveOrUpdate(
      net.ensode.jasperbook.dbaccess.AircraftEngines aircraftEngines, Session s)
  {
    saveOrUpdate((Object) aircraftEngines, s);
  }

  /**
   * Update the persistent state associated with the given identifier. An
   * exception is thrown if there is a persistent instance with the same
   * identifier in the current session.
   * 
   * @param aircraftEngines
   *          a transient instance containing updated state
   */
  public void update(
      net.ensode.jasperbook.dbaccess.AircraftEngines aircraftEngines)
  {
    update((Object) aircraftEngines);
  }

  /**
   * Update the persistent state associated with the given identifier. An
   * exception is thrown if there is a persistent instance with the same
   * identifier in the current session. Use the Session given.
   * 
   * @param aircraftEngines
   *          a transient instance containing updated state
   * @param the
   *          Session
   */
  public void update(
      net.ensode.jasperbook.dbaccess.AircraftEngines aircraftEngines, Session s)
  {
    update((Object) aircraftEngines, s);
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
   * @param aircraftEngines
   *          the instance to be removed
   */
  public void delete(
      net.ensode.jasperbook.dbaccess.AircraftEngines aircraftEngines)
  {
    delete((Object) aircraftEngines);
  }

  /**
   * Remove a persistent instance from the datastore. The argument may be an
   * instance associated with the receiving Session or a transient instance with
   * an identifier associated with existing persistent state. Use the Session
   * given.
   * 
   * @param aircraftEngines
   *          the instance to be removed
   * @param s
   *          the Session
   */
  public void delete(
      net.ensode.jasperbook.dbaccess.AircraftEngines aircraftEngines, Session s)
  {
    delete((Object) aircraftEngines, s);
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
      net.ensode.jasperbook.dbaccess.AircraftEngines aircraftEngines, Session s)
  {
    refresh((Object) aircraftEngines, s);
  }

}