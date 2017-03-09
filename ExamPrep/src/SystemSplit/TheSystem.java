package SystemSplit;

import SystemSplit.Components.Hardware.HardwareComponent;
import SystemSplit.Components.Hardware.HeavyHardwareComponent;
import SystemSplit.Components.Hardware.PowerHardwareComponent;
import SystemSplit.Components.Software.ExpressSoftwareComponent;
import SystemSplit.Components.Software.LightSoftwareComponent;
import SystemSplit.Components.Software.SoftwareComponent;

import java.util.HashMap;

public class TheSystem {
    private HashMap<String, HardwareComponent> hardwareComponents = new HashMap<>();

    public void registerPowerHardware(String name, int capacity, int memory){
        HardwareComponent hc = new PowerHardwareComponent(name, capacity, memory);
        this.hardwareComponents.put(name, hc);
    }

    public void registerHeavyHardware(String name, int capacity, int memory){
        HardwareComponent hc = new HeavyHardwareComponent(name, capacity, memory);
        this.hardwareComponents.put(name, hc);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory){
        if (this.hardwareComponents.containsKey(hardwareComponentName)){
            SoftwareComponent sc = new ExpressSoftwareComponent(name, capacity, memory);
            if (sc.getCapacity() <= this.hardwareComponents.get(hardwareComponentName).getCapacity()
                && sc.getMemory() <= this.hardwareComponents.get(hardwareComponentName).getMemory()) {

                this.hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(sc);
            }
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory){
        if (this.hardwareComponents.containsKey(hardwareComponentName)){
            SoftwareComponent sc = new LightSoftwareComponent(name, capacity, memory);
            if (sc.getCapacity() <= this.hardwareComponents.get(hardwareComponentName).getCapacity()
                    && sc.getMemory() <= this.hardwareComponents.get(hardwareComponentName).getMemory()) {

                this.hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(sc);
            }
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName){
        if (this.hardwareComponents.containsKey(hardwareComponentName)){
            this.hardwareComponents.get(hardwareComponentName).releaseSoftwareComponent(softwareComponentName);
        }
    }

    public String analyze(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("System Analysis%nHardware Components: %d%n", countHardwareComponents(this.hardwareComponents)));
        sb.append(String.format("Software Components: %d%n", countSoftwareComponents(this.hardwareComponents)));
        sb.append(String.format("Total Operational Memory: %d / %d%n", calcTotalMemoryInUse(this.hardwareComponents),
                calcMaxMemory(this.hardwareComponents)));
        sb.append(String.format("Total Capacity Taken: %d / %d", calcTotalTakenCapacity(this.hardwareComponents),
                calcTotalCapacity(this.hardwareComponents)));

        return sb.toString();
    }

    public String split(){
        // TODO:
        /*
        Hardware Component – {componentName}
        Express Software Components: {countOfExpressSoftwareComponents}
        Light Software Components: {countOfLightSoftwareComponents}
        Memory Usage: {memoryUsed} / {maximumMemory}
        Capacity Usage: {capacityUsed} / {maximumCapacity}
        Type: {Power/Heavy}
        Software Components: {softwareComponent1, softwareComponent2…}”*/
    }

    private int calcTotalCapacity(HashMap<String, HardwareComponent> hardwareComponents) {
        int totalCapacity = 0;
        for (String s : hardwareComponents.keySet()) {
            totalCapacity += hardwareComponents.get(s).getCapacity();
        }
        return totalCapacity;
    }

    private int calcTotalTakenCapacity(HashMap<String, HardwareComponent> hardwareComponents) {
        int takenCapacity = 0;
        for (String s : hardwareComponents.keySet()) {
            for (String s1 : hardwareComponents.get(s).getSoftwareComponents().keySet()) {
                takenCapacity += hardwareComponents.get(s).getSoftwareComponents().get(s1).getCapacity();
            }
        }
        return takenCapacity;
    }

    private int calcMaxMemory(HashMap<String, HardwareComponent> hardwareComponents) {
        int maxMemory = 0;
        for (String s : hardwareComponents.keySet()) {
            maxMemory += hardwareComponents.get(s).getMemory();
        }
        return maxMemory;
    }

    private int calcTotalMemoryInUse(HashMap<String, HardwareComponent> hardwareComponents) {
        int totalMemory = 0;
        for (String s : hardwareComponents.keySet()) {
            for (String s1 : hardwareComponents.get(s).getSoftwareComponents().keySet()) {
                totalMemory += hardwareComponents.get(s).getSoftwareComponents().get(s1).getMemory();
            }
        }
        return totalMemory;
    }

    private int countSoftwareComponents(HashMap<String, HardwareComponent> hardwareComponents) {
        int count = 0;
        for (String s : hardwareComponents.keySet()) {
            for (String s1 : hardwareComponents.get(s).getSoftwareComponents().keySet()) {
                count++;
            }
        }
        return count;
    }

    private int countHardwareComponents(HashMap<String, HardwareComponent> hardwareComponents) {
        return hardwareComponents.size();
    }




}
