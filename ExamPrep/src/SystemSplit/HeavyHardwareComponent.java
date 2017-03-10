package SystemSplit;

public class HeavyHardwareComponent extends HardwareComponent{

    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, "Heavy", capacity * 2, memory - (memory/4));
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
