package app.domain.ingrediants;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
@DiscriminatorValue(value = "strawbery")
public class Strawberry extends  BasicIngredient {

    private static  final String NAME= "strawbery";
    private  static final BigDecimal PRICE = new BigDecimal("4.85");

    public Strawberry() {
        super(NAME,PRICE);
    }


}
