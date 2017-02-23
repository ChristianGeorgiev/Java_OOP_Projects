package ex7;

public class Engine {
    private static final String DEFAULT_EFFICIENCY = "n/a";

    private String model;
    private String power;
    private int displacement;
    private String efficiency;

    public Engine (String model, String power, int displacement, String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine (String model, String power, int displacement){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = DEFAULT_EFFICIENCY;
    }

    public Engine (String model, String power, String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = efficiency;
    }

    public Engine (String model, String power){
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = DEFAULT_EFFICIENCY;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return this.power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getDisplacement() {
        return this.displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString(){
        if (this.displacement >= 0) {
            return String.format("  %s:%n    Power: %s%n    Displacement: %d%n    Efficiency: %s",
                                this.model, this.power, this.displacement, this.efficiency);
        }else{
            return String.format("  %s:%n    Power: %s%n    Displacement: %s%n    Efficiency: %s",
                    this.model, this.power, "n/a", this.efficiency);
        }
    }
}
