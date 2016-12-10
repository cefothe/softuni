package app.terminal;

import app.domain.ingrediants.AmmoniumChloride;
import app.domain.ingrediants.BasicIngredient;
import app.domain.ingrediants.Ingrediant;
import app.domain.ingrediants.Mint;
import app.services.BasicIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by cefothe on 10.12.16.
 */
@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private BasicIngredientService basicIngredientService;

    @Override
    public void run(String... strings) throws Exception {
        BasicIngredient am = new AmmoniumChloride();
        BasicIngredient mint = new Mint();
        basicIngredientService.create(am);
        basicIngredientService.create(mint);

        Ingrediant receiveIngrediant = basicIngredientService.retrieve(1L);
        System.out.println(receiveIngrediant.getName());
    }
}
