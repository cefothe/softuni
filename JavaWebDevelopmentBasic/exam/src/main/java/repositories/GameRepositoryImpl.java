package repositories;

import entities.game.Game;
import repositories.interfaces.GameRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by cefothe on 05.03.17.
 */
@Stateless
public class GameRepositoryImpl implements GameRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createGame(Game game) {
        entityManager.persist(game);
    }

    @Override
    public List<Game> findAllGames() {
       return entityManager.createNamedQuery(Game.FIND_ALL_GAMES,Game.class).getResultList();
    }

    @Override
    public Game findById(long id) {
        return entityManager.find(Game.class, id);
    }

    @Override
    public void deleteGameById(long id) {
        Game game = findById(id);
        entityManager.remove(game);
    }

    @Override
    public void updateGame(Game game, long id) {
        entityManager.merge(game);
    }
}
