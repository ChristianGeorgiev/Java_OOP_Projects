package SystemSplit;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class HardwareComponent extends Component {
    private int maxCapacity;
    private int maxMemory;
    private Map<String, SoftwareComponent> expressSoftwareComponents;
    private Map<String, SoftwareComponent> lightSoftwareComponents;
    private Map<String, SoftwareComponent> softwareComponents;

    protected HardwareComponent(String name, String type, int maxCapacity, int maxMemory) {
        super(name, type);
        this.maxCapacity = maxCapacity;
        this.maxMemory = maxMemory;
        this.expressSoftwareComponents = new LinkedHashMap<>();
        this.lightSoftwareComponents = new LinkedHashMap<>();
        this.softwareComponents = new LinkedHashMap<>();
    }

    protected Map<String, SoftwareComponent> getSoftwareComponents(){
        return Collections.unmodifiableMap(this.softwareComponents);
    }

    protected Map<String, SoftwareComponent> getExpressSoftwareComponents(){
        return Collections.unmodifiableMap(this.expressSoftwareComponents);
    }

    protected Map<String, SoftwareComponent> getLightSoftwareComponents(){
        return Collections.unmodifiableMap(this.lightSoftwareComponents);
    }

    @Override
    public int getCapacity() {
        return this.maxCapacity;
    }

    @Override
    public int getMemory() {
        return this.maxMemory;
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent){
        if (softwareComponent.getCapacity() <= this.getCapacity() - getUsedCapacity()
                && softwareComponent.getMemory() <= this.getMemory() - getUsedMemory()) {

            if (softwareComponent.getType().equals("Express")) {
                this.expressSoftwareComponents.put(softwareComponent.getName(), softwareComponent);
                this.softwareComponents.put(softwareComponent.getName(), softwareComponent);
            } else {
                this.lightSoftwareComponents.put(softwareComponent.getName(), softwareComponent);
                this.softwareComponents.put(softwareComponent.getName(), softwareComponent);
            }
        }
    }

    public void releaseSoftwareComponent(String componentName){
        if (this.lightSoftwareComponents.containsKey(componentName)){
            this.lightSoftwareComponents.remove(componentName);
            this.softwareComponents.remove(componentName);
        }else if (this.expressSoftwareComponents.containsKey(componentName)){
            this.expressSoftwareComponents.remove(componentName);
            this.softwareComponents.remove(componentName);
        }
    }

    protected int getUsedMemory(){
        return this.expressSoftwareComponents.values().stream().mapToInt(x -> x.getMemory()).sum()                          + this.lightSoftwareComponents.values().stream().mapToInt(x -> x.getMemory()).sum();
    }

    protected int getUsedCapacity(){
       return this.expressSoftwareComponents.values().stream().mapToInt(x -> x.getCapacity()).sum()                          + this.lightSoftwareComponents.values().stream().mapToInt(x -> x.getCapacity()).sum();
    }
}
