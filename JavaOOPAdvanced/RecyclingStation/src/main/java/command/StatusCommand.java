package command;

import command.interfaces.Command;
import framework.waste.disposal.contracts.GarbageProcessor;
import framework.waste.disposal.contracts.ProcessingData;
import framework.waste.disposal.contracts.Waste;
import framework.waste.disposal.to.TranferObject;
import provider.DataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class StatusCommand extends  AbstactComand {

    public StatusCommand(String[] args, DataProvider dataProvider, GarbageProcessor garbageProcessor){
        super(args,dataProvider,garbageProcessor);
    }

    @Override
    public String execute() {
        List<ProcessingData> data = new ArrayList<>();
        for(Waste waste : dataProvider.getShopProducts()){
            data.add(this.garbageProcessor.processWaste(waste));
        }
        double energy = 0;
        double capital = 0;
        for(ProcessingData proData:data){
            energy += proData.getEnergyBalance();
            capital+=proData.getCapitalBalance();
        }
       return new TranferObject(energy,capital).toString();
    }
}
