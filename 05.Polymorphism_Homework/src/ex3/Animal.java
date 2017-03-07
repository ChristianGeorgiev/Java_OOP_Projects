package ex3;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalType;
    private String animalName;
    private double animalWeight;
    private int foodEaten;

    protected Animal(String animalType, String animalName, double animalWeight) {
        this.setAnimalType(animalType);
        this.setAnimalName(animalName);
        this.setAnimalWeight(animalWeight);
        this.foodEaten = 0;
    }

    protected String getAnimalName() {
        return this.animalName;
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    private void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    protected Double getAnimalWeight() {
        return this.animalWeight;
    }

    private void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    protected int getFoodEaten() {
        return this.foodEaten;
    }

    private void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }



    protected abstract String makeSound();
    protected abstract void eat(Food food);



}
