package controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.parameters.PathVariable;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import model.binding.CreateGameModel;
import model.binding.CreateUserModel;
import model.view.GamesModel;
import services.interfaces.GameService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by cefothe on 05.03.17.
 */
@Stateless
@Controller
public class GameController {

    @Inject
    private GameService gameService;

    @GetMapping("/game/add")
    public String gamePage(){
        return "template/add-game";
    }

    @PostMapping("/game/add")
    public String createGame(@ModelAttribute CreateGameModel createGameModel, Model model){

        if (checkForConstraints(createGameModel, model)) return "template/add-game";

        gameService.createGame(createGameModel);
        return "redirect:/game/all";
    }

    @GetMapping("/game/all")
    public String allGames(Model model){
        model.addAttribute("games",this.gameService.findAllGames());
        return "template/all-game";
    }

    @GetMapping("/game/delete/{id}")
    public String deletePageGame(@PathVariable("id") long id, Model model){
        GamesModel gamesModel = gameService.findById(id);
        model.addAttribute("pageName","Delete game");
        model.addAttribute("game",gamesModel);
        return "template/delete-game";
    }

    @PostMapping("/game/delete/{id}")
    public String deleteConfirm(@PathVariable("id") long id){
        gameService.deleteGame(id);
        return "redirect:/game/all";
    }

    @GetMapping("/game/edit/{id}")
    public String editPageGame(@PathVariable("id") long id, Model model){
        GamesModel gamesModel = gameService.findById(id);
        model.addAttribute("pageName","Delete game");
        model.addAttribute("game",gamesModel);
        return "template/edit-game";
    }

    @PostMapping("/game/edit/{id}")
    public String editPage(@PathVariable("id") long id, @ModelAttribute CreateGameModel createGameModel, Model model){

        if (checkForConstraints(createGameModel, model)) return "template/add-game";

        gameService.updateGame(createGameModel,id);
        return "redirect:/game/all";
    }

    private boolean checkForConstraints(CreateGameModel createGameModel, Model model) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<CreateGameModel>> constraintViolations = validator.validate(createGameModel);

        if (constraintViolations.size() > 0) {
            model.addAttribute("constraintViolations", constraintViolations);
            return true;
        }
        return false;
    }
}
