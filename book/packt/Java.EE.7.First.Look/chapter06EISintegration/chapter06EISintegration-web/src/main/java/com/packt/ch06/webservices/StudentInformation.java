/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06.webservices;

import com.packt.ch06.entities.Student;
import com.packt.ch06.interceptors.ZipResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrator
 */
@Path("students")
@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class StudentInformation {

    @PersistenceContext(unitName = "integrationPU")
    private EntityManager em;
    
    @Resource(lookup = "java:comp/DefaultManagedScheduledExecutorService")
    ManagedExecutorService taskExecutor;


    @GET
    @Path("getListOfAllStudents")
    public List<Student> getListOfAllStudents() {        
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }
    
    @GET
    @ZipResult
    @Path("getListOfAllStudentsGzip")
    public List<Student> getListOfAllStudentsGzip() {        
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);       
        return query.getResultList();
    }

    @GET
    @Path("getListOfAllStudentsAs")
    public List<Student> getListOfAllStudentsAs() {
        try {
            Thread.sleep(20 * 1000);//20 seconds
        } catch (Exception ex) {
        }
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    @GET
    @Path("getListOfAllStudentsAs2")
    public void getListOfAllStudentsAs2(final @Suspended AsyncResponse response) {
        System.out.println("before time : "+new Date());
        taskExecutor.submit(
                new Runnable() {
            public void run() {

                String queryString = "SELECT s FROM Student s WHERE 1 = 1";
                TypedQuery<Student> query = em.createQuery(queryString, Student.class);

                List<Student> studentList = query.getResultList();
                try {
                    Thread.sleep(10 * 1000);//1 second
                } catch (Exception ex) {
                }
                response.resume(studentList);
            }
        });
        System.out.println("After time : "+new Date());
    }
}
