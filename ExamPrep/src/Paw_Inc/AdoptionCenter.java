package Paw_Inc;

import java.util.*;

public class AdoptionCenter extends Center {

    protected AdoptionCenter(String name) {
        super(name);
    }

    protected void sendForCleansing(CleansingCenter cleansingCenter){
        List<Animal> uncleansedAnimals = new ArrayList<>();

        for (Animal animal : this.getStoredAnimals()) {
            if (!animal.isCleansed()){
                uncleansedAnimals.add(animal);
            }
        }

        cleansingCenter.recieveAnimalsForCleansing(this.getName(), uncleansedAnimals);
    }


    protected List<String> adopt(){
        List<String> adoptedAnimals = new ArrayList<>();
        List<Animal> toRemove = new ArrayList<>();

        for (Animal animal : this.getStoredAnimals()) {
            if (animal.isCleansed()){
                    if (!adoptedAnimals.contains(animal.getName())) {
                        adoptedAnimals.add(animal.getName());
                    }
                toRemove.add(animal);
            }
        }
        for (Animal animal : toRemove) {
            this.removeAnimal(animal);
        }
        return adoptedAnimals;
    }
}
