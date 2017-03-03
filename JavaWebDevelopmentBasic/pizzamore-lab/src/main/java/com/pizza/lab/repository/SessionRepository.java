package com.pizza.lab.repository;

import com.pizza.lab.models.entities.Session;
import com.pizza.lab.models.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by cefothe on 03.03.17.
 */
public class SessionRepository {

    public long createSession(Session session){
        long id;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaMore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
            em.persist(session);
            id=session.getId();
        em.getTransaction().commit();
        em.close();
        emf.close();

        return id;
    }

    public Session findById(long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaMore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT s FROM Session s WHERE s.id =:id");
        query.setParameter("id",id);
        Session session = null;
        if(!(query.getResultList().size()==0)){
            session = (Session) query.getSingleResult();
        }
        em.getTransaction().commit();
        em.close();
        emf.close();

        return session;
    }

    public void delete(Session session){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaMore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(session);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
