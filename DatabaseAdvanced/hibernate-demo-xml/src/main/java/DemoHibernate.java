import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;

/**
 * Created by cefothe on 08.12.16.
 */
public class DemoHibernate {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = new Student("Stefan", new Date());
        session.save(student);

        // Your Code Here
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
