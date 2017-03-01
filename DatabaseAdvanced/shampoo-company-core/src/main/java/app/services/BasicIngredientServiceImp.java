package app.services;

import app.domain.ingrediants.BasicIngredient;
import app.repositories.BasicIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cefothe on 10.12.16.
 */
@Service
public class BasicIngredientServiceImp implements  BasicIngredientService {

    @Autowired
    private BasicIngredientRepository basicIngredientRepository;

    @Override
    public void create(BasicIngredient basicIngredient) {
        basicIngredientRepository.saveAndFlush( basicIngredient);
    }

    @Override
    public BasicIngredient retrieve(Long id) {
        return basicIngredientRepository.findOne(id);
    }
}
