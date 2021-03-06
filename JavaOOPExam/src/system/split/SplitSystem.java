package system.split;

import system.split.hardware.Hardware;
import system.split.common.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by stefanangelov on 7/10/16.
 */
//TODO: This class should be Singelton
public class SplitSystem {

    private List<Hardware> hardwares;

    public SplitSystem(){
        hardwares = new ArrayList<>();
    }

    public void addHardware(Hardware hardware){
        if(!isHardwareExist(hardware.getName())){
            hardwares.add(hardware);
        }
    }

    public Hardware getHardware(String hardwareName){
        for(Hardware hardware: hardwares){
            if(hardware.getName().equals(hardwareName)){
                return  hardware;
            }
        }
        return null;
    }

    public void releaseSoftware(List<String> argumerns){
        Hardware hardware =getHardware(argumerns.get(1));
        if(hardware!=null){
            hardware.releaseSoftware(argumerns.get(2));
        }
    }

    public void systemAnalysis(){
        System.out.println(Configuration.SYSTEM_ANALYSIS);
        mainInformation();

    }

    public void systemSplit(){
        sortHardware();
        printInformationForHardware();

    }

    protected  void mainInformation(){
        System.out.println("Hardware Components: "+ hardwares.size());
        System.out.println("Software Components: "+ calculateNumberOfSoftware());
        System.out.println("Total Operational Memory: "+calculateUseMemory()+" / "+calculateMaxMemory());
        System.out.println("Total Capacity Taken: "+calculateUseCapacity()+" / "+calculateMaxCapacity());
    }
    private boolean isHardwareExist(String hardwareName){
        List<Hardware> temp = hardwares.stream().filter(s->s.getName().equals(hardwareName)).collect(Collectors.toList());
        if(temp.isEmpty()){
            return false;
        }
        return true;
    }

    private void printInformationForHardware() {
        for(Hardware hardare: hardwares){
            hardare.printInformation();
        }
    }

    private int calculateMaxCapacity(){
        return  hardwares.stream().mapToInt(Hardware::getMaximumCapacity).sum();
    }

    private int calculateMaxMemory(){
        return  hardwares.stream().mapToInt(Hardware::getMaximumMemory).sum();
    }

    private int calculateUseCapacity(){
        return  hardwares.stream().mapToInt(Hardware::useCapacity).sum();
    }

    private int calculateUseMemory(){
        return  hardwares.stream().mapToInt(Hardware::useMomory).sum();
    }

    private int calculateNumberOfSoftware(){
        int number = hardwares.stream().mapToInt(Hardware::getNumberOfSoftware).sum();
        return  number;
    }

    private void sortHardware(){
        hardwares = hardwares.stream().sorted((first, second)->{
            int result = 0;
            if(first.getHardwareEnum().getOrder()<second.getHardwareEnum().getOrder()){
                result =1;
            }else{
                result =0;
            }
            return result;
        }).collect(Collectors.toList());
    }

}
