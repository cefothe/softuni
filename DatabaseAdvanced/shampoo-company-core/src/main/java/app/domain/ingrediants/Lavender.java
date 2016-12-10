package app.domain.ingrediants;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by cefothe on 10.12.16.
 */

@Entity
//@DiscriminatorValue(value = "lavender")
public class Lavender extends  BasicIngredient {

    private static  final String NAME= "Lavender";
    private  static final BigDecimal PRICE = new BigDecimal("2");

    public Lavender() {
        super(NAME,PRICE);
    }


}