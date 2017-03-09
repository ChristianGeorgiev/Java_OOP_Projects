package Paw_Inc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CleansingCenter extends Center {
    private Map<String, List<Animal>> animalsForCleansing;

    protected CleansingCenter(String name) {
        super(name);
        this.animalsForCleansing = new HashMap<>();
    }

    protected int getAwaitingAnimalsCount(){
        int count = 0;
        for (String s : animalsForCleansing.keySet()) {
            count += animalsForCleansing.get(s).size();
        }
        return count;
    }

    protected void recieveAnimalsForCleansing(String centerName, List<Animal> animals){
        if (this.animalsForCleansing.containsKey(centerName)){
            this.animalsForCleansing.get(centerName).addAll(animals);
        }else {
            this.animalsForCleansing.put(centerName, animals);
        }
    }

    protected List<String> cleanse(HashMap<String, AdoptionCenter> adoptionCenters){
        List<String> cleansedAnimals = new ArrayList<>();

        for (String centerName : this.animalsForCleansing.keySet()) {
            for (Animal animal : this.animalsForCleansing.get(centerName)) {
                animal.cleanse();
                cleansedAnimals.add(animal.getName());
                adoptionCenters.get(centerName).addAnimal(animal);
            }
        }
        this.animalsForCleansing = new HashMap<>();

        return cleansedAnimals;
    }


}
