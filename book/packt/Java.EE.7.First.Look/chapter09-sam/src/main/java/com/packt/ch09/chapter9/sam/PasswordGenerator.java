/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch09.chapter9.sam;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Administrator
 */
public class PasswordGenerator {

    public static void main(String... args){
        new PasswordGenerator().password("admin");
    }
    
    public void password(String clear_pwd) {
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            clear_pwd = (clear_pwd == null) ? "" : clear_pwd;
            
            md.update(clear_pwd.getBytes("UTF-8")); 

            byte[] digest = md.digest();

            BigInteger bigInt = new BigInteger(1, digest);

            String output = bigInt.toString(16);
            System.out.println(output);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
