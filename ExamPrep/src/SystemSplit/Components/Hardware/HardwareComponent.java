package SystemSplit.Components.Hardware;

import SystemSplit.Components.Component;
import SystemSplit.Components.Software.SoftwareComponent;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class HardwareComponent extends Component {
    private int maxCapacity;
    private int maxMemory;
    private Map<String, SoftwareComponent> softwareComponents;

    protected HardwareComponent(String name, String type, int maxCapacity, int maxMemory) {
        super(name, type);
        this.maxCapacity = maxCapacity;
        this.maxMemory = maxMemory;
        this.softwareComponents = new LinkedHashMap<>();
    }

    public Map<String, SoftwareComponent> getSoftwareComponents(){
        return Collections.unmodifiableMap(this.softwareComponents);
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
        this.softwareComponents.putIfAbsent(softwareComponent.getName(), softwareComponent);
    }

    public void releaseSoftwareComponent(String componentName){
        if (this.softwareComponents.containsKey(componentName)) {
            this.softwareComponents.remove(componentName);
        }
    }
}
