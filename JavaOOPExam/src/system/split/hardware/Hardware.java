package system.split.hardware;

import system.split.common.Component;
import system.split.software.Software;
import system.split.software.SoftwareEnum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by stefanangelov on 7/10/16.
 */
public abstract class Hardware extends Component {

    private int maximumCapacity;
    private int maximumMemory;

    private ArrayList<Software> softwares;

    private HardwareEnum hardwareEnum;


    {
        softwares = new ArrayList<>();
    }

    protected Hardware(HardwareEnum hardwareEnum,String name, int capacity, int memory) {
        super(name);
        setHardwareEnum(hardwareEnum);
        calculateCapacity(capacity);
        calculateMemory(memory);
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    public HardwareEnum getHardwareEnum() {
        return hardwareEnum;
    }

    public int useCapacity(){
        return softwares.stream().mapToInt(Software::getCapacityConsumption).sum();
    }

    public int useMomory(){
        return softwares.stream().mapToInt(Software::getMemoryConsumption).sum();
    }

    public void addSoftware(Software software){
        if(chechMemoryAndCapacity(software)) {
            softwares.add(software);
        }
    }
    public int getNumberOfSoftware(){
        return softwares.size();
    }

    public int getNumberExpress(){
        return softwares.stream().filter(f->f.getSoftwareEnum().equals(SoftwareEnum.EXPRESS_SOFTWARE)).collect(Collectors.toList()).size();
    }

    public int getNumberLight(){
        return softwares.stream().filter(f->f.getSoftwareEnum().equals(SoftwareEnum.LIGHT_SOFTWARE)).collect(Collectors.toList()).size();
    }

    public void printInformation(){

        System.out.println("Hardware Component - "+ this.getName());
        System.out.println("Express Software Components - "+getNumberExpress());
        System.out.println("Light Software Components - "+getNumberLight());
        System.out.println("Memory Usage: "+useMomory()+" / "+getMaximumMemory());
        System.out.println("Capacity Usage: "+useCapacity()+" / "+getMaximumCapacity());
        System.out.println("Type: "+this.getHardwareEnum().getName());
        System.out.println("Software Components: " + namesOfList().toString().replace("[","").replace("]",""));
    }

    protected  List<String> namesOfList(){
            List<String> names = softwares.stream().map(Software::getName).collect(Collectors.toList());
        if(names.isEmpty()){
            names.add("None");
        }
        return names;
    }
    protected void setHardwareEnum(HardwareEnum hardwareEnum) {
        this.hardwareEnum = hardwareEnum;
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    private boolean chechMemoryAndCapacity(Software software){
            if( isExistSoftware(software.getName()) ||
                useCapacity()+software.getCapacityConsumption()>maximumCapacity ||
                useMomory() +software.getMemoryConsumption()>maximumMemory){
            return false;
        }
        return true;
    }

    private boolean isExistSoftware(String softwareName){
        List<Software> temp = softwares.stream().filter(s->s.getName().equals(softwareName)).collect(Collectors.toList());
        if(temp.isEmpty()){
            return false;
        }
        return true;
     }


    public void releaseSoftware(String nameOfSofware) {
        for (Iterator<Software> i = softwares.iterator(); i.hasNext();) {
            Software element = i.next();
            if (element.getName().equals(nameOfSofware)) {
                i.remove();
            }
        }
    }
}
