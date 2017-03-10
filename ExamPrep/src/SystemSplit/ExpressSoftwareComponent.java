package SystemSplit;

public class ExpressSoftwareComponent extends SoftwareComponent {

    public ExpressSoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name, "Express", capacityConsumption, memoryConsumption * 2);
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public int getMemory() {
        return super.getMemory();
    }
}
