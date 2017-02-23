package ex7;

public class Car {
    private static final String DEFAULT_COLOR = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car (String model, Engine engine, int weight, String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car (String model, Engine engine, int weight){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = DEFAULT_COLOR;
    }

    public Car (String model, Engine engine, String color){
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = color;
    }

    public Car (String model, Engine engine){
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = DEFAULT_COLOR;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        if (this.weight >= 0){
            return String.format("%s:%n%s%n  Weight: %d%n  Color: %s",
                    this.model, this.engine.toString(), this.weight, this.color);
        }else {
            return String.format("%s:%n%s%n  Weight: %s%n  Color: %s",
                    this.model, this.engine.toString(), "n/a", this.color);
        }
    }
}
