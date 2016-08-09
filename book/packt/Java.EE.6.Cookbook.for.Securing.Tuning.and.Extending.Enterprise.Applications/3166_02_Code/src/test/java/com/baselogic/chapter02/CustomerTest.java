package com.baselogic.chapter02;

import com.baselogic.TestUtils;
import com.baselogic.test.CustomerFixture;
import org.junit.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * see @PersistenceUnit
 */
public class CustomerTest {

    //-----------------------------------------------------------------------//
    // Attributes
    //-----------------------------------------------------------------------//
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tx;

    public static final String dataSetFile = "./src/test/resources/dataset.xml";
    public static final String dataSetOutputFile = "./target/test-dataset_dump.xml";
    public static final String[] nullPrimaryKeyFilters =
            {"ID", "ADDRESS_KEY", "P_NUMBER", "HOBBY_NAME"};

    //-----------------------------------------------------------------------//
    // Lifecycle Methods
    //-----------------------------------------------------------------------//
    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCEUNIT);
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void closeEntityManager() throws SQLException {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    @Before
    public void initTransaction() throws Exception {
        tx = em.getTransaction();
        TestUtils.seedData(em,
                tx,
                dataSetFile,
                nullPrimaryKeyFilters);
    }

    @After
    public void afterTests() throws Exception {
        TestUtils.dumpData(em,
                tx,
                dataSetOutputFile,
                nullPrimaryKeyFilters);
    }

    //-----------------------------------------------------------------------//
    // Unit Tests
    //-----------------------------------------------------------------------//

    @Test
    public void test__Create__and__Read_SingleCustomer() throws Exception {
        tx.begin();

        // Creates an instance of Customer
        Customer customer = CustomerFixture.createSingleCustomer();

        // Persists the Customer to the database
        em.persist(customer);
        assert tx != null;
        tx.commit();

        assertNotNull("ID should not be null", customer.getId());

        tx.begin();
        // Retrieves a single Customer from the database
        TypedQuery<Customer> q = em.createNamedQuery(
                Constants.FINDALLFINDERNAME, Customer.class);
        List<Customer> customers = q.getResultList();
        assertThat(customers.size(), is(4));
        tx.commit();
    }

    @Test
    public void test__DeleteCustomer() throws Exception {
        tx.begin();

        // Uses Sting Based Criteria
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> c = cb.createQuery(Customer.class);
        Root<Customer> cust = c.from(Customer.class);
        c.select(cust)
                .where(cb.equal(cust.get("username"), "user1"));
        Customer result = em.createQuery(c).getSingleResult();

        em.remove(result);

        // Retrieves all the Customers from the database
        TypedQuery<Customer> q = em.createNamedQuery(
                Constants.FINDALLFINDERNAME, Customer.class);
        List<Customer> customers = q.getResultList();

        tx.commit();

        assertThat(customers.size(), is(2));
    }

    @Test
    public void test__InsertCustomer__WithCollectionTables() throws Exception {
        // Creates an instance of Customer
        Customer customer = CustomerFixture.createSingleCustomer();

        // Persists the Customer to the database
        tx.begin();
        em.persist(customer);
        tx.commit();

        assertNotNull("ID should not be null", customer.getId());

        tx.begin();
        // Retrieves a single Customer from the database
        TypedQuery<Customer> q = em.createNamedQuery(
                Constants.FINDALLFINDERNAME, Customer.class);
        List<Customer> customers = q.getResultList();
        tx.commit();

        assertThat(customers.size(), is(4));

        Customer cust1 = customers.get(0);
        assertThat(cust1.getHobbies().size(), is(3));
        assertThat(cust1.getAddresses().size(), is(1));
        assertThat(cust1.getPhones().size(), is(1));
    }

    @Test
    public void test__UpdateCustomerWithCollectionTables() throws Exception {
        // Creates an instance of Customer
        Customer customer = CustomerFixture.createSingleCustomer();

        // Persists the Customer to the database
        tx.begin();
        em.persist(customer);
        tx.commit();

        assertNotNull("ID should not be null", customer.getId());

        tx.begin();
        // Retrieves a single Customer from the database
        TypedQuery<Customer> q = em.createNamedQuery(
                Constants.FINDALLFINDERNAME, Customer.class);
        List<Customer> customers = q.getResultList();

        tx.commit();

        assertThat(customers.size(), is(4));
    }

    @Test
    public void test__Read_and_Update__PESSIMISTIC_LOCK() throws Exception {
        // Persists the Customer to the database
        tx.begin();

        Customer customer = em.find(Customer.class, 100200L);

        // Lock is performed after read
        em.lock(customer, LockModeType.PESSIMISTIC_READ);

        // Update some fields
        customer.setUsername("newUsername1");

        em.merge(customer);

        tx.commit();

        assertThat(customer.getUsername(), is("newUsername1"));

    }

    //@Test
    public void test__LoadTest() throws Exception {
        // You can turn the number of operations up to larger numbers to
        // be able to detect issue.
        for(int i =0; i < 10000; i++){
            Customer customer = createCustomer();
            assertNotNull("ID should not be null", customer.getId());

            deleteCustomer(customer);
        }
    }

    private Customer createCustomer() throws Exception {
        tx.begin();

        Customer customer = CustomerFixture.createSingleCustomer();

        // Persists the Customer to the database
        em.persist(customer);
        assert tx != null;
        tx.commit();

        return customer;
    }

    private void deleteCustomer(Customer customer) throws Exception {
        tx.begin();

        // Uses Sting Based Criteria
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> c = cb.createQuery(Customer.class);
        Root<Customer> cust = c.from(Customer.class);
        c.select(cust)
                .where(cb.equal(cust.get("username"), customer.getUsername()));
        Customer result = em.createQuery(c).getSingleResult();

        em.remove(result);

        // Retrieves all the Customers from the database
        TypedQuery<Customer> q = em.createNamedQuery(
                Constants.FINDALLFINDERNAME, Customer.class);
        List<Customer> customers = q.getResultList();

        tx.commit();
    }
}
