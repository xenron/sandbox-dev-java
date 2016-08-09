/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensode.ejbdao.sessionbeans;

import com.ensode.ejbdao.entities.AppUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author heffel
 */
@Stateless
public class AppUserFacade extends AbstractFacade<AppUser> {
    @PersistenceContext(unitName = "EjbDaoPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AppUserFacade() {
        super(AppUser.class);
    }

}
