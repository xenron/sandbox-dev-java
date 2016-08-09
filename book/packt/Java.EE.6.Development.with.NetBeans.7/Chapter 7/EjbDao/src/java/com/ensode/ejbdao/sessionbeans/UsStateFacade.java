/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensode.ejbdao.sessionbeans;

import com.ensode.ejbdao.entities.UsState;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author heffel
 */
@Stateless
public class UsStateFacade extends AbstractFacade<UsState> {
    @PersistenceContext(unitName = "EjbDaoPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UsStateFacade() {
        super(UsState.class);
    }

}
