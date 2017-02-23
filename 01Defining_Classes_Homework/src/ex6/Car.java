package ex6;

import java.util.HashSet;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private HashSet<Tire> tires;


    public boolean tirePressureLessThanOne(){
        for (Tire tire : tires) {
            if (tire.getPressure() < 1){
                return true;
            }
        }
        return false;
    }

    public Car(String model, Engine engine, Cargo cargo, HashSet<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public HashSet<Tire> getTires() {
        return tires;
    }

    public void setTires(HashSet<Tire> tires) {
        this.tires = tires;
    }

    @Override
    public String toString(){
        return model;
    }
}
