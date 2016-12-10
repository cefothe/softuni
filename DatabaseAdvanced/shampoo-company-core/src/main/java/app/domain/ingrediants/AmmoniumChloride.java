package app.domain.ingrediants;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
@DiscriminatorValue(value = "ammoniumChloride")
public class AmmoniumChloride extends  BasicChemicalIngrediant {

    private static  final String NAME= "Ammonium Chloride";
    private  static final BigDecimal PRICE = new BigDecimal("6.12");
    private static  final String FORMULA = "NH4C1";


    public AmmoniumChloride() {
        super(NAME,PRICE,FORMULA);
    }
}
