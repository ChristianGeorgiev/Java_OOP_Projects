package Paw_Inc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CleansingCenter extends Center {
    private Map<String, List<Animal>> storedAnimals;

    protected CleansingCenter(String name) {
        super(name);
        this.storedAnimals = new HashMap<>();
    }

    public void addAnimals(String centerName, List<Animal> animals){
        this.storedAnimals.put(centerName,animals);
    }

    public void cleanse(HashMap<String, AdoptionCenter> adoptionCenters){
        for (String centerName : this.storedAnimals.keySet()) {

        }
    }
}
