package app.domain.ingrediants;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
public abstract class BasicChemicalIngrediant extends BasicIngredient implements  ChemicalIngredient {

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    protected BasicChemicalIngrediant() {
    }

    protected BasicChemicalIngrediant(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.chemicalFormula = chemicalFormula;
    }

    @Override
    public String getChemicalFormula() {
        return chemicalFormula;
    }

    @Override
    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}
