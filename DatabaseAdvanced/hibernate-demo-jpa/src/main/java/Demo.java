import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by cefothe on 08.12.16.
 */
public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("schools");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

            Student stefan = new Student("Stefan", new Date());
            Student ivan = new Student("Ivan", new Date());

            em.persist(stefan);
            em.persist(ivan);

            Student find = em.find(Student.class,1);

            System.out.println(find.getName());

            em.remove(find);

            Student newStudent = new Student("Dragan", new Date());

            em.merge(newStudent);


        em.getTransaction().commit();
    }
}
