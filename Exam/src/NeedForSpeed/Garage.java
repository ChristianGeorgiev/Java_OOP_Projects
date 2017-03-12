package NeedForSpeed;

import java.util.LinkedHashMap;

public class Garage {
    private LinkedHashMap<Integer, Car> parkedCars;

    public Garage(){
        this.parkedCars = new LinkedHashMap<>();
    }

    public void park(int id, Car car){
        if (!car.isRacing()) {
            this.parkedCars.put(id, car);
        }
    }

    public void unpark(int id){
        this.parkedCars.remove(id);
    }

    public void tune(int tuneIndex, String addOn){
        if (!this.parkedCars.isEmpty() || this.parkedCars.size() != 0) {
            for (Integer integer : this.parkedCars.keySet()) {
                this.parkedCars.get(integer).tuneHPandSusp(tuneIndex);

                if (this.parkedCars.get(integer).getType().equals("Performance")) {
                    this.parkedCars.get(integer).addAddOn(addOn);
                } else if (this.parkedCars.get(integer).getType().equals("Show")) {
                    this.parkedCars.get(integer).addStars(tuneIndex);
                }
            }
        }
    }
}
