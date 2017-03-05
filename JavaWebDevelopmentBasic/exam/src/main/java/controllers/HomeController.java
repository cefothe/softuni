package controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.models.Model;
import services.interfaces.HomeService;


import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by cefothe on 05.03.17.
 */
@Stateless
@Controller
public class HomeController {

    @Inject
    private HomeService homeService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("pageName", "Home");
        model.addAttribute("games",this.homeService.findAll());
        return "template/home";
    }
}
