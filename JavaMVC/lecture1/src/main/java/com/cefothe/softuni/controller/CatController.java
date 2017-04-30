package com.cefothe.softuni.controller;

import com.cefothe.softuni.entities.BaseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cefothe on 27.04.17.
 */
@Controller
@RequestMapping("/cat")
public class CatController {

    @GetMapping("/cat1")
    public String getHomeCatPage(){
        return "cat-page.html";
    }

    @GetMapping("")
    public String getcxaNewCatPage(){
        return "new-cat.html";
    }

    @GetMapping("/edit/{catId}")
    @ResponseBody
    public String editCat(@PathVariable long catId){
        return String.valueOf(catId);
    }

    @PostMapping("")
    public String addCat(@RequestParam("catName") String catName, @RequestParam("catAge") int catAge){
        System.out.println(String.format("Cat Name: %s, Cat age: %d",catName,catAge));
        return "redirect:/cat";
    }

}
