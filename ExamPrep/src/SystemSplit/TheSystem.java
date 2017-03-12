package SystemSplit;

import java.util.LinkedHashMap;

public class TheSystem {
    private LinkedHashMap<String, HardwareComponent> hardwareComponents = new LinkedHashMap<>();
    private LinkedHashMap<String, HardwareComponent> dump = new LinkedHashMap<>();

    public void dump(String hardwareComponentName){
        if (this.hardwareComponents.containsKey(hardwareComponentName)){
            this.dump.put(this.hardwareComponents.get(hardwareComponentName).getName(),
                    this.hardwareComponents.get(hardwareComponentName));
            this.hardwareComponents.remove(hardwareComponentName);
        }
    }

    public void restore(String hardwareComponentName){
        if (this.dump.containsKey(hardwareComponentName)){
            this.hardwareComponents.put(hardwareComponentName, this.dump.get(hardwareComponentName));
            this.dump.remove(hardwareComponentName);
        }
    }

    public void destroy(String hardwareComponentName){
        if (this.dump.containsKey(hardwareComponentName)){
            this.dump.remove(hardwareComponentName);
        }
    }

    public String dumpAnalyze(){
        String sb = String.format("Dump Analysis%nPower Hardware Components: %d%n", this.dump.values()
                .stream().filter(x -> x.getType().equals("Power")).count()) +
                String.format("Heavy Hardware Components: %d%n", this.dump.values()
                        .stream().filter(x -> x.getType().equals("Heavy")).count()) +
                String.format("Express Software Components: %d%n",
                        getDumpSoftwareComponentCount("Express")) +
                String.format("Light Software Components: %d%n", getDumpSoftwareComponentCount("Light")) +
                String.format("Total Dumped Memory: %d%n", this.dump.values().stream()
                        .flatMapToInt(x -> x.getSoftwareComponents().values().stream().mapToInt(y -> y.getMemory()))
                        .sum()) +
                String.format("Total Dumped Capacity: %d", this.dump.values().stream()
                        .flatMapToInt(x -> x.getSoftwareComponents().values().stream().mapToInt(y -> y.getCapacity()))
                        .sum());
        return sb;
    }

    private int getDumpSoftwareComponentCount(String type){
        int count = 0;
        for (String s : this.dump.keySet()) {
            if(type.equals("Express")){
                count+= this.dump.get(s).getExpressSoftwareComponents().size();
            }else {
                count+= this.dump.get(s).getLightSoftwareComponents().size();
            }
        }
        return count;
    }

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
            this.hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(sc);
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory){
        if (this.hardwareComponents.containsKey(hardwareComponentName)){
            SoftwareComponent sc = new LightSoftwareComponent(name, capacity, memory);
            this.hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(sc);
            }
        }


    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName){
        if (this.hardwareComponents.containsKey(hardwareComponentName)){
            this.hardwareComponents.get(hardwareComponentName).releaseSoftwareComponent(softwareComponentName);

        }
    }

    public String analyze(){
        String sb = String.format("System Analysis%nHardware Components: %d%n", countHardwareComponents(this.hardwareComponents)) +
                String.format("Software Components: %d%n", countSoftwareComponents(this.hardwareComponents)) +
                String.format("Total Operational Memory: %d / %d%n", calcTotalMemoryInUse(this.hardwareComponents),
                        calcMaxMemory(this.hardwareComponents)) +
                String.format("Total Capacity Taken: %d / %d", calcTotalTakenCapacity(this.hardwareComponents),
                        calcTotalCapacity(this.hardwareComponents));

        return sb;
    }

    public String split(){
        StringBuilder sb = new StringBuilder();
        this.hardwareComponents.values()
                               .stream()
                               .sorted((a, b) -> b.getType().compareTo(a.getType()))
                               .forEach(x -> {
                                   sb.append(String.format("Hardware Component - %s%n", x.getName()));
                                   sb.append(String.format("Express Software Components - %d%n",
                                           x.getExpressSoftwareComponents().size()));
                                   sb.append(String.format("Light Software Components - %d%n",
                                           x.getLightSoftwareComponents().size()));
                                   sb.append(String.format("Memory Usage: %d / %d%n",
                                           x.getUsedMemory(), x.getMemory()));
                                   sb.append(String.format("Capacity Usage: %d / %d%n",
                                           x.getUsedCapacity(), x.getCapacity()));
                                   sb.append(String.format("Type: %s%n", x.getType()));
                                   if (x.getSoftwareComponents() != null && !x.getSoftwareComponents().isEmpty()) {
                                       sb.append(String.format("Software Components: %s%n",
                                               String.join(", ", x.getSoftwareComponents().keySet())));
                                   }else {
                                       sb.append(String.format("Software Components: None%n"));
                                   }
                               });
        return sb.toString();
    }

    private int calcTotalCapacity(LinkedHashMap<String, HardwareComponent> hardwareComponents) {
        int totalCapacity = 0;
        for (String s : hardwareComponents.keySet()) {
            totalCapacity += hardwareComponents.get(s).getCapacity();
        }
        return totalCapacity;
    }

    private int calcTotalTakenCapacity(LinkedHashMap<String, HardwareComponent> hardwareComponents) {
        int takenCapacity = 0;

        for (String s : hardwareComponents.keySet()) {
            for (String s1 : hardwareComponents.get(s).getExpressSoftwareComponents().keySet()) {
                takenCapacity += hardwareComponents.get(s).getExpressSoftwareComponents().get(s1).getCapacity();
            }
            for (String s1 : hardwareComponents.get(s).getLightSoftwareComponents().keySet()) {
                takenCapacity += hardwareComponents.get(s).getLightSoftwareComponents().get(s1).getCapacity();
            }
        }
        return takenCapacity;
    }

    private int calcMaxMemory(LinkedHashMap<String, HardwareComponent> hardwareComponents) {
        int maxMemory = 0;
        for (String s : hardwareComponents.keySet()) {
            maxMemory += hardwareComponents.get(s).getMemory();
        }
        return maxMemory;
    }

    private int calcTotalMemoryInUse(LinkedHashMap<String, HardwareComponent> hardwareComponents) {
        int totalMemory = 0;
        for (String s : hardwareComponents.keySet()) {
            for (String s1 : hardwareComponents.get(s).getExpressSoftwareComponents().keySet()) {
                totalMemory += hardwareComponents.get(s).getExpressSoftwareComponents().get(s1).getMemory();
            }
            for (String s1 : hardwareComponents.get(s).getLightSoftwareComponents().keySet()) {
                totalMemory += hardwareComponents.get(s).getLightSoftwareComponents().get(s1).getMemory();
            }
        }
        return totalMemory;
    }

    private int countSoftwareComponents(LinkedHashMap<String, HardwareComponent> hardwareComponents) {
        int count = 0;
        for (String s : hardwareComponents.keySet()) {
            for (String s1 : hardwareComponents.get(s).getLightSoftwareComponents().keySet()) {
                count++;
            }
            for (String s1 : hardwareComponents.get(s).getExpressSoftwareComponents().keySet()) {
                count++;
            }
        }
        return count;
    }

    private int countHardwareComponents(LinkedHashMap<String, HardwareComponent> hardwareComponents) {
        return hardwareComponents.size();
    }




}
