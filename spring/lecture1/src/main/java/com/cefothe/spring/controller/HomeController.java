package com.cefothe.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Stefan Angelov - Delta Source Bulgaria on 3/13/17.
 */
@Controller
public class HomeController {

 @GetMapping("/")
 public String getHomePage(){
    return "home.html";
 }
}
