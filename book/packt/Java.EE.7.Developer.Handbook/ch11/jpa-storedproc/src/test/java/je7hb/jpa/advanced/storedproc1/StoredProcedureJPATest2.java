/*******************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013,2014 by Peter Pilgrim, Addiscombe, Surrey, XeNoNiQUe UK
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU GPL v3.0
 * which accompanies this distribution, and is available at:
 * http://www.gnu.org/licenses/gpl-3.0.txt
 *
 * Developers:
 * Peter Pilgrim -- design, development and implementation
 *               -- Blog: http://www.xenonique.co.uk/blog/
 *               -- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/

package je7hb.jpa.advanced.storedproc1;

import je7hb.jpa.Utils;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * A unit test CustomStoredProcedureJDBCTest to verify the operation of CustomStoredProcedureJDBCTest
 *
 * @author Peter Pilgrim
 */
@RunWith(Arquillian.class)
// @CreateSchema({"scripts/create-schema.sql"})
public class StoredProcedureJPATest2 {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
            .addClasses(Utils.class)
            .addAsResource(
                    new File("src/test/resources-glassfish-managed/scripts/create-schema.sql"),
                    "/scripts/create-schema.sql")
            .addAsResource(
                    "test-persistence.xml",
                    "META-INF/persistence.xml")
            .addAsManifestResource(
                    EmptyAsset.INSTANCE,
                    ArchivePaths.create("beans.xml"));
        System.out.printf(jar.toString(true));
        return jar;
    }

    @PersistenceContext
    EntityManager em;

    @Resource
    UserTransaction utx;

    @Resource(name="jdbc/arquillian")
    DataSource dataSource;

    boolean initialised = false;

    @Before
    public void createTablesAndCustomStoredProcedure() throws Exception {
        if ( !initialised) {
            InputStream is = this.getClass().getResourceAsStream("/scripts/create-schema.sql");
            utx.begin();
            Utils.executeScript(em, is, ";", true);
            utx.commit();
            initialised = true;
            em.clear();
        }
    }

    @Test
    public void shouldInvokeStoredProcedureWithOutbound() throws Exception {
        utx.begin();
        StoredProcedureQuery query =
            em.createStoredProcedureQuery("DOUBLE_SP")
            .registerStoredProcedureParameter(
                "P1", Float.class, ParameterMode.IN)
            .registerStoredProcedureParameter(
                "P2", Float.class, ParameterMode.OUT)
            .setParameter("P1", new Float(2.345));
        boolean status = query.execute();
        System.out.printf("****************** status=%s\n", status);
        assertFalse( query.hasMoreResults());
        Double p2 = ( Double)query.getOutputParameterValue("P2");
        System.out.printf("The output P2 was %12.7f\n", p2 );
        utx.commit();
    }
}
