package NeedForSpeed;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car{
    private List<String> addOns;
    private static final String PERFORMANCE_TYPE = "Performance";

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower,
                             int acceleration, int suspension, int durability) {

        super(brand, model,PERFORMANCE_TYPE, yearOfProduction,
                horsepower + (horsepower * 50) / 100, acceleration,
                suspension - (suspension * 25)/100, durability);

        this.addOns = new ArrayList<>();
    }

    @Override
    public void addAddOn(String addOn){
        this.addOns.add(addOn);
    }

    @Override
    public void addStars(int stars) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        if (!this.addOns.isEmpty() || this.addOns.size()!=0) {
            sb.append(String.format("Add-ons: %s", String.join(", ", this.addOns)));
        }else {
            sb.append("Add-ons: None");
        }

        return sb.toString();
    }
}
