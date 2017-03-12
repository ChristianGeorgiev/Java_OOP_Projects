package NeedForSpeed;

import java.util.LinkedHashMap;

public class CarManager {
    private LinkedHashMap<Integer, Car> cars;
    private LinkedHashMap<Integer, Race> races;
    private Garage garage;

    public CarManager(){
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability){
        Car car = null;
        if (type.equals("Performance")){
            car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            this.cars.put(id, car);

        }else if (type.equals("Show")){
            car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            this.cars.put(id, car);
        }
        this.cars.put(id, car);
    }


    public String check(int id){
        return this.cars.get(id).toString();
    }


    public void open(int id, String type, int length, String route, int prizePool){
        Race race = null;
        switch (type){
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                break;
            default:break;
        }
        this.races.put(id, race);
    }

    public void open(int id, String type, int length, String route, int prizePool, int extraParam){
        Race race = null;
        switch (type){
            case "Circuit":
                race = new CircuitRace(length, route, prizePool, extraParam);
                break;
            case "TimeLimit":
                race = new TimeLimitRace(length,route,prizePool,extraParam);
                break;
                default:break;
        }
        this.races.put(id, race);
    }


    public void participate(int carId, int raceId){
        if (!this.races.get(raceId).isClosed()) {
            this.races.get(raceId).addParticipant(carId, this.cars.get(carId));

        }
    }

    public String start(int id) {
        if (!this.races.get(id).getParticipants().isEmpty() || this.races.get(id).getParticipants().size() != 0) {
            return this.races.get(id).toString();
        }else {
            return "Cannot start the race with zero participants.";
        }
    }

    public void park(int id){
        this.cars.get(id).setParked(true);
        this.garage.park(id, this.cars.get(id));
    }

    public void unpark(int id){
        this.cars.get(id).setParked(false);
        this.garage.unpark(id);

    }

    public void tune(int tuneIndex, String addOn){
        this.garage.tune(tuneIndex, addOn);
    }

}
