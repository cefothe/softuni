package app.repositories;

import app.domain.ingrediants.BasicIngredient;
import app.domain.ingrediants.Ingrediant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cefothe on 10.12.16.
 */
@Repository
public interface BasicIngredientRepository extends JpaRepository<BasicIngredient,Long> {
}
