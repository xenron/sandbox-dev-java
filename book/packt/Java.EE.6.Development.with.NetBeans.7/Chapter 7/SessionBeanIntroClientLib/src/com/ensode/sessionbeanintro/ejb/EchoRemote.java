/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensode.sessionbeanintro.ejb;

import javax.ejb.Remote;

/**
 *
 * @author heffel
 */
@Remote
public interface EchoRemote {

    String echo(String saying);
    
}
