package Paw_Inc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdoptionCenter extends Center {
    private List<Animal> storedAnimals;

    protected AdoptionCenter(String name) {
        super(name);
        this.storedAnimals = new ArrayList<>();
    }

    public void sendForCleansing(String centerName, CleansingCenter cleansingCenter){
        cleansingCenter.addAnimals(centerName, storedAnimals);
        this.storedAnimals = new ArrayList<>();
    }
}
