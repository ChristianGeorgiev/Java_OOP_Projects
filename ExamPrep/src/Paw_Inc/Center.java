package Paw_Inc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Center {
    private String name;
    private List<Animal> storedAnimals;

    protected Center(String name){
        this.setName(name);
        this.storedAnimals = new ArrayList<>();
    }

    protected List<Animal> getStoredAnimals() {
        return Collections.unmodifiableList(this.storedAnimals);
    }

    public void removeAnimal(Animal animal){
        this.storedAnimals.remove(animal);
    }

    public void addAnimal(Animal animal){
        this.storedAnimals.add(animal);
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

}
