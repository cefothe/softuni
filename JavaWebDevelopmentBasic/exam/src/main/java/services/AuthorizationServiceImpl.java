package services;

import common.ApplicationUser;
import entities.user.Role;
import entities.user.User;
import services.interfaces.AuthorizationService;

import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

/**
 * Created by cefothe on 05.03.17.
 */
@Stateless
public class AuthorizationServiceImpl implements AuthorizationService {

    @Override
    public ApplicationUser typeOfUser(HttpSession httpSession) {
        if(httpSession!= null){
            User user = (User) httpSession.getAttribute("user");
            if(user !=null){
                if(Role.USER.equals(user.getRole())){
                    return ApplicationUser.USER;
                }else if(Role.ADMIN.equals(user.getRole())){
                    return ApplicationUser.ADMIN;
                }
             }
        }

        return  ApplicationUser.GUEST;
    }
}
