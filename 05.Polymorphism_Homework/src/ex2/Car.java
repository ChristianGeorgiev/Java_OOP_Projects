package ex2;

import java.text.DecimalFormat;

public class Car extends Vehicle {


    public Car(double fuelQuantity, double fuelConsumptionPerKM, double tankCapcity) {
        super(fuelQuantity, fuelConsumptionPerKM + 0.9, tankCapcity);
    }

    @Override
    public String drive(double distance) {
        double canTravel = super.getFuelQuantity() / super.getFuelConsumptionPerKM();
        if (distance <= canTravel){
            super.setFuelQuantity(super.getFuelQuantity() - (super.getFuelConsumptionPerKM() * distance));
            DecimalFormat decimalFormat = new DecimalFormat("#.#####################");
            return String.format("Car travelled %s km", decimalFormat.format(distance));
        }else {
            return "Car needs refueling";
        }
    }

    @Override
    public void refuel(double fuelAmount) {
        if (fuelAmount <=  (super.getTankCapacity() - super.getFuelQuantity())) {
            super.setFuelQuantity(super.getFuelQuantity() + fuelAmount);
        }else {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }

}
