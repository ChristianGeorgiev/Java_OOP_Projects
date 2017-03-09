package SystemSplit.Components.Software;

public class LightSoftwareComponent extends SoftwareComponent{

    public LightSoftwareComponent(String name, int capacity, int memory) {
        super(name, "Light", capacity + (capacity / 2),
                memory - (memory / 2));
    }
}
