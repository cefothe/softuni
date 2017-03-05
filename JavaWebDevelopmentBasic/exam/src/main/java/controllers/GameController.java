package controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;

import javax.ejb.Stateless;

/**
 * Created by cefothe on 05.03.17.
 */
@Stateless
@Controller
public class GameController {

    @GetMapping("/game/add")
    public String addGamePage(){
        return "template/add-game";
    }
}
