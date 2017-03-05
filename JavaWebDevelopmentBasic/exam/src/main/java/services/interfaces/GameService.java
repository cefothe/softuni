package services.interfaces;

import model.binding.CreateGameModel;
import model.view.GamesModel;

import java.util.List;

/**
 * Created by cefothe on 05.03.17.
 */
public interface GameService {
    void createGame(CreateGameModel createGameModel);
    List<GamesModel> findAllGames();
    GamesModel findById(Long id);
    void updateGame(CreateGameModel createGameModel, long id);
    void deleteGame(long id);
}
