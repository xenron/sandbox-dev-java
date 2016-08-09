/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.batchprocessing.chunk;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
public class Student {
    private String id;
    private String name;
    private String level;
    private int age;
    private boolean approved;
    private String address;

    public Student(){}
    
    public Student(String id, String name, String level, int age, String address){
        this.id = id;
        this.name = name;
        this.level = level;
        this.age = age;
        this.address = address;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }        

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    

}
