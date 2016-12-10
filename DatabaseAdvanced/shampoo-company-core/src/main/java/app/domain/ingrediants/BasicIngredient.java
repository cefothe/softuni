package app.domain.ingrediants;

import app.domain.shampoos.BasicShampoo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
@Table(name = "ingredients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ingredient_type",discriminatorType = DiscriminatorType.STRING)
public abstract class BasicIngredient  implements  Ingrediant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String name;

    @Basic
    private BigDecimal price;

    @ManyToMany(mappedBy = "ingrediants", targetEntity = BasicShampoo.class)
    private Set<BasicShampoo> basicShampoos;

    protected BasicIngredient() {
        basicShampoos = new HashSet<>();
    }

    protected BasicIngredient(String name, BigDecimal price) {
        this.setName(name);
        this.setPrice(price);
    }

    @Override
    public Set<BasicShampoo> getShampoos() {
        return basicShampoos;
    }

    @Override
    public void setShampoos(Set<BasicShampoo> getShampoos) {
        this.basicShampoos = getShampoos;
    }

    public void addBasicShampoo(BasicShampoo basicShampoo){
        this.getShampoos().add(basicShampoo);
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
