/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch08.beans;

import com.packt.ch08.bean.AroundConstructBean;
import com.packt.ch08.bean.Log;
import com.packt.ch08.bean.StudentSessionBean;
import com.packt.ch08.bean.StudentSessionBeanWithoutInterceptor;
import com.packt.ch08.entities.Student;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Administrator
 */
@ManagedBean
public class StudentManagedBean {
    private Student student = new Student();
    private Student student1 = new Student();
    
    @EJB
    private StudentSessionBean studentEjb;
    @EJB
    private StudentSessionBeanWithoutInterceptor studentEJBWI;
    @EJB
    private AroundConstructBean aroundBean;
    
    public void createStudentListener(ActionEvent evt){
        student1 = studentEjb.createEntity(student);
    }
    
    public void createStudentListener2(ActionEvent evt){
        student1 = studentEJBWI.createEntity(student);
    }
    
    public Date getDateTime(){
        return aroundBean.getDateTime();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }        

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }

    public StudentSessionBean getStudentEjb() {
        return studentEjb;
    }

    public void setStudentEjb(StudentSessionBean studentEjb) {
        this.studentEjb = studentEjb;
    }
    
    
}
