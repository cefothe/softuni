package services.interfaces;

import common.ApplicationUser;

import javax.servlet.http.HttpSession;

/**
 * Created by cefothe on 05.03.17.
 */
public interface AuthorizationService {
    ApplicationUser typeOfUser(HttpSession httpSession);
}
