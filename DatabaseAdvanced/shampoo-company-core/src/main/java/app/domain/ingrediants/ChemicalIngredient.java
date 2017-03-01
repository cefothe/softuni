package app.domain.ingrediants;

/**
 * Created by cefothe on 10.12.16.
 */
public interface ChemicalIngredient extends Ingrediant{

    String getChemicalFormula();

    void setChemicalFormula(String chemicalFormula);
}
