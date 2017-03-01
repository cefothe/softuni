package app.domain.shampoos;

import app.domain.batches.ProductionBatch;
import app.domain.enums.Size;
import app.domain.ingrediants.BasicIngredient;
import app.domain.labels.ClassicLabel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
@Table(name = "shampoos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "shampoo_type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicShampoo implements  Shampoo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String brand;

    @Basic
    private BigDecimal price;

    @Enumerated(value = EnumType.STRING)
    private Size size;

    @OneToOne(optional = false)
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    private ClassicLabel label;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bach_id",referencedColumnName = "id")
    private ProductionBatch batch;

    @ManyToMany
    @JoinTable(name = "shampoos_ingredients",
            joinColumns = @JoinColumn(name = "shampoo_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediant_id", referencedColumnName = "id"))
    private Set<BasicIngredient> ingrediants;

    protected BasicShampoo() {
        this.setIngrediants(new HashSet<>());
    }

    protected BasicShampoo(String brand, BigDecimal price, Size size, ClassicLabel label, ProductionBatch productionBatch, Set<BasicIngredient> ingredients) {
        this();
        this.brand = brand;
        this.price = price;
        this.size = size;
        this.label = label;
        this.batch = productionBatch;
        this.ingrediants = ingredients;
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
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public ClassicLabel getLabel() {
        return label;
    }

    @Override
    public void setLabel(ClassicLabel label) {
        this.label = label;
    }

    public ProductionBatch getBatch() {
        return batch;
    }

    public void setBatch(ProductionBatch batch) {
        this.batch = batch;
    }

    public Set<BasicIngredient> getIngrediants() {
        return ingrediants;
    }

    public void setIngrediants(Set<BasicIngredient> ingrediants) {
        this.ingrediants = ingrediants;
    }

    @Override
    public Set<BasicIngredient> getIngredients() {
        return ingrediants;
    }

    @Override
    public void setIngredients(Set<BasicIngredient> ingredients) {
        this.ingrediants =ingredients;
    }
}