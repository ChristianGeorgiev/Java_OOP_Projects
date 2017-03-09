package SystemSplit.Components.Hardware;

public class HeavyHardwareComponent extends HardwareComponent{

    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, "Heavy", capacity * 2, memory - (memory/4));
    }
}
