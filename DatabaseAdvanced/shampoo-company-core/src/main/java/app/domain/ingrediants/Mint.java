package app.domain.ingrediants;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
//@DiscriminatorValue(value = "mint")
public class Mint extends  BasicIngredient {

    private static  final String NAME= "Mint";
    private  static final BigDecimal PRICE = new BigDecimal("3.54");

    public Mint() {
        super(NAME,PRICE);
    }


}