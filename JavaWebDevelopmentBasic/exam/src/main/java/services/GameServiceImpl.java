package services;

import entities.game.Game;
import model.binding.CreateGameModel;
import model.view.GamesModel;
import repositories.interfaces.GameRepository;
import services.interfaces.GameService;
import utils.parser.interfaces.ModelParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.util.Locale;

/**
 * Created by cefothe on 05.03.17.
 */
@Stateless
public class GameServiceImpl implements GameService {

    @Inject
    private ModelParser modelParser;

    @Inject
    private GameRepository gameRepository;

    @Override
    public void createGame(CreateGameModel createGameModel) {
        Game game = new Game();
        //TODO best way do to this.
        game.setDescription(createGameModel.getDescription());
        game.setImageThumbnail(createGameModel.getImageThumbnail());
        game.setTitle(createGameModel.getTitle());
        game.setPrice(Double.valueOf(createGameModel.getPrice()));
        game.setTrailer(createGameModel.getTrailer());
        game.setSize(Double.valueOf(createGameModel.getSize()));
        setReleaseDate(createGameModel, game);
        gameRepository.createGame(game);
    }

    private void setReleaseDate(CreateGameModel createGameModel, Game game) {
        try {
            game.setReleaseDate( new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(createGameModel.getReleaseDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GamesModel> findAllGames() {
        List<GamesModel> gamesModels = new ArrayList<>();
        List<Game> games = gameRepository.findAllGames();
        for(Game game :games){
            GamesModel gamesModel = mapping(game);
            gamesModels.add(gamesModel);

        }
        return  gamesModels;
    }

    private GamesModel mapping(Game game) {
        GamesModel gamesModel= modelParser.convert(game,GamesModel.class);
        gamesModel.setId(game.getId());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        gamesModel.setReleaseDateString(df.format(game.getReleaseDate()));
        gamesModel.setPrice(game.getPrice());
        return gamesModel;
    }

    @Override
    public GamesModel findById(Long id) {
        return  mapping(gameRepository.findById(id));
    }

    @Override
    public void updateGame(CreateGameModel createGameModel, long id) {
        Game game =gameRepository.findById(id);

        //TODO best way to do that
        game.setTitle(createGameModel.getTitle());
        game.setImageThumbnail(createGameModel.getImageThumbnail());
        game.setSize(Double.valueOf(createGameModel.getSize()));
        setReleaseDate(createGameModel,game);
        game.setDescription(createGameModel.getDescription());
        game.setTrailer(createGameModel.getTrailer());
        game.setPrice(Double.valueOf(createGameModel.getPrice()));

        gameRepository.updateGame(game,id);
    }

    @Override
    public void deleteGame(long id) {
        gameRepository.deleteGameById(id);
    }
}
