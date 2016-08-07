package dg.mon.hw.ch10;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
    public static void main(String[] args){

        Pages t = new Pages();

        t.setTitle("title1");
        t.setContent("content1");

        Configuration cfg = new Configuration();

        SessionFactory sf = cfg.configure().buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();

        session.close();

        sf.close();
    }
}

@Entity
@Table(name = "pages")
class Pages{

    private int id;

    private String title;

    private String content;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}