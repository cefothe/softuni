package app.domain.shampoos;

import app.domain.batches.ProductionBatch;
import app.domain.enums.Size;
import app.domain.ingrediants.BasicIngredient;
import app.domain.labels.ClassicLabel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by cefothe on 10.12.16.
 */
public interface Shampoo extends Serializable {
    long getId();

    void setId(long id);

    String getBrand();

    void setBrand(String brand);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Size getSize();

    void setSize(Size size);

    ClassicLabel getLabel();

    void setLabel(ClassicLabel label);

    ProductionBatch getBatch();

    void setBatch(ProductionBatch batch);

    Set<BasicIngredient> getIngredients();

    void setIngredients(Set<BasicIngredient> ingredients);
}
