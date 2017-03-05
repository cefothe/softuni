package services;

import model.view.GamesModel;
import repositories.interfaces.GameRepository;
import services.interfaces.GameService;
import services.interfaces.HomeService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by cefothe on 05.03.17.
 */
@Stateless
public class HomeServiceImpl implements HomeService {

    @Inject
    private GameService gameService;

    @Override
    public List<GamesModel> findAll() {
        return gameService.findAllGames();
    }
}
