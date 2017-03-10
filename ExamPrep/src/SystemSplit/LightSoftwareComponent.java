package SystemSplit;

public class LightSoftwareComponent extends SoftwareComponent{

    public LightSoftwareComponent(String name, int capacity, int memory) {
        super(name, "Light", capacity + (capacity / 2),
                memory - (memory / 2));
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
