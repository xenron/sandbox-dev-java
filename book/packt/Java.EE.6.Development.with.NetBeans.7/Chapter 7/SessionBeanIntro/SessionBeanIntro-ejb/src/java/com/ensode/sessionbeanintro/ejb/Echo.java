/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.sessionbeanintro.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author heffel
 */
@Stateless
public class Echo implements EchoRemote {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String echo(String saying) {
        return "echoing: " + saying;
    }
}
