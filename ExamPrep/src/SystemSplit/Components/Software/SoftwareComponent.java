package SystemSplit.Components.Software;

import SystemSplit.Components.Component;

public abstract class SoftwareComponent extends Component {
    private int capacityConsumption;
    private int memoryConsumption;

    protected SoftwareComponent(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type);
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
    }

    @Override
    public int getCapacity() {
        return this.capacityConsumption;
    }

    @Override
    public int getMemory() {
        return this.memoryConsumption;
    }
}
