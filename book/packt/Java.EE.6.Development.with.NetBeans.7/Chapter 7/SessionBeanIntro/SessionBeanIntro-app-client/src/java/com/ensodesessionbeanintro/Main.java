/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensodesessionbeanintro;

import com.ensode.sessionbeanintro.ejb.EchoRemote;
import javax.ejb.EJB;
import javax.swing.JOptionPane;

/**
 *
 * @author heffel
 */
public class Main {

    @EJB
    private static EchoRemote echo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JOptionPane.showMessageDialog(null,
                echo.echo("If you don't see this, it didn't work"));

    }
}
