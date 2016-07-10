package system.split.software;

/**
 * Created by stefanangelov on 7/10/16.
 */
public class ExpressSoftware extends  Software {

    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(SoftwareEnum.EXPRESS_SOFTWARE,name, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void calculateMemory(int memory) {
        int currentMemory = memory *2;
        setMemoryConsumption(currentMemory);
    }

    @Override
    protected void calculateCapacity(int capacity) {
        setCapacityConsumption(capacity);
    }
}
