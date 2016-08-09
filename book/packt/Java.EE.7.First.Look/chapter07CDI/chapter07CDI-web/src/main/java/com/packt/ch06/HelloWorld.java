/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06;

import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Administrator
 */
@RequestScoped
public class HelloWorld implements IHelloWorld{

    @Override
    public String getHelloWorld() {
        return "Hello World";
    }    
}
