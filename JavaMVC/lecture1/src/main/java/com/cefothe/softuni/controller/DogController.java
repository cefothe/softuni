package com.cefothe.softuni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cefothe on 27.04.17.
 */

@Controller
@RequestMapping("/dog")
public class DogController {

    @GetMapping("/dog1")
    @ResponseBody
    public String getDogHomePage1(){
        return "I am a dog page";
    }

    @GetMapping("")
    public ModelAndView getDogHomePage(ModelAndView modelAndView){
        modelAndView.setViewName("dog-page.html");
        return  modelAndView;
    }
}
