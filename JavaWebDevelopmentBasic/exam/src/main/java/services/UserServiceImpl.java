package services;

import common.ApplicationUser;
import entities.user.Role;
import entities.user.User;
import model.binding.CreateUserModel;
import model.binding.LoginUserModel;
import repositories.interfaces.UserRepository;
import services.interfaces.UserService;
import utils.parser.interfaces.ModelParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;


/**
 * Created by cefothe on 05.03.17.
 */
@Stateless
public class UserServiceImpl implements UserService{

    @Inject
    private UserRepository userRepository;

    @Inject
    private ModelParser modelParser;


    @Override
    public void registeUser(CreateUserModel createUserModel) {
        User user = modelParser.convert(createUserModel, User.class);
        Role role= Role.USER;
        if(userRepository.numberOfUser()==0){
            role = Role.ADMIN;
        }
        user.setRole(role);
        userRepository.createUser(user);
    }

    @Override
    public User findLoggedInUser(LoginUserModel loginUserModel) {
        String email = loginUserModel.getEmail();
        String password = loginUserModel.getPassword();
        return userRepository.findByUsernameAndPassword(email,password);
    }

    @Override
    public void createUserSession(User user, HttpSession httpSession) {
        httpSession.setAttribute("user",user);
    }


}
