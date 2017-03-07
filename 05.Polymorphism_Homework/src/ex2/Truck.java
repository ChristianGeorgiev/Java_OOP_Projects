package ex2;

import java.text.DecimalFormat;

public class Truck extends Vehicle {


    public Truck(double fuelQuantity, double fuelConsumptionPerKM, double tankCapcity) {
        super(fuelQuantity, fuelConsumptionPerKM + 1.6, tankCapcity);
    }

    @Override
    public String drive(double distance) {
        double canTravel = super.getFuelQuantity() / super.getFuelConsumptionPerKM();

        if (distance <= canTravel){
            super.setFuelQuantity(super.getFuelQuantity() - (super.getFuelConsumptionPerKM() * distance));
            DecimalFormat decimalFormat = new DecimalFormat("#.#####################");
            return String.format("Truck travelled %s km", decimalFormat.format(distance));
        }else {
            return "Truck needs refueling";
        }
    }

    @Override
    public void refuel(double fuelAmount) {
            super.setFuelQuantity(super.getFuelQuantity() + (fuelAmount * 0.95));
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }
}
