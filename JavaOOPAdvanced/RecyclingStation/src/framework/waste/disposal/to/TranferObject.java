package framework.waste.disposal.to;

import core.constants.Constants;
import framework.waste.disposal.contracts.ProcessingData;

/**
 * Created by stefanangelov on 8/7/16.
 */

//TODO: This should be with builder pattern
public class TranferObject implements ProcessingData {

    private  double energyBalance;
    private  double capitalBalance;

    public TranferObject(double energyBalance, double capitalBalance) {
        this.setCapitalBalance(capitalBalance);
        this.setEnergyBalance(energyBalance);
    }

    private void setEnergyBalance(double energyBalance) {
        this.energyBalance = energyBalance;
    }

    private void setCapitalBalance(double capitalBalance) {
        this.capitalBalance = capitalBalance;
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }

    @Override
    public String toString() {
        return String.format(
                Constants.TRANFER_OBJECT,
                getEnergyBalance(),
                getCapitalBalance()
        );
    }
}
