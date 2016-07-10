package system.split.software;

import system.split.common.Component;

/**
 * Created by stefanangelov on 7/10/16.
 */
public abstract class Software extends Component {

    private int capacityConsumption;
    private int memoryConsumption;

    private SoftwareEnum softwareEnum;

    public Software(SoftwareEnum softwareEnum ,String name, int capacityConsumption, int memoryConsumption) {
        super(name);
        setSoftwareEnum(softwareEnum);
        calculateCapacity(capacityConsumption);
        calculateMemory(memoryConsumption);
    }

    public SoftwareEnum getSoftwareEnum() {
        return softwareEnum;
    }


    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    protected void setSoftwareEnum(SoftwareEnum softwareEnum) {
        this.softwareEnum = softwareEnum;
    }


    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

}
