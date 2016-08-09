/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch04;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrator
 */
public class DDLGeneration {
    
    public static void main(String... args){
        createWithCreationOfEntityManagerFactory2();
    }
    
    public static void createBeforeEntityManagerFactory(){
        Map props = new HashMap();
        props.put("javax.persistence.schema-generation.database.action", "create");
        props.put("javax.persistence.schema-generation.create-source", "metadata");
        Persistence.generateSchema("chapter04PU", props);
    }
    
    public static void createWithCreationOfEntityManagerFactory(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
    }
    
    public static void createWithCreationOfEntityManagerFactory2(){
        Map props = new HashMap();
        props.put("javax.persistence.schema-generation.database.action", "create");
        props.put("javax.persistence.schema-generation.create-source", "metadata");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU", props);
    }
}
