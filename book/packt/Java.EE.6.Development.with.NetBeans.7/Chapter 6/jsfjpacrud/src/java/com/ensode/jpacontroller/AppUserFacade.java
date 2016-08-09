/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensode.jpacontroller;

import com.ensode.jpa.AppUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author heffel
 */
@Stateless
public class AppUserFacade extends AbstractFacade<AppUser> {
    @PersistenceContext(unitName = "jsfjpacrudPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AppUserFacade() {
        super(AppUser.class);
    }

}
