package controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import entities.user.User;
import model.binding.CreateUserModel;
import model.binding.LoginUserModel;
import services.interfaces.AuthorizationService;
import services.interfaces.UserService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by cefothe on 05.03.17.
 */
@ManagedBean
@Controller
public class UserController {

    @Inject
    private UserService userService;


    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("pageName", "Log in");
        return "template/login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute LoginUserModel loginUserModel,Model model, HttpSession httpSession){
        model.addAttribute("pageName", "Log in");
        User user = this.userService.findLoggedInUser(loginUserModel);
        if (user == null) {
            model.addAttribute("loginError", "loginError");
            return "template/login";
        }

        this.userService.createUserSession(user, httpSession);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("pageName","Register");
        return "template/register";
    }

    @PostMapping("/register")
    public  String create(@ModelAttribute CreateUserModel createUserModel, Model model){
        model.addAttribute("pageName","Register");

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<CreateUserModel>> constraintViolations = validator.validate(createUserModel);

        if (constraintViolations.size() > 0) {
            model.addAttribute("constraintViolations", constraintViolations);
            return "template/register";
        }

        if (!createUserModel.getPassword().equals(createUserModel.getRepeatPassword())) {
            model.addAttribute("passwordMismatch", "passwordMismatch");
            return "/templates/register";
        }

        this.userService.registeUser(createUserModel);

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession  httpSession){
        httpSession.invalidate();

        return "redirect:/login";
    }
}
