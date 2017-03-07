package ex2;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKM;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKM, double tankCapacity){
       this.setFuelQuantity(fuelQuantity);
       this.setFuelConsumptionPerKM(fuelConsumptionPerKM);
       this.setTankCapacity(tankCapacity);
    }

    protected double getTankCapacity() {
        return this.tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity) {
        if (tankCapacity <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumptionPerKM() {
        return this.fuelConsumptionPerKM;
    }

    protected void setFuelConsumptionPerKM(double fuelConsumptionPerKM) {
        this.fuelConsumptionPerKM = fuelConsumptionPerKM;
    }

    public abstract String drive(double distance);
    public abstract void refuel(double fuelAmount);

    public abstract String toString();

}
