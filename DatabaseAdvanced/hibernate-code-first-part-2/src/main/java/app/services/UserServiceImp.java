package app.services;

import app.domain.User;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cefothe on 10.12.16.
 */
@Service
public class UserServiceImp implements  UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findUserByEmail(String email) {
       return userRepository.findByEmail(email);
    }

    @Override
    public Integer countOfBigPictures(Integer size) {
        return userRepository.countByProfilePictureGreaterThan(new byte[size]);
    }
}
