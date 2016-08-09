package com.baselogic;

import com.baselogic.test.NullPrimaryKeyFilter;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;

/**
 * [Title]
 *
 * @author Mick Knutson (<a href="http://www.baselogic.com">http://www.baselogic.com</a>)
 * @since 2011
 */
public class TestUtils {

    //-----------------------------------------------------------------------//
    // DBUnit Helper Methods
    //-----------------------------------------------------------------------//

    /**
     * Seed data using DBUnit
     * @param em EntityManager
     * @param tx EntityTransaction
     * @param dataSetFile DBUnit dataSet file to import
     * @param nullPrimaryKeyFilters primary key's to use for DBUnit Import Filter
     * @throws Exception
     */
    public static void seedData(EntityManager em,
                                EntityTransaction tx,
                                String dataSetFile,
                                String... nullPrimaryKeyFilters)
            throws Exception {
        tx.begin();
        Connection connection = em.unwrap(java.sql.Connection.class);

        try {
            IDatabaseConnection dbUnitCon = new DatabaseConnection(connection);

            dbUnitCon.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
                    new H2DataTypeFactory());

            if (nullPrimaryKeyFilters != null && nullPrimaryKeyFilters.length > 0) {
                // Set the property by passing the new IColumnFilter
                dbUnitCon.getConfig().setProperty(
                        DatabaseConfig.PROPERTY_PRIMARY_KEY_FILTER,
                        new NullPrimaryKeyFilter(nullPrimaryKeyFilters));
            }

            IDataSet dataSet = getDataSet(dataSetFile);

            DatabaseOperation.CLEAN_INSERT.execute(dbUnitCon, dataSet);
        } finally {
            tx.commit();
            connection.close();
        }
    }

    protected static IDataSet getDataSet(String dataSetFile) throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream(dataSetFile));
    }

    /**
     * Dump data using DBUnit
     * @param em EntityManager
     * @param tx EntityTransaction
     * @param dataSetOutputFile DBUnit dataSet output file for export.
     * @param nullPrimaryKeyFilters primary key's to use for DBUnit Import Filter
     * @throws Exception
     */
    public static void dumpData(EntityManager em,
                                EntityTransaction tx,
                                String dataSetOutputFile,
                                String... nullPrimaryKeyFilters)
            throws Exception {
        tx.begin();
        Connection connection = em.unwrap(java.sql.Connection.class);

        try {
            IDatabaseConnection dbUnitCon = new DatabaseConnection(connection);
            dbUnitCon.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
                    new H2DataTypeFactory());

            if (nullPrimaryKeyFilters != null && nullPrimaryKeyFilters.length > 0) {
                // Set the property by passing the new IColumnFilter
                dbUnitCon.getConfig().setProperty(
                        DatabaseConfig.PROPERTY_PRIMARY_KEY_FILTER,
                        new NullPrimaryKeyFilter(nullPrimaryKeyFilters));
            }

            IDataSet dataSet = dbUnitCon.createDataSet();

            // If we use this method, the stream is closed in the finalizer.
            //FlatXmlDataSet.write(dataSet, new FileOutputStream(dataSetOutputFile));

            // Explicitly closes the Stream:
            FileOutputStream fos = new FileOutputStream(dataSetOutputFile);
            FlatXmlDataSet.write(dataSet, fos);
            fos.close();

            System.out.println("<dataset> written");
        } finally {
            tx.commit();
            connection.close();
        }
    }
}
