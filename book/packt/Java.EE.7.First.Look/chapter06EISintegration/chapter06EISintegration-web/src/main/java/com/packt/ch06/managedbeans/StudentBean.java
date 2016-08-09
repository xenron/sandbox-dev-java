/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06.managedbeans;

import com.packt.ch06.entities.Student;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Administrator
 */
@ManagedBean
public class StudentBean {
    private Student student = new Student();

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
