package Paw_Inc;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AnimalCenterManager {
    private HashMap<String, AdoptionCenter> adoptionCenters = new HashMap<>();
    private HashMap<String, CleansingCenter> cleansingCenters = new HashMap<>();

    private List<String> adoptedAnimals = new ArrayList<>();
    private List<String> cleansedAnimals = new ArrayList<>();

    public void registerCleansingCenter(String name){
        CleansingCenter cleansingCenter = new CleansingCenter(name);
        this.cleansingCenters.put(name, cleansingCenter);
    }
    public void registerAdoptionCenter(String name){
        AdoptionCenter adoptionCenter = new AdoptionCenter(name);
        this.adoptionCenters.put(name, adoptionCenter);
    }
    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName){
        Animal dog = new Dog(name, age, learnedCommands);
        this.adoptionCenters.get(adoptionCenterName).addAnimal(dog);
    }
    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName){
        Animal cat = new Cat(name, age, intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).addAnimal(cat);
    }
    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName){
        this.adoptionCenters.get(adoptionCenterName).sendForCleansing(this.cleansingCenters.get(cleansingCenterName));
    }
    public void cleanse(String cleansingCenterName){
        this.cleansedAnimals.addAll(cleansingCenters.get(cleansingCenterName).cleanse(this.adoptionCenters));
    }
    public void adopt(String adoptionCenterName){
        adoptedAnimals.addAll(adoptionCenters.get(adoptionCenterName).adopt());
    }
    public void printStatistics(){
        int animalsAwaitingAdoption = 0;
        int animalsAwaitingCleansing = 0;

        for (String s : adoptionCenters.keySet()) {
            for (Animal animal : adoptionCenters.get(s).getStoredAnimals()) {
                if (animal.isCleansed()){
                    animalsAwaitingAdoption++;
                }
            }
        }

        for (String s : cleansingCenters.keySet()) {
            animalsAwaitingCleansing += cleansingCenters.get(s).getAwaitingAnimalsCount();
        }
        Collections.sort(adoptedAnimals, Collator.getInstance());
        Collections.sort(cleansedAnimals, Collator.getInstance());

        System.out.println("Paw Incorporative Regular Statistics");
        System.out.printf("Adoption Centers: %d%n", adoptionCenters.size());
        System.out.printf("Cleansing Centers: %d%n", cleansingCenters.size());

        if (adoptedAnimals.size() > 0) {
            System.out.printf("Adopted Animals: %s%n", String.join(", ", adoptedAnimals));
        }else {
            System.out.println("Adopted Animals: None");
        }

        if (cleansedAnimals.size() > 0) {
            System.out.printf("Cleansed Animals: %s%n", String.join(", ", cleansedAnimals));
        }else {
            System.out.println("Cleansed Animals: None");
        }

        System.out.printf("Animals Awaiting Adoption: %d%n", animalsAwaitingAdoption);
        System.out.printf("Animals Awaiting Cleansing: %d%n", animalsAwaitingCleansing);
    }
}
