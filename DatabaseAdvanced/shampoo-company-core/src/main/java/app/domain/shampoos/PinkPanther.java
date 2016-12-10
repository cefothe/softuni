package app.domain.shampoos;

import app.domain.batches.ProductionBatch;
import app.domain.enums.Size;
import app.domain.ingrediants.BasicIngredient;
import app.domain.labels.ClassicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
@DiscriminatorValue(value = "PP")
public class PinkPanther extends  BasicShampoo {

    private static final String BRAND = "Pink Panther";
    private static final BigDecimal PRICE = new BigDecimal("8.5");
    private static  final Size  SIZE = Size.MEDIUM;

    public PinkPanther() {
    }

    public PinkPanther(String brand, BigDecimal price, Size size, ClassicLabel label, ProductionBatch productionBatch, Set<BasicIngredient> ingredients) {
        super(BRAND, PRICE, SIZE, label, productionBatch,ingredients);
    }
}
