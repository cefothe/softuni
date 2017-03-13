package repositories.interfaces;

import entities.game.Game;

import java.util.List;

/**
 * Created by cefothe on 05.03.17.
 */

public interface GameRepository {
     void createGame(Game game);
     List<Game> findAllGames();
     Game findById(long id);
     void deleteGameById(long id);
     void updateGame(Game game, long id);
}
