package app.services;

import app.domain.User;

import java.util.List;

/**
 * Created by cefothe on 10.12.16.
 */
public interface UserService {
    void createUser(User user);
    List<User> findUserByEmail(String email);
    Integer countOfBigPictures(Integer size);
}
