package org.cdibook.chapter9.service;

import org.cdibook.chapter9.TestDeployment;
import org.cdibook.chapter9.enums.RoleType;
import org.cdibook.chapter9.exception.ServiceException;
import org.cdibook.chapter9.model.Author;
import org.cdibook.chapter9.model.Book;
import org.cdibook.chapter9.model.Category;
import org.cdibook.chapter9.model.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RunWith(Arquillian.class)
public class BookServiceTest extends AbstractServiceTest {

    @Deployment
    public static WebArchive deployment() {
        return TestDeployment.deployment()
                .addAsWebInfResource("META-INF/test-security-beans.xml", "beans.xml")
                .addClass(BookService.class)
                .addClass(UserService.class)
                .addClass(AbstractServiceTest.class);
    }

    @PersistenceContext
    EntityManager em;

    @Inject
    UserTransaction utx;

    @Inject
    BookService bookService;

    @Inject
    UserService userService;

    @Inject
    BeanManager beanManager;

    private static boolean createdAdminUser = false;

    @Before
    public void prepareTest() throws Exception {
        // Create Admin user if not done in previous test method execution
        if (!createdAdminUser) {
            User user = new User("Admin", "admin@user.com", RoleType.ADMIN, "password");
            userService.createUser(user);
            createdAdminUser = true;
        }
    }

    @After
    public void clearTest() throws Exception {
        // Clear old records
        utx.begin();
        em.joinTransaction();
        em.createNativeQuery("delete from book_author").executeUpdate();
        em.createQuery("delete from Book").executeUpdate();
        em.createQuery("delete from Author").executeUpdate();
        em.createQuery("delete from Category").executeUpdate();
        utx.commit();
    }

    @Override
    protected BeanManager getBeanManager() {
        return beanManager;
    }

    @Test
    public void add_category() throws Exception {
        // given
        Category cat = new Category("Root Category");
        userService.login("admin@user.com", "password");

        // when
        bookService.addCategory(cat);

        // then
        List<Category> cats = em.createQuery("SELECT c FROM Category c WHERE c.name = :name", Category.class)
                .setParameter("name", cat.getName())
                .getResultList();
        Assert.assertNotNull(cats);
        Assert.assertEquals(1, cats.size());
        Assert.assertEquals(cat, cats.get(0));
    }

    @Test(expected = ServiceException.class)
    public void add_category_fail() throws Exception {
        // given
        Category cat = new Category("Rt");
        userService.login("admin@user.com", "password");

        // when
        bookService.addCategory(cat);

        // then
        // ServiceException
    }

    @Test
    public void get_categories() throws Exception {
        // given
        Category cat = new Category("Root Category");
        Category cat1 = new Category("Second Root Category");
        userService.login("admin@user.com", "password");
        bookService.addCategory(cat);
        bookService.addCategory(cat1);
        userService.logout();

        // when
        List<Category> cats = bookService.getCategories();

        // then
        Assert.assertNotNull(cats);
        Assert.assertEquals(2, cats.size());

        Category category1 = cats.get(0);
        Category category2 = cats.get(1);
        Assert.assertEquals(cat.getName(), category1.getName());
        Assert.assertEquals(cat1.getName(), category2.getName());
    }

