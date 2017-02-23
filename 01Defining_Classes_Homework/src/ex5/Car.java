package ex5;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelPer1km;
    private int kilometersTraveled;

    public Car (String model, double fuelAmount, double fuelPer1km){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPer1km = fuelPer1km;
    }

    public void drive (int kilometers){
            double requiredFuel = kilometers * fuelPer1km;
            if (requiredFuel <= fuelAmount) {
                this.kilometersTraveled += kilometers;
                this.fuelAmount -= requiredFuel;
            }else {
                System.out.println("Insufficient fuel for the drive");
            }
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelPer1km() {
        return this.fuelPer1km;
    }

    public void setFuelPer1km(double fuelPer1km) {
        this.fuelPer1km = fuelPer1km;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.kilometersTraveled);
    }
}
