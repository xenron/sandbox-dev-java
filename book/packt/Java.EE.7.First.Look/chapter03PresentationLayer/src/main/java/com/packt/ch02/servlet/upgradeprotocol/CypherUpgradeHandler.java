/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.servlet.upgradeprotocol;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.WebConnection;

/**
 *
 * @author Administrator
 */
public class CypherUpgradeHandler implements HttpUpgradeHandler{

    @Override
    public void init(WebConnection wc) {
        ServletInputStream input = null;
        ServletOutputStream output = null;
        try {
            System.out.println("A client just logged in");
            input = wc.getInputStream();
            // use input stream
            output = wc.getOutputStream();
            //use output stream
        } catch (IOException ex) {
            ex.printStackTrace();
        }        
    }

    @Override
    public void destroy() {
         System.out.println("A client just logged out");
    }
    
}