    @Test
    public void add_author() throws Exception {
        // given
        Author author = new Author("Stephen King");
        userService.login("admin@user.com", "password");

        // when
        bookService.addAuthor(author);

        // then
        List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class)
                .getResultList();
        Assert.assertNotNull(authors);
        Assert.assertEquals(1, authors.size());
        Assert.assertEquals(author, authors.get(0));
    }

    @Test(expected = ServiceException.class)
    public void add_author_fail() throws Exception {
        // given
        Author author = new Author("SK");
        userService.login("admin@user.com", "password");

        // when
        bookService.addAuthor(author);

        // then
        // ServiceException
    }

    @Test
    public void get_authors() throws Exception {
        // given
        Author author1 = new Author("Author");
        Author author2 = new Author("B Author");
        Author author3 = new Author("C Author");
        userService.login("admin@user.com", "password");
        bookService.addAuthor(author1);
        bookService.addAuthor(author2);
        bookService.addAuthor(author3);

        // when
        List<Author> authors = bookService.getAuthors();

        // then
        Assert.assertNotNull(authors);
        Assert.assertEquals(3, authors.size());

        Assert.assertEquals(author1, authors.get(0));
        Assert.assertEquals(author2, authors.get(1));
        Assert.assertEquals(author3, authors.get(2));
    }

    @Test
    public void get_author() throws Exception {
        // given
        Author author = new Author("Stephen King");
        userService.login("admin@user.com", "password");
        bookService.addAuthor(author);

        // when
        Author retrieved = bookService.getAuthor(author.getName());

        // then
        Assert.assertNotNull(retrieved);
        Assert.assertEquals(author.getName(), retrieved.getName());
        Assert.assertNotNull(retrieved.getId());
    }

    @Test
    public void add_book() throws Exception {
        // given
        Author author = new Author("Stephen King");
        userService.login("admin@user.com", "password");
        bookService.addAuthor(author);
        author = bookService.getAuthor(author.getName());

        Category cat = new Category("Root Category");
        bookService.addCategory(cat);
        cat = bookService.getCategories().get(0);

        Book book = new Book("Book Title", "description", "1234567890", new Date(), "publisher", new BigDecimal("25.35"), cat);
        book.addAuthor(author);

        // when
        bookService.addBook(book);

        // then
        List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
        Assert.assertNotNull(books);
        Assert.assertEquals(1, books.size());
        Assert.assertEquals(book, books.get(0));
    }

    @Test(expected = ServiceException.class)
    public void add_book_fail() throws Exception {
        // given
        Author author = new Author("Stephen King");
        userService.login("admin@user.com", "password");
        bookService.addAuthor(author);
        author = bookService.getAuthor(author.getName());

        Category cat = new Category("Root Category");
        bookService.addCategory(cat);
        cat = bookService.getCategories().get(0);

        Book book = new Book("Book Title", "description", "1234567890", null, "publisher", new BigDecimal("25.35"), cat);
        book.addAuthor(author);

        // when
        bookService.addBook(book);

        // then
        // ServiceException
    }

    @Test(expected = EntityExistsException.class)
    public void add_book_fail_already_exists() throws Exception {
        // given
        Author author = new Author("Stephen King");
        userService.login("admin@user.com", "password");
        bookService.addAuthor(author);
        author = bookService.getAuthor(author.getName());

        Category cat = new Category("Root Category");
        bookService.addCategory(cat);
        cat = bookService.getCategories().get(0);

        Book book = new Book("Book Title", "description", "1234567890", new Date(), "publisher", new BigDecimal("25.35"), cat);
        book.addAuthor(author);

        // when
        bookService.addBook(book);
        bookService.addBook(bookService.getAll(null).get(0));

        // then
        // EntityExistsException
    }

    @Test
    public void update_book() throws Exception {
        // given
        Author author = new Author("Stephen King");
        userService.login("admin@user.com", "password");
        bookService.addAuthor(author);
        author = bookService.getAuthor(author.getName());

        Category cat = new Category("Root Category");
        bookService.addCategory(cat);
        cat = bookService.getCategories().get(0);

        Book book = new Book("Book Title", "description", "1234567890", new Date(), "publisher", new BigDecimal("25.35"), cat);
        book.addAuthor(author);
        bookService.addBook(book);
        book = bookService.getAll(null).get(0);
        book.setPrice(new BigDecimal("21.50"));

        // when
        bookService.updateBook(book);

        // then
        List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
        Assert.assertNotNull(books);
        Assert.assertEquals(1, books.size());
        Assert.assertEquals(book, books.get(0));
        Assert.assertEquals(new BigDecimal("21.50"), books.get(0).getPrice());
    }
}
