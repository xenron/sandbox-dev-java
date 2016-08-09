/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06;

import javax.faces.bean.ManagedBean;
import javax.jms.Queue;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
@ManagedBean
public class MyJsfManagedBean {
    @javax.annotation.Resource
    Queue jmsQueue;
    //...
}
