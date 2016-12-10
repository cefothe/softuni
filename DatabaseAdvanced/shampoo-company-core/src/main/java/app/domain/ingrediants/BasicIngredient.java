package app.domain.ingrediants;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
//@Table(name = "ingredients")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "ingredient_type",discriminatorType = DiscriminatorType.STRING)
public abstract class BasicIngredient  implements  Ingrediant{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Basic
    private String name;

    @Basic
    private BigDecimal price;

    protected BasicIngredient() {
    }

    protected BasicIngredient(String name, BigDecimal price) {
        this.setName(name);
        this.setPrice(price);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
