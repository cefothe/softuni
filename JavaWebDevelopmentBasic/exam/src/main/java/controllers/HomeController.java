package controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.models.Model;


import javax.ejb.Stateless;

/**
 * Created by cefothe on 05.03.17.
 */
@Stateless
@Controller
public class HomeController {


    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("pageName", "Home");
        return "template/home";
    }
}
