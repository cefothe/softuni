package com.cefothe.softuni.controller;

import com.cefothe.softuni.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by cefothe on 30.04.17.
 */
@Controller
public class IndexController {

    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("name","Ivan Ivanov");
        modelAndView.addObject("boolTrue",true);
        modelAndView.addObject("boolFalse",true);
        modelAndView.addObject("role","test");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping("/user")
    public String createUser(@ModelAttribute User user){
        return user.toString();
    }

    @GetMapping("/session")
    public ModelAndView sessiong(HttpSession httpSession, ModelAndView modelAndView){
        httpSession.setAttribute("id",123);
        modelAndView.setViewName("session");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping("/cookie/set")
    public String setCookie(HttpServletResponse httpServletResponse){
        httpServletResponse.addCookie(new Cookie("theme","dark"));
        return "Cookie is already set up";
    }

    @ResponseBody
    @GetMapping("/cookie/get")
    public String getCookie(@CookieValue("theme") String cookie){
        return "Value of cookie is "+ cookie;
    }

    @ResponseBody
    @GetMapping("/comment")
    public String comment(@RequestParam(value = "comment", defaultValue = "No comment")String comment){
        return comment;
    }

    @GetMapping("/register")
    public String register(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error", "simple error");
        return "redirect:/login";
    }

    @ResponseBody
    @GetMapping("/login")
    public String login(Model model){
        Map md = model.asMap();
        String values = "";
        for (Object modelKey : md.keySet()) {
            Object modelValue = md.get(modelKey);
            values += modelKey + " -- " + modelValue;
        }
        return values;
    }
}
