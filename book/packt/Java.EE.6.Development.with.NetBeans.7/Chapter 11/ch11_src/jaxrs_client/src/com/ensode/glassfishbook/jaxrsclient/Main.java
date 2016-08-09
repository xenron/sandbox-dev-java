package com.ensode.glassfishbook.jaxrsclient;


import com.ensode.glassfishbook.jaxrsclient.NewJerseyClient;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heffel
 */
public class Main {
    public static void main(String[] args) {
        NewJerseyClient newJerseyClient = new NewJerseyClient();
        String response = newJerseyClient.find_XML(String.class, "1");
        
        System.out.println("response is: " + response);
        
        newJerseyClient.close();
    }

}
