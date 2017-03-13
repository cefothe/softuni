package services.interfaces;

import model.view.GamesModel;

import java.util.List;

/**
 * Created by cefothe on 05.03.17.
 */
public interface HomeService {
    List<GamesModel> findAll();
}
