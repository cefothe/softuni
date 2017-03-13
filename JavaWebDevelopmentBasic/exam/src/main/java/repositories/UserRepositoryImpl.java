package repositories;

import entities.user.User;
import repositories.interfaces.UserRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import static entities.user.User.FIND_BY_USERNAME_AND_PASSWORD;
import static entities.user.User.NUMBER_OF_USER;

/**
 * Created by cefothe on 05.03.17.
 */
@Stateless
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findByUsernameAndPassword(String email, String password) {
       return entityManager.createNamedQuery(FIND_BY_USERNAME_AND_PASSWORD, User.class)
                .setParameter("email", email).setParameter("password",password).getSingleResult();
    }

    @Override
    public Long numberOfUser() {
        return entityManager.createNamedQuery(NUMBER_OF_USER, Long.class).getSingleResult();
    }
}
