package app.services;

import app.domain.ingrediants.BasicIngredient;

/**
 * Created by cefothe on 10.12.16.
 */
public interface BasicIngredientService {

    void create(BasicIngredient basicIngredient);
    BasicIngredient retrieve(Long id);
}
