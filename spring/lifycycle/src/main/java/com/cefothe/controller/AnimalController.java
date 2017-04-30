package com.cefothe.controller;

import com.cefothe.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Stefan Angelov - Delta Source Bulgaria on 3/13/17.
 */
@Controller
public class AnimalController {

    @Autowired
    private Animal god;

    @GetMapping("/animal")
    @ResponseBody
    public String getGod(){
        return  god.getName();
    }
}
