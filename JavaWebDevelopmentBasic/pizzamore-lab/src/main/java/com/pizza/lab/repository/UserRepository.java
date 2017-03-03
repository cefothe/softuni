package com.pizza.lab.repository;

import com.pizza.lab.models.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by cefothe on 03.03.17.
 */
public class UserRepository {
    public void createUser(User user){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaMore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
            em.persist(user);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
