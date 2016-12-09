import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by cefothe on 09.12.16.
 */
public class DemoQueries {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("softuni");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();


//        Query nativeQuery =entityManager.createNativeQuery("SELECT * FROM towns WHERE  LENGTH(towns.name)>5", Town.class);
//
//        List<Town> towns = nativeQuery.getResultList();
//

        Query jpqlQuery = entityManager.createQuery("SELECT t FROM Town AS t WHERE LENGTH(t.name)>5");
        List<Town> towns = jpqlQuery.setMaxResults(5).getResultList();

        towns.stream().forEach(x-> {
            entityManager.detach(x);
            System.out.println(x.getName());
        });


        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
