import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by cefothe on 23.12.16.
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("schools");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

            Student student = new Student("Stefan", "Angelov");
            student.setFirstName(null);
            em.persist(student);
        em.getTransaction().commit();

        em.getTransaction().begin();

            Student student1 = em.find(Student.class, 1);
            student1.setFirstName(null);
        em.getTransaction().commit();
    }
}
