package SystemSplit;

public class PowerHardwareComponent extends HardwareComponent {

    public PowerHardwareComponent(String name, int capacity, int maxMemory) {
        super(name, "Power", capacity / 4, maxMemory + (3 *(maxMemory / 4)));
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
