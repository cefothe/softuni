package repositories.interfaces;

import entities.user.User;

/**
 * Created by cefothe on 05.03.17.
 */
public interface UserRepository {
    void createUser(User user);
    User findByUsernameAndPassword(String username, String password);
    Long numberOfUser();
}
