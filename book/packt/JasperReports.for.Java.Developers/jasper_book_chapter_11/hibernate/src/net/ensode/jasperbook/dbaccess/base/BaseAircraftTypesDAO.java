package net.ensode.jasperbook.dbaccess.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import net.ensode.jasperbook.dbaccess.dao.AircraftTypesDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseAircraftTypesDAO extends
    net.ensode.jasperbook.dbaccess.dao._RootDAO
{

  // query name references

  public static AircraftTypesDAO instance;

  /**
   * Return a singleton of the DAO
   */
  public static AircraftTypesDAO getInstance()
  {
    if (null == instance)
      instance = new AircraftTypesDAO();
    return instance;
  }

  public Class getReferenceClass()
  {
    return net.ensode.jasperbook.dbaccess.AircraftTypes.class;
  }

  public Order getDefaultOrder()
  {
    return null;
  }

  /**
   * Cast the object as a net.ensode.jasperbook.dbaccess.AircraftTypes
   */
  public net.ensode.jasperbook.dbaccess.AircraftTypes cast(Object object)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftTypes) object;
  }

  public net.ensode.jasperbook.dbaccess.AircraftTypes get(java.lang.String key)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftTypes) get(
        getReferenceClass(), key);
  }

  public net.ensode.jasperbook.dbaccess.AircraftTypes get(java.lang.String key,
      Session s)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftTypes) get(
        getReferenceClass(), key, s);
  }

  public net.ensode.jasperbook.dbaccess.AircraftTypes load(java.lang.String key)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftTypes) load(
        getReferenceClass(), key);
  }

  public net.ensode.jasperbook.dbaccess.AircraftTypes load(
      java.lang.String key, Session s)
  {
    return (net.ensode.jasperbook.dbaccess.AircraftTypes) load(
        getReferenceClass(), key, s);
  }

  public net.ensode.jasperbook.dbaccess.AircraftTypes loadInitialize(
      java.lang.String key, Session s)
  {
    net.ensode.jasperbook.dbaccess.AircraftTypes obj = load(key, s);
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
  public java.util.List<net.ensode.jasperbook.dbaccess.AircraftTypes> findAll()
  {
    return super.findAll();
  }

  /**
   * Return all objects related to the implementation of this DAO with no
   * filter.
   */
  public java.util.List<net.ensode.jasperbook.dbaccess.AircraftTypes> findAll(
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
  public java.util.List<net.ensode.jasperbook.dbaccess.AircraftTypes> findAll(
      Session s, Order defaultOrder)
  {
    return super.findAll(s, defaultOrder);
  }

  /**
   * Persist the given transient instance, first assigning a generated
   * identifier. (Or using the current value of the identifier property if the
   * assigned generator is used.)
   * 
   * @param aircraftTypes
   *          a transient instance of a persistent class
   * @return the class identifier
   */
  public java.lang.String save(
      net.ensode.jasperbook.dbaccess.AircraftTypes aircraftTypes)
  {
    return (java.lang.String) super.save(aircraftTypes);
  }

  /**
   * Persist the given transient instance, first assigning a generated
   * identifier. (Or using the current value of the identifier property if the
   * assigned generator is used.) Use the Session given.
   * 
   * @param aircraftTypes
   *          a transient instance of a persistent class
   * @param s
   *          the Session
   * @return the class identifier
   */
  public java.lang.String save(
      net.ensode.jasperbook.dbaccess.AircraftTypes aircraftTypes, Session s)
  {
    return (java.lang.String) save((Object) aircraftTypes, s);
  }

  /**
   * Either save() or update() the given instance, depending upon the value of
   * its identifier property. By default the instance is always saved. This
   * behaviour may be adjusted by specifying an unsaved-value attribute of the
   * identifier property mapping.
   * 
   * @param aircraftTypes
   *          a transient instance containing new or updated state
   */
  public void saveOrUpdate(
      net.ensode.jasperbook.dbaccess.AircraftTypes aircraftTypes)
  {
    saveOrUpdate((Object) aircraftTypes);
  }

  /**
   * Either save() or update() the given instance, depending upon the value of
   * its identifier property. By default the instance is always saved. This
   * behaviour may be adjusted by specifying an unsaved-value attribute of the
   * identifier property mapping. Use the Session given.
   * 
   * @param aircraftTypes
   *          a transient instance containing new or updated state.
   * @param s
   *          the Session.
   */
  public void saveOrUpdate(
      net.ensode.jasperbook.dbaccess.AircraftTypes aircraftTypes, Session s)
  {
    saveOrUpdate((Object) aircraftTypes, s);
  }

  /**
   * Update the persistent state associated with the given identifier. An
   * exception is thrown if there is a persistent instance with the same
   * identifier in the current session.
   * 
   * @param aircraftTypes
   *          a transient instance containing updated state
   */
  public void update(net.ensode.jasperbook.dbaccess.AircraftTypes aircraftTypes)
  {
    update((Object) aircraftTypes);
  }

  /**
   * Update the persistent state associated with the given identifier. An
   * exception is thrown if there is a persistent instance with the same
   * identifier in the current session. Use the Session given.
   * 
   * @param aircraftTypes
   *          a transient instance containing updated state
   * @param the
   *          Session
   */
  public void update(
      net.ensode.jasperbook.dbaccess.AircraftTypes aircraftTypes, Session s)
  {
    update((Object) aircraftTypes, s);
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
   * @param aircraftTypes
   *          the instance to be removed
   */
  public void delete(net.ensode.jasperbook.dbaccess.AircraftTypes aircraftTypes)
  {
    delete((Object) aircraftTypes);
  }

  /**
   * Remove a persistent instance from the datastore. The argument may be an
   * instance associated with the receiving Session or a transient instance with
   * an identifier associated with existing persistent state. Use the Session
   * given.
   * 
   * @param aircraftTypes
   *          the instance to be removed
   * @param s
   *          the Session
   */
  public void delete(
      net.ensode.jasperbook.dbaccess.AircraftTypes aircraftTypes, Session s)
  {
    delete((Object) aircraftTypes, s);
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
      net.ensode.jasperbook.dbaccess.AircraftTypes aircraftTypes, Session s)
  {
    refresh((Object) aircraftTypes, s);
  }

}