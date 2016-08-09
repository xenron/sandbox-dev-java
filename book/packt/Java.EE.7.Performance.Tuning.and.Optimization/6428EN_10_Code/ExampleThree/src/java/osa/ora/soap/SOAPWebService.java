/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428).
 */

package osa.ora.soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import osa.ora.beans.Empolyee;

/**
 *
 * @author Osama Oransa
 */
@WebService(serviceName = "SOAPWebService")
@Stateless()
public class SOAPWebService{
    @PersistenceContext(unitName = "ExampleThreePU")
    private EntityManager em;
    /**
     * getEmployeeData to retrieve employees data
     * @param id
     * @return Employee details
     */
    @WebMethod(operationName = "getEmplyeeData")
    public Empolyee getEmployeeData(@WebParam(name = "id") int id) {
        System.out.println("id="+id);
        return em.find(Empolyee.class,id);
    }
}
