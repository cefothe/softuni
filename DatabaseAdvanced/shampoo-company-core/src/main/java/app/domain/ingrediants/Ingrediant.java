package app.domain.ingrediants;

import app.domain.shampoos.BasicShampoo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by cefothe on 10.12.16.
 */
public interface Ingrediant extends Serializable {

    long getId();

    void setId(long id);

    String getName();

    void setName(String name);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Set<BasicShampoo> getShampoos();

    void setShampoos(Set<BasicShampoo> getShampoos);
}
