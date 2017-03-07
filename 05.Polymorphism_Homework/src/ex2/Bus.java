package ex2;


import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumptionPerKM, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKM, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        double oldFuelConsumption = super.getFuelConsumptionPerKM();
        super.setFuelConsumptionPerKM(oldFuelConsumption + 1.4);

        double canTravel = super.getFuelQuantity() / super.getFuelConsumptionPerKM();
        if (distance <= canTravel){
            super.setFuelQuantity(super.getFuelQuantity() - (super.getFuelConsumptionPerKM() * distance));
            super.setFuelConsumptionPerKM(oldFuelConsumption);
            DecimalFormat decimalFormat = new DecimalFormat("#.#####################");
            return String.format("Bus travelled %s km", decimalFormat.format(distance));
        }else {
            super.setFuelConsumptionPerKM(oldFuelConsumption);
            return "Bus needs refueling";
        }
    }

    public String driveEmpty(double distance){
        double canTravel = super.getFuelQuantity() / super.getFuelConsumptionPerKM();
        if (distance <= canTravel){
            super.setFuelQuantity(super.getFuelQuantity() - (super.getFuelConsumptionPerKM() * distance));
            DecimalFormat decimalFormat = new DecimalFormat("#.#####################");
            return String.format("Bus travelled %s km", decimalFormat.format(distance));
        }else {
            return "Bus needs refueling";
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
        return String.format("Bus: %.2f", super.getFuelQuantity());
    }
}
