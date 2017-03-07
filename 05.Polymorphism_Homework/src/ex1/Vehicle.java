package ex1;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKM;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKM){
       this.setFuelQuantity(fuelQuantity);
       this.setFuelConsumptionPerKM(fuelConsumptionPerKM);
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected double getFuelConsumptionPerKM() {
        return this.fuelConsumptionPerKM;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumptionPerKM(double fuelConsumptionPerKM) {
        this.fuelConsumptionPerKM = fuelConsumptionPerKM;
    }

    public abstract String drive(double distance);
    public abstract void refuel(double fuelAmount);

    public abstract String toString();

}
