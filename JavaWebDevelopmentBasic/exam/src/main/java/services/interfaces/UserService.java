package services.interfaces;

import common.ApplicationUser;
import entities.user.User;
import model.binding.CreateUserModel;
import model.binding.LoginUserModel;

import javax.servlet.http.HttpSession;

/**
 * Created by cefothe on 05.03.17.
 */
public interface UserService {
    void registeUser(CreateUserModel createUserModel);
    User findLoggedInUser(LoginUserModel loginUserModel);
    void createUserSession(User user, HttpSession httpSession);
}
