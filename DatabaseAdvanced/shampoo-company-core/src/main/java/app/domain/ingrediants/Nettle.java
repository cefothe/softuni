package app.domain.ingrediants;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
//@DiscriminatorValue(value = "nettle")
public class Nettle extends  BasicIngredient {

    private static  final String NAME= "nettle";
    private  static final BigDecimal PRICE = new BigDecimal("6.12");

    public Nettle() {
        super(NAME,PRICE);
    }


}