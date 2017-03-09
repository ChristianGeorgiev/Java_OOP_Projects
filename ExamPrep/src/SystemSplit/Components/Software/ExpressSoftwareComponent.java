package SystemSplit.Components.Software;

public class ExpressSoftwareComponent extends SoftwareComponent {

    public ExpressSoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name, "Express", capacityConsumption, memoryConsumption * 2);
    }
}
